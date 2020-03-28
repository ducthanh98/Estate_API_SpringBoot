package com.fushi.service;

import com.fushi.dto.auth.ro.AuthenticationInformation;
import com.fushi.model.UserModel;
import com.fushi.util.Response;

public interface AmentitiesService {
    Response<AuthenticationInformation> login(String email, String password);
    Response register(UserModel userModel);
    Response active(Integer id,String code);
}
