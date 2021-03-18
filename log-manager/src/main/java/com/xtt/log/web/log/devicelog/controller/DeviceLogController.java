package com.xtt.log.web.log.devicelog.controller;

import com.xtt.lib.generic.RestResult;
import com.xtt.log.web.log.devicelog.service.DeviceLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @Description DeviceLogController
 * @Author Monster
 * @Date 2021/3/17 16:35
 * @Version 1.0
 */
@RestController
@Slf4j
public class DeviceLogController {

    @Resource
    private DeviceLogService deviceLogService;
    /**
     * 上传异常日志
     *
     * @param exceptionFile
     * @return
     */
    @GetMapping("/uploadExceptionLog")
    public RestResult uploadException(MultipartFile exceptionFile){
        Boolean isSuccess = deviceLogService.uploadDeviceExceptionLog(exceptionFile);
        if (isSuccess){
            return RestResult.ok();
        }
        return RestResult.error();
    }

    /**
     * 上传播放日志
     *
     * @param broadcastFile
     * @return
     */
    @PostMapping("/uploadBroadcastLog")
    public RestResult uploadBroadcastLog(@RequestParam("logBroadcastFile") MultipartFile broadcastFile){
        Boolean isSuccess = deviceLogService.uploadDeviceBroadcastLog(broadcastFile);
        if (isSuccess){
            return RestResult.ok();
        }
        return RestResult.error();
    }
}
