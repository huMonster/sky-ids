package com.xtt.ids.web.controller;

import com.xtt.lib.enums.LogDetailEnum;
import com.xtt.lib.enums.OperationUnit;
import com.xtt.lib.util.SnowflakeIdWorker;
import com.xtt.web.log.LogAnnotation;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description TestController
 * @Author Monster
 * @Date 2021/3/16 13:48
 * @Version 1.0
 */
@RestController
public class TestController {

    @Resource
    private SnowflakeIdWorker snowflakeIdWorker;

    @GetMapping("/test")
    @LogAnnotation(detail = LogDetailEnum.USER_ADD, operationUnit = OperationUnit.USER_MANAGEMENT, userId = "5e0076cdef60a761b95a47d0", companyId = "393799836148699136")
    public void test(){
        long id = snowflakeIdWorker.nextId();
        System.out.println("测试方法: " + id);
    }


}
