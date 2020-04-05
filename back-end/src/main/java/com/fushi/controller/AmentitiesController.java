package com.fushi.controller;


import com.fushi.model.AmentitiesModel;
import com.fushi.service.AmentitiesService;
import com.fushi.util.PaginationRequest;
import com.fushi.util.PaginationResponse;
import com.fushi.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/admin/amentities")
public class AmentitiesController {
    @Autowired
    private AmentitiesService amentitiesService;

    @GetMapping(path = "/getAll",produces="application/json", consumes = "application/json")
    public Response<List<AmentitiesModel>> getAll(){

        return amentitiesService.getAll();
    }


    @PostMapping(path = "/getAllBy",produces="application/json", consumes = "application/json")
    public Response<PaginationResponse<AmentitiesModel>> getAllBy(@Valid @RequestBody PaginationRequest body){

        return amentitiesService.getAllBy(body);
    }

    @PostMapping(path = "/create",produces="application/json", consumes = "application/json")
    public Response create(@Valid @RequestBody AmentitiesModel body){

        return amentitiesService.insertOrUpdate(body);
    }

    @PostMapping(path = "/update",produces="application/json", consumes = "application/json")
    public Response update(@Valid @RequestBody AmentitiesModel body){

        return amentitiesService.insertOrUpdate(body);

    }

    @GetMapping(path = "/delete/{id}",produces="application/json", consumes = "application/json")
    public Response delete(@PathVariable("id") Integer id){

        return amentitiesService.delete(id);

    }

}
