package com.xtt.lib.enums;

/**
 * @Description OperationUnit
 * @Author Monster
 * @Date 2021/3/16 17:39
 * @Version 1.0
 */
public enum OperationUnit {
    /**
     * 被操作的模块
     */
    UNKNOWN("UNKNOWN", 000000),
    DEVICE_MANAGEMENT("DEVICE_MANAGEMENT", 100000),
    MATERIAL_MANAGEMENT("MATERIAL_MANAGEMENT", 200000),
    PROGRAMME_MANAGEMENT("PROGRAMME_MANAGEMENT", 300000),
    USER_MANAGEMENT("USER_MANAGEMENT", 400000),
    SYSTEM_SETTINGS("SYSTEM_SETTINGS", 500000),
    CHANNEL_MANAGEMENT("CHANNEL_MANAGEMENT", 600000),
    AUDIT_MANAGEMENT("AUDIT_MANAGEMENT", 700000),
    LOG_MANAGEMENT("LOG_MANAGEMENT", 800000),
    ORGANIZATION_MANAGEMENT("ORGANIZATION_MANAGEMENT", 900000);

    private String value;

    private int code;

    OperationUnit(String value, int code) {
        this.value = value;
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    // 根据value返回枚举类型,主要在switch中使用
    public static OperationUnit getByValue(int value) {
        for (OperationUnit code : values()) {
            if (code.getCode() == value) {
                return code;
            }
        }
        return OperationUnit.UNKNOWN;
    }
}
