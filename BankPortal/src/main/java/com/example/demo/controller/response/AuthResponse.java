package com.example.demo.controller.response;

import com.example.demo.token.AccessToken;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthResponse {
    public AuthResponse(AccessToken accessToken) {
        this.accessToken = accessToken.getAccessToken();
        this.refreshToken = accessToken.getRefreshToken();
        this.expireDate = accessToken.getExpired();
    }

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expire_date")
    private long expireDate;
    @JsonProperty("refresh_token")
    private String refreshToken;

}
