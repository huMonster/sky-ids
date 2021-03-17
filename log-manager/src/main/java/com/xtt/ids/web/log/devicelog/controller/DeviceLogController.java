package com.xtt.ids.web.log.devicelog.controller;

import com.xtt.lib.generic.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description DeviceLogController
 * @Author Monster
 * @Date 2021/3/17 16:35
 * @Version 1.0
 */
@RestController
@Slf4j
public class DeviceLogController {
    /**
     * 上传异常日志
     * @param exceptionFile
     * @return
     */
    @PostMapping("/uploadExceptionLog")
    public RestResult uploadException(){

    }

}
