package com.fushi.service;

import com.fushi.dto.auth.ro.AuthenticationInformation;
import com.fushi.model.UserModel;
import com.fushi.util.Response;

public interface UserService {
    Response<AuthenticationInformation> login(String email,String password);
    Response<String> register(UserModel userModel);
}
