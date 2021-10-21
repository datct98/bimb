package com.example.demo.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@Table(name = "users")
public class User extends IdEntity{

    public static final int LEVEL_USER = 1;
    public static final int LEVEL_ADMIN = 5;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "level")
    private Integer level;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "secure_code")
    private Integer secureCode;

    /*@Column(name = "last_time_used")
    private Date last_time_used;*/

    @Column(name = "created_at")
    private Date created;

  /*  @Column(name = "modified")
    private Long modified;*/


}
