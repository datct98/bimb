package com.example.demo.controller;

import com.example.demo.controller.body.UserBody;
import com.example.demo.controller.response.AuthResponse;
import com.example.demo.controller.response.BaseResponse;
import com.example.demo.controller.response.RestAPIResponse;
import com.example.demo.exception.common.ExceptionCreater;
import com.example.demo.exception.common.ServerException;
import com.example.demo.model.AuthModel;
import com.example.demo.untils.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/bimb")
public class AuthController {
    @Autowired
    private AuthModel authModel;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/json")
    public RestAPIResponse loginAccount(@RequestBody UserBody user){
        BaseResponse<AuthResponse> result = authModel.loginUser(user);
        if (result.isSuccess()) {
            Log.info("#loginAccount","Account: "+user.getUsername()+" login");
            return RestAPIResponse.fromData(result.getResponse());
        }
        return RestAPIResponse.fromError(ExceptionCreater.AUTH_ERROR,result.getMessage());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, headers = "Accept=application/json")
    public RestAPIResponse registerAccount(@RequestBody UserBody user) throws ServerException {
        BaseResponse<AuthResponse> result = authModel.register(user);
        if (result.isSuccess()) {
            Log.info("#registerAccount", "Register successfully account: "+user.getUsername());
            return RestAPIResponse.fromData(result.getResponse());
        }
        return RestAPIResponse.fromError(ExceptionCreater.AUTH_ERROR, result.getMessage());
    }

}
