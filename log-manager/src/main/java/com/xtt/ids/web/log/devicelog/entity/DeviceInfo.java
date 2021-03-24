package com.xtt.ids.web.log.devicelog.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @Description DeviceInfo
 * @Author Monster
 * @Date 2021/3/17 17:49
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DeviceInfo extends BaseDeviceLog{
    private String id;

    private String deviceType;

    private String ip;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String resolution;
}
