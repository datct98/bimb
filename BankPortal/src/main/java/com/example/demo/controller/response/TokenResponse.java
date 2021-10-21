package com.example.demo.controller.response;

import com.example.demo.model.entities.Token;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class TokenResponse {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expire_date")
    private Timestamp expireDate;
    @JsonProperty("refresh_token")
    private String refreshToken;


    public TokenResponse(Token token) {
        this.accessToken = token.getAccessToken();
        this.refreshToken=token.getRefreshToken();
        this.expireDate=token.getExpiredDate();
    }
}
