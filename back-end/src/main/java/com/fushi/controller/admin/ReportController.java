package com.fushi.controller.admin;


import com.fushi.dto.report.ReportDTO;
import com.fushi.dto.report.UpdateReportDTO;
import com.fushi.model.HouseModel;
import com.fushi.model.ReportModel;
import com.fushi.model.ReportTypeModel;
import com.fushi.service.ReportService;
import com.fushi.service.ReportTypeService;
import com.fushi.util.PaginationRequest;
import com.fushi.util.PaginationResponse;
import com.fushi.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/admin/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @PostMapping(path = "/getAllBy",produces="application/json", consumes = "application/json")
    public Response<PaginationResponse<ReportModel>> getAllBy(@Valid @RequestBody PaginationRequest body){

        return reportService.getAllBy(body);
    }

    @PostMapping(path = "/create",produces="application/json", consumes = "application/json")
    public Response create(@Valid @RequestBody ReportDTO body){

        return reportService.insert(body);
    }

    @PostMapping(path = "/update/{id}",produces="application/json", consumes = "application/json")
    public Response create(@Valid @RequestBody UpdateReportDTO body, @PathVariable("id") Integer id){

        return reportService.update(id,body);
    }

}
