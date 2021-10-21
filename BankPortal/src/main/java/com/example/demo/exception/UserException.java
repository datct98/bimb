package com.example.demo.exception;

import com.example.demo.exception.common.ExceptionCreater;
import com.example.demo.exception.common.IBaseException;

public class UserException implements IBaseException {
    private String message;

    public UserException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getCode() {
        return ExceptionCreater.USER_ERROR;
    }
}
