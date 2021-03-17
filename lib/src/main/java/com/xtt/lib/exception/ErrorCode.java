package com.xtt.lib.exception;

/**
 * @Description ErrorCode 状态码
 * @Author Monster
 * @Date 2021/3/17 17:14
 * @Version 1.0
 */
public enum ErrorCode {
    /**
     * 默认值
     */
    OK(1, "成功"),
    SYSTEM_ERROR(10001, "系统错误"),
    SERVICE_UNAVAILABLE(10002, "服务不可用"),
    PARAMETER_REQUIRED(10003, "缺少参数"),
    PARAMETER_ILLEGAL(10004, "非法参数"),
    SERVICE_ERROR(10005, "系统服务异常"),
    NO_FOUND(10006, "资源不存在"),
    UNAUTHORIZED(10007, "无权访问"),
    SERVICE_READ_TIMEOUT(10008, "系统服务响应超时"),
    ILLEGAL_REQUEST(10012, "非法请求"),
    REQUEST_TIMEOUT(10013, "请求超时"),
    SESSION_TIMEOUT(10014, "会话超时"),
    REQUEST_UNSUPPORTED(10015, "请求方式错误"),
    REQUEST_CONTENT_TYPE_UNSUPPORTED(10016, "请求媒体类型错误"),
    REPEATED_REQUEST(10017, "重复提交"),
    CODING(10018, "此功能正在开发中..."),
    INCOMPLETE_INFORMATION(10019, "输入信息不完整"),
    IP_LIMIT(10030, "错误操作过多，已被限制访问，请在[%s]分钟后重试"),
    ERROR_BASE64(10031, "base64文件处理失败"),
    FILE_TRANSFER_ERROR(10032, "文件传输异常"),
    INCORRECT_PWD_RULES(10033, "密码规则不符"),
    EXCEED_LIMIT(10034, "超出条件限制，详情请参阅API文档"),
    INVALID_CAPTCHA(10035, "验证码错误"),
    RISK_CONTROL(10036, "风控提醒"),
    RC_INVALID_CAPTCHA(10037, "风控验证码错误"),

    /**
     * 21XXX: OAuth 系统
     */
    AUTH_FAILURE(21001, "认证失败"),
    AUTH_PARAMETER_ABSENT(21003, "缺少参数"),
    AUTH_TYPE_UNSUPPORTED(21004, "认证类型不支持"),
    AUTH_CLIENT_ILLEGAL(21010, "非法客户端"),
    AUTH_CLIENT_FORBIDDEN(21011, "客户端被禁"),
    AUTH_CLIENT_AUTH_FAILURE(21012, "接入端认证失败"),
    AUTH_REQUEST_EXPIRED(21013, "URL请求过期"),
    AUTH_CODE_EXPIRED(21020, "code 已经失效"),
    AUTH_TOKEN_EXPIRED(21021, "access_token 已经失效"),
    AUTH_INVALID_TOKEN(21022, "非法 token"),
    AUTH_PWD_ERROR(21023, "账号不存在或密码错误"),
    AUTH_PWD_TIME_OUT(21024, "密码过期"),
    AUTH_UNKNOWN_USER(21025, "账号不存在"),
    AUTH_USER_INFO_MISMATCH(21026, "用户信息不一致"),
    AUTH_REFRESH_TOKEN_EXPIRED(21027, "refresh_token 已经失效"),
    AUTH_PASSPORT_ERROR(21028, "账号中心调用异常"),
    AUTH_UNSUPPORTED_SIGNATURE_METHOD(21029, "不支持的签名算法"),
    AUTH_REQUEST_REPLAY(21030, "重复请求"),
    AUTH_INVALID_CSRF_TOKEN(21031, "无效的CSRF_TOKEN"),
    AUTH_DECRYPTION_FAILED(21032, "解密失败"),
    AUTH_ACCOUNT_HAS_BOUND_WX(21033, "该账号已绑定其他微信"),
    AUTH_REFRESH_LIMITED(21034, "refresh_token刷新次数限制"),
    AUTH_WX_HAS_BOUND_ACCOUNT(21035, "该微信已绑定其他账号"),
    AUTH_WX_HAS_NOT_BOUND_ACCOUNT(21036, "该微信未绑定账号"),


    /**
     * 31XXX:user 系统
     */
    USER_EXIST(31001, "账号已存在"),
    USER_NOT_PERMISSION(31002, "账号无权限"),
    USER_INCORRECT_PHONE_RULES(31003, "手机号规则不符"),
    USER_INCORRECT_EMAIL_RULES(31004, "邮箱规则不符"),
    USER_INCORRECT_ID_CARD_RULES(31005, "身份证规则不符"),
    USER_INCORRECT_PWD_RULES(31006, "密码规则不符"),
    USER_FROZEN(31007, "账号被冻结"),
    USER_NON_EXIST(31008, "账号不存在"),

