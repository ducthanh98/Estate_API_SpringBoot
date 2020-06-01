package com.fushi.controller;


import com.fushi.dto.house.HouseDTO;
import com.fushi.dto.house.SearchDTO;
import com.fushi.model.HouseModel;
import com.fushi.service.HouseService;
import com.fushi.util.PaginationRequest;
import com.fushi.util.PaginationResponse;
import com.fushi.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/rent-hostel")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @GetMapping(path = "/getNewest")
    public Response getNewest(){
        return houseService.getNewest();
    }

    @PostMapping(path = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Response create(@Valid @ModelAttribute HouseDTO body){
        return houseService.insert(body);
    }

    @PostMapping(path = "/getAllBy",produces="application/json", consumes = "application/json")
    public Response<PaginationResponse<HouseModel>> getAllBy(@Valid @RequestBody PaginationRequest body){

        return houseService.getAllBy(body);
    }

    @PostMapping(path = "/searchAdvanced",produces="application/json", consumes = "application/json")
    public Response<List<HouseModel>> searchAdvanced(@Valid @RequestBody SearchDTO body){
        return houseService.searchAdvanced(body.getTitle(),body.getLocation(),body.getMinArea(),body.getMaxArea(),body.getMinPrice(),body.getMaxPrice(),body.getBedroom(),body.getBathroom());
    }

    @GetMapping(path = "/getById/{id}")
    public Response<HouseModel> getByID(@PathVariable("id") Integer id) {
        return houseService.getByID(id);
    }
}
