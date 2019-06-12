package com.xym.spring.transaction;

/**
 * @Author: xym760
 * @Date: 2019/6/12 16:35
 * @Description:
 */
public class UserAccountException extends RuntimeException {
    private static final long serialVersionUID = -6809499779158560427L;

    public UserAccountException() {
    }

    public UserAccountException(String message) {
        super(message);
    }

    public UserAccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAccountException(Throwable cause) {
        super(cause);
    }

    public UserAccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
