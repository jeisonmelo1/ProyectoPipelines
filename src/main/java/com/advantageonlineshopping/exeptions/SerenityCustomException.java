package com.advantageonlineshopping.exeptions;

public class SerenityCustomException extends RuntimeException {
    public SerenityCustomException(String message) {
        super(message);
    }

    public SerenityCustomException(String message, Throwable cause) {
        super(message, cause);
    }
}