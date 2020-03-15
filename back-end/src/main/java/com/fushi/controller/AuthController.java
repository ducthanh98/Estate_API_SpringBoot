package com.fushi.controller;

import com.fushi.dto.auth.dto.LoginDTO;
import com.fushi.dto.auth.ro.AuthenticationInformation;
import com.fushi.model.UserModel;
import com.fushi.service.UserService;
import com.fushi.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping(path = "/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/login",produces="application/json", consumes = "application/json")
    public Response<AuthenticationInformation> login(@Valid @RequestBody LoginDTO body){

        return userService.login(body.getEmail(),body.getPassword());
    }

    @PostMapping(path = "/register",produces="application/json", consumes = "application/json")
    public Response register(@Valid @RequestBody UserModel body){

        return userService.register(body);
    }
}
