package com.fushi.controller.admin;

import com.fushi.dto.reportType.ReportTypeDTO;
import com.fushi.model.ReportTypeModel;
import com.fushi.service.ReportTypeService;
import com.fushi.util.PaginationRequest;
import com.fushi.util.PaginationResponse;
import com.fushi.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@RestController
@RequestMapping(path = "/admin/report-type")
public class ReportTypeController {
    @Autowired
    private ReportTypeService reportTypeService;


    @PostMapping(path = "/getAllBy",produces="application/json", consumes = "application/json")
    public Response<PaginationResponse<ReportTypeModel>> getAllBy(@Valid @RequestBody PaginationRequest body){

        return reportTypeService.getAllBy(body);
    }

    @PostMapping(path = "/create",produces="application/json", consumes = "application/json")
    public Response create(@Valid @RequestBody ReportTypeDTO body){

        return reportTypeService.insert(body);
    }

    @PostMapping(path = "/update/{id}",produces="application/json", consumes = "application/json")
    public Response update(@Valid @RequestBody ReportTypeDTO body,@PathVariable("id") Integer id){

        return reportTypeService.update(body,id);

    }

    @GetMapping(path = "/delete/{id}")
    public Response delete(@PathVariable("id") Integer id){

        return reportTypeService.delete(id);

    }
}
