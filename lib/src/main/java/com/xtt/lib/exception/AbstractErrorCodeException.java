package com.xtt.lib.exception;

import com.xtt.lib.generic.RestResult;

/**
 * @Description 自定义抽象异常，所有继承该类的异常都可以向前台抛出自定义错误码，
 *              【只生效于抛出到controller的异常】
 * @Author Monster
 * @Date 2021/3/18 14:10
 * @Version 1.0
 */
public abstract class AbstractErrorCodeException extends Exception{

    public AbstractErrorCodeException() {
    }

    public AbstractErrorCodeException(String message) {
        super(message);
    }

    public abstract <T> RestResult<T> response();
}
