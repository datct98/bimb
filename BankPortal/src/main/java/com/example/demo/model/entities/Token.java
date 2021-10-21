package com.example.demo.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
@Table(name = "refresh_token")
public class Token extends IdEntity{

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "last_access_token")
    private String accessToken;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Column(name = "modified")
    private Timestamp modified;

    @Column(name = "expired_datetime")
    private Timestamp expiredDate;

    public Token(Integer userId, String accessToken, String refreshToken, Timestamp expiredDate) {
        this.userId = userId;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expiredDate = expiredDate;
    }
}
