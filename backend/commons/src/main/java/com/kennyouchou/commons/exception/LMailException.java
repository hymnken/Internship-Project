package com.kennyouchou.commons.exception;

/**
 * <p>
 * 自定义邮件异常
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-01 17:39:20
 */
public class LMailException extends Exception {

    public LMailException() {
        super();
    }

    public LMailException(String message) {
        super(message);
    }

    public LMailException(String message, Throwable cause) {
        super(message, cause);
    }

    public LMailException(Throwable cause) {
        super(cause);
    }

    protected LMailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
