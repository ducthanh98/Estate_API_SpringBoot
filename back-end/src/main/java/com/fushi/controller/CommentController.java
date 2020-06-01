package com.fushi.controller;

import com.fushi.dto.comment.CommentDTO;
import com.fushi.model.CommentModel;
import com.fushi.model.ReportTypeModel;
import com.fushi.service.CommentService;
import com.fushi.service.ReportTypeService;
import com.fushi.util.PaginationRequest;
import com.fushi.util.PaginationResponse;
import com.fushi.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping(path = "/getAllBy/{id}",produces="application/json", consumes = "application/json")
    public Response<PaginationResponse<CommentModel>> getAllBy(@Valid @RequestBody PaginationRequest body, @PathVariable("id")  Integer id){

        return commentService.getAllBy(body,id);
    }

    @PostMapping(path = "/create",produces="application/json", consumes = "application/json")
    public Response create(@Valid @RequestBody CommentDTO body){

        return commentService.insert(body);
    }

}
