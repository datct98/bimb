package com.example.demo.exception.common;

import com.example.demo.model.entities.ErrorMessage;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletException;

public class ServerException extends ServletException {

    private ErrorMessage error;
    private HttpStatus statusCode;


    public ServerException(HttpStatus status, ErrorMessage errorMessage) {
        this.statusCode = status;
        this.error = errorMessage;
    }

    public ErrorMessage getError() {
        return error;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}
