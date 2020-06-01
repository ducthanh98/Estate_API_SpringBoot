package com.fushi.controller;

import com.fushi.dto.auth.dto.ChangePassDTO;
import com.fushi.dto.auth.dto.LoginDTO;
import com.fushi.dto.auth.dto.UserDTO;
import com.fushi.dto.auth.dto.UserInfoDTO;
import com.fushi.dto.auth.ro.AuthenticationInformation;
import com.fushi.model.AmentitiesModel;
import com.fushi.model.UserModel;
import com.fushi.service.UserService;
import com.fushi.util.PaginationRequest;
import com.fushi.util.PaginationResponse;
import com.fushi.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(path = "/auth")
public class AuthController {
    @Autowired
    private UserService userService;


    @PostMapping(path = "/getAllBy",produces="application/json", consumes = "application/json")
    public Response<PaginationResponse<UserModel>> getAllBy(@Valid @RequestBody PaginationRequest body){

        return userService.getAllBy(body);
    }


    @PostMapping(path = "/login",produces="application/json", consumes = "application/json")
    public Response<AuthenticationInformation> login(@Valid @RequestBody LoginDTO body){

        return userService.login(body.getEmail(),body.getPassword());
    }

    @PostMapping(path = "/register",produces="application/json", consumes = "application/json")
    public Response register(@Valid @RequestBody UserDTO body){

        return userService.register(body);
    }

    @PostMapping(path = "/update/{id}",produces="application/json", consumes = "application/json")
    public Response update(@Valid @RequestBody UserDTO body, @PathVariable Integer id){

        return userService.update(id,body);
    }

    @PostMapping(path = "/updateInfo/{id}",produces="application/json", consumes = "application/json")
    public Response update(@Valid @RequestBody UserInfoDTO body, @PathVariable Integer id){

        return userService.updateUserInfo(id,body);
    }

    @PostMapping(path = "/updatePassword/{id}",produces="application/json", consumes = "application/json")
    public Response changePassword(@Valid @RequestBody ChangePassDTO body, @PathVariable Integer id){

        return userService.changePassword(id,body);
    }

    @GetMapping(path = "/active/{id}/{code}",produces="application/json", consumes = "application/json")
    public Response active(@PathVariable Integer id,@PathVariable String code){

        return userService.active(id,code);
    }
}
