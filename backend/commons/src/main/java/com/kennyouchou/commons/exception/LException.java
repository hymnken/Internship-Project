package com.kennyouchou.commons.exception;

/**
 * <p>
 * 自定义异常
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-01 17:39:20
 */
public class LException extends Exception {

    public LException() {
        super();
    }

    public LException(String message) {
        super(message);
    }

    public LException(String message, Throwable cause) {
        super(message, cause);
    }

    public LException(Throwable cause) {
        super(cause);
    }

    protected LException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
