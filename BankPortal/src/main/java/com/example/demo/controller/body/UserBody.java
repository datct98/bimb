package com.example.demo.controller.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserBody {
    @JsonProperty
    private String username;

    @JsonProperty
    private String password;

    @JsonProperty
    private String email;

    public boolean isValid() {
        return username.isEmpty() || password.isEmpty();
    }

    public boolean isValidFull() {
        return username.isEmpty() || password.isEmpty() || email.isEmpty();
    }

}
