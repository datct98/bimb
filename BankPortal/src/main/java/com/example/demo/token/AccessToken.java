package com.example.demo.token;

public class AccessToken {

    private String access_token;

    private String refresh_token;

    private long expire_date;

    public AccessToken() {

    }

    public AccessToken(String access_token, long expire_date) {
        this.access_token = access_token;
        this.expire_date = expire_date;
    }

    public AccessToken(String access_token, String refresh_token) {
        this.access_token = access_token;
        this.refresh_token = refresh_token;
    }

    public AccessToken(String access_token, String refresh_token, long expire_date) {
        this.access_token = access_token;
        this.refresh_token = refresh_token;
        this.expire_date = expire_date;
    }

    public void setRefreshToken(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getAccessToken() {
        return access_token;
    }

    public String getRefreshToken() {
        return refresh_token;
    }

    public long getExpired() {
        return expire_date;
    }

}
