package com.xtt.lib.exception;

import com.xtt.lib.generic.RestResult;

/**
 * @Description 服务异常
 * @Author Monster
 * @Date 2021/3/18 14:12
 * @Version 1.0
 */
public class ServiceException extends AbstractErrorCodeException {

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    @Override
    public <T> RestResult<T> response() {
        return RestResult.gen(ErrorCode.SERVICE_ERROR, this.getMessage());
    }
}
