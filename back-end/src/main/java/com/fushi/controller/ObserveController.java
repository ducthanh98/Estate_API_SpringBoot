package com.fushi.controller;


import com.fushi.dto.observe.ObserveDTO;
import com.fushi.model.UserModel;
import com.fushi.service.UserService;
import com.fushi.util.PaginationRequest;
import com.fushi.util.PaginationResponse;
import com.fushi.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/observe")
public class ObserveController {
    @Autowired
    private UserService userService;


    @PostMapping(path = "/register",produces="application/json", consumes = "application/json")
    public Response<PaginationResponse<UserModel>> getAllBy(@RequestBody ObserveDTO email){

        return userService.observe(email);
    }
}
