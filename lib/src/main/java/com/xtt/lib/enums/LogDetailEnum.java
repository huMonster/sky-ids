package com.xtt.lib.enums;

/**
 * @Description LogDetailEnum
 * @Author Monster
 * @Date 2021/3/16 15:34
 * @Version 1.0
 */
public enum LogDetailEnum {
    /**
     * 默认
     */
    UNKNOWN(1, "未知日志"),
    /**
     * 设备日志
     */
    ADD_DEVICE_SPLIT(10001, "新增用户分屏模板"),
    DEVICE_CONTROL(10002, "远程控制"),
    BIND_DEVICE(10003, "绑定设备"),
    UNBIND_DEVICE(10004, "解绑设备"),
    SET_DEVICE_TAG(10005, "设置设备标签"),
    MOVE_DEVICE_GROUP(10006, "移动设备分组"),
    SET_DEVICE_LOCATION(10007, "标注设备位置"),
    SYNC_DEVICE_DATA(10008, "同步设备信息"),
    UPDATE_DEVICE_INFO(10009, "修改设备信息"),
    ADD_GROUP_FOR_DEVICE(10010, "新增分组"),
    UPDATE_GROUP_FOR_DEVICE(10011, "修改分组"),
    REMOVE_GROUP_FOR_DEVICE(10012, "删除分组"),
    MOVE_GROUP_FOR_DEVICE(10013, "移动分组"),
    SET_VOLUME(10014, "设置音量"),
    SET_BRIGHTNESS(10015, "设置亮度"),
    REMOTE_CONTROL(10016, "遥控器按键操作"),
    SHUTDOWN(10017, "关机"),
    REBOOT(10018, "重启"),
    CLEAR_FILE(10019, "清空缓存"),
    CLEAR_PROGRAM(10020, "清空节目"),
    CLEAR_INNERCUT(10021, "清空插播"),
    CLEAR_DOWNLOAD(10022, "清空下载"),
    ADD_CAPTION_INNERCUT(10023, "插播字幕"),
    SET_SWITCHING_PLAN(10024, "定时开关机"),
    SET_REBOOT_PLAN(10025, "定时重启"),
    SET_VOLUME_PLAN(10026, "定时音量"),
    PLAY(10027, "播放"),
    PAUS(10028, "暂停"),
    STOP(10029, "停止"),
    REPLAY(10030, "重播"),
    PREV(10031, "上一页"),
    NEXT(10032, "下一页"),
    FF(10033, "快进"),
    FR(10034, "快退"),
    PREV_CHANNEL(10035, "上一频道"),
    NEXT_CHANNEL(10036, "下一频道"),
    SCREENSHOT(10037, "截图"),
    UPDATE_PLAY_STATUS(10038, "更新播放状态"),
    GET_DOWNLOAD_PROGRESS(10039, "获取下载进度"),
    SET_SPILT_SCREEN(10040, "设置分屏"),
    PROGRAM_INNERCUT(10041, "插播节目"),
    GET_PLAY_LIST(10042, "获取播放列表"),
    UPDATE_DEVICE_SPLIT(10043, "修改用户分屏模板"),
    DELETE_DEVICE_SPLIT(10044, "删除用户分屏模板"),
    DEVICE_RELATION_SPLIT(10045, "新增或修改设备关联分屏"),
    DELETE_DEVICE_RELATION_SPLIT(10046, "删除设备关联分屏"),
    SET_DEVICE_PERMISSION(40001, "设置用户设备权限"),
    REMOVE_DEVICE_PERMISSION(40002, "删除用户设备权限"),
    REGISTER_DEVICE_BATCH(10047, "注册设备"),
    DISABLE_OR_ENABLE_DEVICE(10048, "禁止与启用设备"),
    CHECK_BIND_DEVICE(10049, "确认安装设备"),
    OTA_UPDATE_DEVICE(10050, "OTA升级"),
    LED_ON_OFF(10051, "LED开关屏"),
    /**设备日志**/


    /**
     * 素材日志
     **/
    MATERIAL_CREATE_DIR(20001, "创建文件夹"),
    MATERIAL_GEN_FILE_PATH(20002, "生成文件上传路径"),
    MATERIAL_DEL_FILES(20003, "删除文件列表"),
    MATERIAL_DEL_FILES_PATH(20004, "通过文件路径删除文件列表"),
    MATERIAL_AUTH_FILE(20005, "审核文件"),
    MATERIAL_RENAME_FILE(20006, "文件重命名"),
    MATERIAL_MOVE_FILE(20007, "移动文件"),
    MATERIAL_UPLOAD_FILE(20008, "上传小文件"),
    /**素材日志**/

    /**
     * 用户日志
     **/
    USER_EDIT(40003, "用户编辑"),
    USER_EDIT_PRIVACY(40004, "修改用户隐私信息"),
    USER_DEL_BY_ID(40005, "删除用户"),
    USER_IMPORT(40006, "批量导入用户"),
    USER_MOVE(40007, "移动用户"),
    USER_DEL_BATCH(40008, "批量删除用户"),
    USER_CREATE_COMPANY(40009, "创建公司"),
    USER_INVITE_APPLY_AUDIT(40010, "邀请、申请用户加入公司"),
    USER_CHANGE_COMPANY(40011, "用户切换公司"),
    USER_LOGOUT(40012, "退出登录"),
    USER_ADD(40013, "添加用户"),
    USER_UPDATE_STATE(40014, "启用、禁用用户"),
    ADD_GROUP_FOR_USER(40015, "新增分组"),
    UPDATE_GROUP_FOR_USER(40016, "修改分组"),
    REMOVE_GROUP_FOR_USER(40017, "删除分组"),
    MOVE_GROUP_FOR_USER(40018, "移动分组"),
    ADD_USER_ROLE(40019, "添加角色"),
    UPDATE_USER_ROLE(40020, "编辑角色"),
    DELETE_USER_ROLE(40021, "删除角色"),
    ADD_ROLE_PERMISSION(40022, "添加角色权限"),
    ADD_USER_TO_ROLE(40023, "角色添加用户"),
    DELETE_USER_TO_ROLE(40024, "角色删除用户"),
    COPY_ROLE(40025, "复制角色"),
    ENABLE_USER_ADD_COMPANY(40026, "允许用户加入公司"),

    /**用户日志**/
    /**
     * 系统设置
     **/
    ADD_TAG(50005, "新增标签"),
    UPDATE_TAG(50006, "修改标签"),
    REMOVE_TAG(50007, "删除标签"),
    INSERT_DEVICE_DOWNTIME(50008, "设置终端下载时间"),
    INSERT_DEVICE_BASE_SETTING(50009, "保存终端基本设置"),
    INSERT_SYSTEM_CUSTOM_SETTING(50010, "设置系统自定义配置"),
    /**
     * 系统设置
     **/
    AUTHORIZATION(70001, "授权管理");

    private int value;

    private String describe;

    LogDetailEnum(int value, String describe) {
        this.value = value;
        this.describe = describe;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
