package com.xtt.lib.enums;

/**
 * @Description OperationType
 * @Author Monster
 * @Date 2021/3/17 11:08
 * @Version 1.0
 */
public enum OperationType {
    /**
     * 操作类型
     */
    UNKNOWN("UNKNOWN"),
    INSERT("INSERT"),
    DELETE("DELETE"),
    UPDATE("UODATE"),
    SELECT("SELECT"),
    ;
    private String value;

    OperationType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
