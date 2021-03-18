package com.xtt.log.web.log.devicelog.entity;

import lombok.Data;

/**
 *
 * @author XieBOFei
 * @date 2019/5/15
 */
@Data
public abstract class BaseDeviceLog {
    private Long platformId;
    private String deviceId;
    private String companyId;
    private Integer eventId;
    private String eventName;
    private Long eventTime;
    private Long createTime;

}
