package com.xym.spring.transaction;

/**
 * @Author: xym760
 * @Date: 2019/6/12 16:17
 * @Description:
 */
public class BookStockException extends RuntimeException {

    private static final long serialVersionUID = 358783519546840834L;

    public BookStockException() {
    }

    public BookStockException(String message) {
        super(message);
    }

    public BookStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookStockException(Throwable cause) {
        super(cause);
    }

    public BookStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
