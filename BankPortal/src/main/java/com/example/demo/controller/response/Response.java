package com.example.demo.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Response<T> implements Serializable {
    private static final String RESULT_OK = "ok";
    private static final String RESULT_ERROR = "error";

    @JsonProperty("result")
    private String result;

    @JsonProperty("data")
    private T data;

    @JsonProperty("error_code")
    private String errorCode;

    @JsonProperty("error_message")
    private String errorMessage;

    public Response(T data) {
        this.result = RESULT_OK;
        this.data = data;
    }

    public Response(String errorCode, String message) {
        this.result = RESULT_ERROR;
        this.errorCode = errorCode;
        this.errorMessage= message;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }


    public Response(){
        this.result = RESULT_OK;
    }
}
