package com.fushi.controller;


import com.fushi.dto.auth.dto.LoginDTO;
import com.fushi.dto.auth.ro.AuthenticationInformation;
import com.fushi.dto.house.HouseDTO;
import com.fushi.service.HouseService;
import com.fushi.service.UserService;
import com.fushi.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/rent-hostel")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @PostMapping(path = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Response create(@Valid @ModelAttribute HouseDTO body){
        return houseService.insert(body);
    }
}
