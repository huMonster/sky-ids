package com.xtt.ids.web.controller;

import com.xtt.lib.enums.LogDetailEnum;
import com.xtt.lib.enums.OperationUnit;
import com.xtt.lib.util.NetworkUtil;
import com.xtt.lib.util.SnowflakeIdWorker;
import com.xtt.web.log.LogAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description TestController
 * @Author Monster
 * @Date 2021/3/16 13:48
 * @Version 1.0
 */
@RestController
@Slf4j(topic = "test-log")
public class TestController {

    @Resource
    private SnowflakeIdWorker snowflakeIdWorker;

    @GetMapping("/test")
//    @LogAnnotation(detail = LogDetailEnum.USER_ADD, operationUnit = OperationUnit.USER_MANAGEMENT, userId = "5e0076cdef60a761b95a47d0", companyId = "393799836148699136")
    @LogAnnotation(detail = LogDetailEnum.USER_ADD, operationUnit = OperationUnit.USER_MANAGEMENT, userId = "#user.userId", companyId = "#user.companyId")
    public void test(HttpServletRequest request){
        log.info("目标机器：" + NetworkUtil.getIpAddress(request));
    }
}
