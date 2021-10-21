package com.example.demo.model;

import com.example.demo.constant.Message;
import com.example.demo.controller.body.UserBody;
import com.example.demo.controller.response.AuthResponse;
import com.example.demo.controller.response.BaseResponse;
import com.example.demo.model.entities.Token;
import com.example.demo.model.entities.User;
import com.example.demo.model.repository.TokenRepository;
import com.example.demo.model.repository.UsersRepository;
import com.example.demo.token.AccessToken;
import com.example.demo.token.TokenFactory;
import com.example.demo.untils.Log;
import com.example.demo.untils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;

@Configuration
public class UserModel extends BaseModel{

}
