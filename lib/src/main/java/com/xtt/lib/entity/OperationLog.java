package com.xtt.lib.entity;

import lombok.Data;

/**
 * @Description 操作日志实体类
 * @Author Monster
 * @Date 2021/3/17 10:00
 * @Version 1.0
 */
@Data
public class OperationLog {
    private String id;
    private long createTime;
    private String companyId;
    /**
     * 被操作模块
     */
    private Integer operationUnit;
    /**
     * 方法名
     */
    private String method;
    /**
     * 参数
     */
    private String args;
    /**
     * 操作人Id
     */
    private String userId;
    /**
     * 操作人
     */
    private String username;
    /**
     * ip地址
     */
    private String ip;
    /**
     * 日志描述
     */
    private Integer describe;
    /**
     * 操作类型
     */
    private String operationType;
    /**
     * 方法运行时间
     */
    private Long runTime;
    /**
     * 方法返回值
     */
    private String returnValue;

    private String platform;

}
