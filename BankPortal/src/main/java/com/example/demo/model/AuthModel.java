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
public class AuthModel extends BaseModel{
    @Autowired
    private UsersRepository userRepository;
    @Autowired
    private TokenRepository tokenRepository;

    public BaseResponse<AuthResponse> loginUser(UserBody body){
        BaseResponse<AuthResponse> response = new BaseResponse<>(new AuthResponse());
        User user=null;
        if (!body.isValid()) {
            String passwordEncode = Utils.encodeMD5(body.getPassword());
            user= userRepository.findByUsernameAndPassword(body.getUsername(),passwordEncode);
            if (user == null) {
                Log.error("#loginUser","Account:"+body.getUsername()+" is not exists or wrong password");
                response.setMessage(getString().accountNotExitsOrPasswordWrong);
            }
        } else {
            Log.error("#loginUser","Username or password empty");
            response.setMessage(getString().accountNull);
        }
        if (response.isSuccess()) {
            AccessToken accessToken= new AccessToken
                    (TokenFactory.createAccessToken(user).getAccessToken(), TokenFactory.createAccessToken(user).getRefreshToken(), TokenFactory.createAccessToken(user).getExpired());
            response.setResponse(new AuthResponse(accessToken));
            Token token= tokenRepository.findByUserId(user.getId());
            token.setRefreshToken(accessToken.getRefreshToken());
            token.setAccessToken(accessToken.getAccessToken());
            tokenRepository.save(token);
        }
        return response;
    }

    public BaseResponse<AuthResponse> register(UserBody body){
        BaseResponse<AuthResponse> response = new BaseResponse<>(new AuthResponse());
        User user=new User();
        if(!body.isValidFull()){
            if(checkExitsUser(body)){
                response.setMessage(getString().accountExits);
                Log.error("#registerUser", "Account:"+body.getUsername()+" is existed");
                return response;
            } else {
                String passwordEncode = Utils.encodeMD5(body.getPassword());
                user.setUsername(body.getUsername());
                user.setPassword(passwordEncode);
                user.setLevel(User.LEVEL_USER);
                user.setEmail(body.getEmail());
                //user.setCreated(System.currentTimeMillis());
                System.out.println(Utils.getCurrentDate("YYY-mm-dd"));
                userRepository.save(user);
            }
        }else {
            Log.error("#registerUser","Username or password or email is null!");
            response.setMessage(Message.ERROR_INVALID_ACCOUNT);
            return response;
        }
        AccessToken accessToken= new AccessToken
                (TokenFactory.createAccessToken(user).getAccessToken(), TokenFactory.createAccessToken(user).getRefreshToken(), TokenFactory.createAccessToken(user).getExpired());
        response.setResponse(new AuthResponse(accessToken));
        tokenRepository.save(new Token(user.getId(),accessToken.getAccessToken(),accessToken.getRefreshToken(),new Timestamp(accessToken.getExpired())));
        return response;
    }

    private boolean checkExitsUser(UserBody user) {
        try {
            User account = userRepository.findFirstByUsernameOrEmail(user.getUsername(), user.getEmail());
            if(account==null) return false;
            return true;
        } catch (Exception e) {
            Log.error("#checkExitsUser","Account is not found",e);
            throw new IllegalArgumentException(e.toString());
        }
    }
}