    /**
     * 41XXX:device 系统
     */
    ALIYUN_IOT_ERROR(41001, "阿里云Iot调用异常"),
    PRODUCT_NOT_EXIST(41002, "产品不存在"),
    UNSUPPORTED_NET_TYPE(41003, "联网方式不支持"),
    ALREADY_EXISTED_PRODUCT_NAME(41004, "相同名称的产品已经存在"),
    DEVICE_EXIST(41005, "设备已存在"),
    DEVICE_NOT_EXIST(41006, "设备不存在"),
    DEVICE_IS_USED(41007, "设备已被使用"),
    SPILT_SCREEN_NOT_EXIST(41008, "分屏布局不存在"),
    PRODUCT_HAS_DEVICE(41009, "产品下有设备"),
    ILLEGAL_MAC_ERROR(41010, "非法的MAC地址格式"),
    DEVICE_NAME_LENGTH_LIMITED(41011, "设备名称长度超过限制"),
    DEVICE_ADDRESS_LENGTH_LIMITED(41012, "设备地址长度超过限制"),

    /**
     * 51XXX:order 系统
     */
    ORDER_NOT_EXIST(51001, "工单不存在"),


    /**
     * 61XXX:file 系统
     */
    FILE_EXIST(61001, "文件已存在"),
    FILE_OBS_ERROR(61002, "OBS系统错误"),
    FILE_NOT_EXIST(61003, "文件不存在"),

    ALREADY_EXISTED_GROUP_NAME(71001, "相同名称的分组已存在"),
    GROUP_NOT_EXIST(71002, "分组不存在"),
    GROUP_IS_USED(71003, "分组已被使用"),
    UNSUPPORTED_GROUP_TRANSFORM(71004, "不支持的分组移动方式"),
    GROUP_REMOVE_ILLEGAL(71005, "非法的分组删除操作"),

    ALREADY_EXISTED_TAG_NAME(72001, "相同名称的标签已存在"),
    TAG_NOT_EXIST(72002, "标签不存在"),
    TAG_IS_USED(72003, "标签已被使用"),
    /**
     * 81XXX:log 系统
     */
    SCROLL_QUERY_FAIL(81001, "SCROLL查询失败"),
    FROM_SIZE_QUERY_FAIL(81002, "FROMSIZE查询失败"),
    SEARCH_AFTER_QUERY_FAIL(81003, "SEARCHAFTER查询失败"),
    /**
     * 91XXX:ids 系统
     */
    SCREEN_HAVE_RELATION_DEVICE(91001, "存在设备关联，不允许删除"),
    ILLEGAL_CACHED_USER(91002, "缓存用户异常"),
    DEVICE_HAVE_RELATION(91003, "存在关联，不允许修改"),
    NAME_REPEAT(91004, "名称重复"),
    PROGRAM_USE(91005, "部分文件被节目引用，不能删除"),
    SCREEN_HAVE_RELATION_CHANNEL(91006, "存在频道关联，不允许删除"),
    FILE_MD5_NULL(91007, "文件上传过程中，MD5、名称不能为空"),
    FILE_LIST_NULL(91008, "文件上传过程中，上传的文件集合不能为空"),
    MOVE_NAME_REPEAT(91009, "相同名称的文件已存在"),
    DELETE_HAS_PRIVATE(91010, "文件夹中含有私有文件，不能删除"),

    /**
     * 91XXX:ids user系统
     */
    USERNAME_REPEAT(91201, "用户名重复"),
    PHONE_REPEAT(91202, "手机号重复"),
    EMAIL_REPEAT(91203, "邮箱重复"),
    COMPANY_NOT_EXIST(91204, "公司不存在"),
    JOIN_COMPANY_REPEAT(91205, "用户已经在该公司,请不要重复添加"),
    ADMIN_CAN_NOT_DEL(91206, "公司创始人不能删除"),
    AUTH_LICENSE_EXPIRED(91207, "公司授权到期"),
    AUTH_NUM_OVERFLOW(91208, "超过公司授权数量限制"),
    USER_OLD_PASSWORD_ERROR(91209, "旧密码错误"),
    IDS_USER_FORBIDDEN(91210, "用户被禁用"),
    NOT_STUFF(91211, "用户不在指定公司中"),


    /**
     * 91XXX:ids user系统
     */
    DNS_ERROR(91301, "创建子域名异常"),


    /**
     * 100XXX:push 系统
     */
    PUSH_SMS_ERROR(100001, "发送短信异常"),
    PUSH_SMS_LIMIT(100002, "发送短信超过次数限制"),
    ;
    private Integer code;
    private String msg;

    ErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
