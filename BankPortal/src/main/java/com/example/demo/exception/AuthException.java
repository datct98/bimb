package com.example.demo.exception;

import com.example.demo.exception.common.ExceptionCreater;
import com.example.demo.exception.common.IBaseException;

public class AuthException implements IBaseException {
    private String message;

    public AuthException(String message){
        this.message = message;
    }

    public AuthException() {
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getCode() {
        return ExceptionCreater.AUTH_ERROR;
    }
}
