package com.xtt.ids.web.operationlog.entity;

import lombok.Data;

import java.util.List;

/**
 * @Description UserLog
 * @Author Monster
 * @Date 2021/3/11 15:35
 * @Version 1.0
 */
@Data
public class UserLog {
    private String companyId;
    private List<String> userId;
    private List<String> operationUnit;
    private List<String> describe;
    private List<String> ip;
    private String platform;
}
