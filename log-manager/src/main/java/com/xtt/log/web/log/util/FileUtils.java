package com.xtt.log.web.log.util;

import com.xtt.log.web.log.kafka.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description FileUtils
 * @Author Monster
 * @Date 2021/3/17 17:53
 * @Version 1.0
 */
@Component
@Slf4j
public class FileUtils {

    private final KafkaProducer KAFKA_SENDER;

    @Autowired
    public FileUtils(KafkaProducer kafkaProducer) {
        this.KAFKA_SENDER = kafkaProducer;
    }

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    public static List<String> fileStreamToString(MultipartFile file) throws IOException {
        String msg = "";
        List<String> dataList = new ArrayList<>();
        try (InputStream is = file.getInputStream(); BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            int line = 0;
            String str;
            while (true) {
                str = bufferedReader.readLine();
                if (str != null) {
                    if (line < 1000) {
                        line++;
                    } else {
                        dataList.add(msg);
                        msg = "";
                        line = 0;
                    }
                    msg += str;
                } else {
                    dataList.add(msg);
                    break;
                }
            }
        }
        return dataList;
    }
}
