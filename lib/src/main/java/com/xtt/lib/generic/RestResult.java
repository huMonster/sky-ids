package com.xtt.lib.generic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.xtt.lib.exception.ErrorCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description RestResult
 * @Author Monster
 * @Date 2021/3/17 17:08
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResult<T> {

    private String reqId;
    private Integer code;
    private String msg;
    private T data;


    public RestResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> RestResult<T> ok(){
        return new RestResult<>(ErrorCode.OK.getCode(), ErrorCode.OK.getMsg(), null);
    }

    public static <T> RestResult<T> ok(T data){
        return new RestResult<>(ErrorCode.OK.getCode(), ErrorCode.OK.getMsg(), data);
    }

    public static <T> RestResult<T> error(){
        return new RestResult<>(ErrorCode.SYSTEM_ERROR.getCode(), ErrorCode.SYSTEM_ERROR.getMsg(), null);
    }

    public static <T> RestResult<T> error(String msg) {
        return new RestResult<>(ErrorCode.SYSTEM_ERROR.getCode(), msg, null);
    }

    public static <T> RestResult<T> error(T data) {
        return new RestResult<>(ErrorCode.SYSTEM_ERROR.getCode(), ErrorCode.SYSTEM_ERROR.getMsg(), data);
    }

    public static <T> RestResult<T> gen(Integer code, String msg, T data) {
        return new RestResult<>(code, msg, data);
    }

    public static <T> RestResult<T> gen(ErrorCode code) {
        return new RestResult<>(code.getCode(), code.getMsg(), null);
    }

    public static <T> RestResult<T> gen(ErrorCode code, String msg) {
        return new RestResult<>(code.getCode(), StringUtils.isEmpty(msg) ? code.getMsg() : msg, null);
    }

    public static <T> RestResult<T> gen(ErrorCode code, T data) {
        if (data instanceof String) {
            return gen(code, (String) data);
        }
        return new RestResult<>(code.getCode(), code.getMsg(), data);
    }

    @JsonIgnore
    public boolean isOk() {
        return ErrorCode.OK.getCode().equals(getCode());
    }

    @JsonIgnore
    public boolean isNotOk() {
        return !ErrorCode.OK.getCode().equals(getCode());
    }
}
