package com.example.demo.controller.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MessageResponse {
    @JsonIgnore
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return message == null || message.isEmpty();
    }

}
