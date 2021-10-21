package com.example.demo.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorMessage {

    public static final ErrorMessage UNKNOWN_ERROR = new ErrorMessage("An error occurred please try again ","unknown_error");

    @JsonProperty("message")
    private String message;

    @JsonProperty("error_code")
    private String errorCode;

    public ErrorMessage(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
