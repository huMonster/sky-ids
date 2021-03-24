package com.xtt.ids.web.log.devicelog.service.impl;


import com.xtt.ids.elasticsearch.service.ElasticSearchService;
import com.xtt.ids.web.log.devicelog.service.DeviceLogService;
import com.xtt.ids.web.log.kafka.KafkaProducer;
import com.xtt.ids.web.log.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by XieBOFei on 2019/5/15.
 */
@Service
@Slf4j
public class DeviceLogServiceImpl implements DeviceLogService {
    @Autowired
    private ElasticSearchService elasticSearchService;
    @Value("${logFilePath}")
    private String logFilePath;
    @Value("${logFlowPath}")
    private String logFlowPath;

    @Value("#{'${spring.kafka.listener.topics}'.split(',')}")
    private List<String> topics;

    private final KafkaProducer KAFKA_SENDER;

    /**
     * IO密集型任务  = 一般为2*CPU核心数（常出现于线程中：数据库数据交互、文件上传下载、网络数据传输等等）
     * CPU密集型任务 = 一般为CPU核心数+1（常出现于线程中：复杂算法）
     * 混合型任务  = 视机器配置和复杂度自测而定
     */
    private static int corePoolSize = Runtime.getRuntime().availableProcessors();
    /**
     * public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,
     * TimeUnit unit,BlockingQueue<Runnable> workQueue)
     * corePoolSize用于指定核心线程数量
     * maximumPoolSize指定最大线程数
     * keepAliveTime和TimeUnit指定线程空闲后的最大存活时间
     * workQueue则是线程池的缓冲队列,还未执行的线程会在队列中等待
     * 监控队列长度，确保队列有界
     * 不当的线程池大小会使得处理速度变慢，稳定性下降，并且导致内存泄露。如果配置的线程过少，则队列会持续变大，消耗过多内存。
     * 而过多的线程又会 由于频繁的上下文切换导致整个系统的速度变缓——殊途而同归。队列的长度至关重要，它必须得是有界的，这样如果线程池不堪重负了它可以暂时拒绝掉新的请求。
     * ExecutorService 默认的实现是一个无界的 LinkedBlockingQueue。
     */
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, 2 * corePoolSize, 10L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(1000), new ThreadPoolExecutor.CallerRunsPolicy());

    @Autowired
    public DeviceLogServiceImpl(KafkaProducer kafka_sender) {
        KAFKA_SENDER = kafka_sender;
    }

    @Override
    public Boolean uploadDeviceOperationLog(MultipartFile file) {
        try {
            executor.execute(new FileToOperationString(file));
//            String operationLog = FileUtils.fileStreamToString(file);
//            KAFKA_SENDER.sendMessage(topics.get(1), operationLog);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean uploadDeviceExceptionLog(MultipartFile file) {
        try {
            executor.execute(new FileToExceptionString(file));
//            String exceptionLog = FileUtils.fileStreamToString(file);
//            KAFKA_SENDER.sendMessage(topics.get(0), exceptionLog);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean uploadDeviceOnOfOffFileLog(MultipartFile file) {
        try {
            executor.execute(new FileToOnOfOffString(file));
//            String onOfOffLog = FileUtils.fileStreamToString(file);
//            KAFKA_SENDER.sendMessage(topics.get(3), onOfOffLog);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean uploadDeviceLog(MultipartFile file) {
        long now = System.currentTimeMillis();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
        String filePath = logFilePath + date.format(now) + "/" + time.format(now) + "/";
        executor.execute(new FileUpload(file, filePath));
        return true;
    }

    @Override
    public Boolean uploadDeviceBroadcastLog(MultipartFile broadcastFile) {
        try {
            executor.execute(new FileToBroadcastString(broadcastFile));
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    static class FileUpload implements Runnable {

        MultipartFile file;
        String filePath;

        public FileUpload(MultipartFile file, String filePath) {
            this.file = file;
            this.filePath = filePath;
        }

        @Override
        public void run() {
            try {
                FileUtils.uploadFile(file.getBytes(), filePath, file.getOriginalFilename());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class FileToExceptionString implements Runnable {

        MultipartFile file;

        public FileToExceptionString(MultipartFile file) {
            this.file = file;
        }

        @Override
        public void run() {
            //log.info("线程开始");
            try {
                // List<String> listPlay= FileUtils.fileStreamToJson(file);
                List<String> exceptionLog = FileUtils.fileStreamToString(file);
                //log.info("传输上传日志");
                for(String exception:exceptionLog) {
                    KAFKA_SENDER.sendMessage(topics.get(0), exception);
                }
                //log.info("线程结束");
            } catch (Exception e) {

            }
        }
    }

    class FileToOperationString implements Runnable {

        MultipartFile file;

        public FileToOperationString(MultipartFile file) {
            this.file = file;
        }

        @Override
        public void run() {
           // log.info("线程开始");
            try {
                List<String> operationLog = FileUtils.fileStreamToString(file);
                //log.info("传输上传日志");
                for(String operation:operationLog) {
                    KAFKA_SENDER.sendMessage(topics.get(1), operation);
                }
                //log.info("线程结束");
            } catch (Exception e) {

            }
        }
    }

    class FileToOnOfOffString implements Runnable {

        MultipartFile file;

        public FileToOnOfOffString(MultipartFile file) {
            this.file = file;
        }

        @Override
        public void run() {
           // log.info("线程开始");
            try {
                List<String> onOfOffLog = FileUtils.fileStreamToString(file);
             //   log.info("传输上传日志");
                for(String onOfOff:onOfOffLog) {
                    KAFKA_SENDER.sendMessage(topics.get(3), onOfOff);
                }
             //   log.info("线程结束");
            } catch (Exception e) {

            }
        }
    }

    class FileToBroadcastString implements Runnable{

        MultipartFile file;

        public FileToBroadcastString(MultipartFile file) {
            this.file = file;
        }

        @Override
        public void run() {
            try {
                List<String> list = FileUtils.fileStreamToString(file);
                for (String broadcast : list) {
                    KAFKA_SENDER.sendMessage(topics.get(2), broadcast);
                }
            } catch (IOException e) {
                log.info("上传播放素材日志出错！");
            }
        }
    }
}
