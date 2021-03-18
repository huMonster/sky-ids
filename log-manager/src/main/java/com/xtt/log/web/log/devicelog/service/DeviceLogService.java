package com.xtt.log.web.log.devicelog.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Description 设备日志功能接口
 * @Author Monster
 * @Date 2021/3/16 13:48
 * @Version 1.0
 *
 */
public interface DeviceLogService {

    /**
     * 上传设备操作日志
     * @param file
     * @return
     */
    Boolean uploadDeviceOperationLog(MultipartFile file);

    /**
     * 上传异常日志
     * @param file
     * @return
     */
    Boolean uploadDeviceExceptionLog(MultipartFile file);

    /**
     * 上传开关机日志
     * @param file
     * @return
     */
    Boolean uploadDeviceOnOfOffFileLog(MultipartFile file);

    /**
     * 上传日志文件
     * @param file
     * @return
     */
    Boolean uploadDeviceLog(MultipartFile file);


    /**
     * 上传播放日志
     *
     * @param broadcastFile
     */
    Boolean uploadDeviceBroadcastLog(MultipartFile broadcastFile);
}
