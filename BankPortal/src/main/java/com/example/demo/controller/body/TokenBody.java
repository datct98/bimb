package com.example.demo.controller.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TokenBody {
    @JsonProperty
    private String access_token;
    @JsonProperty
    private String refresh_token;
}
