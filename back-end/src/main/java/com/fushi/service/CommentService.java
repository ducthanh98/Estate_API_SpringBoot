package com.fushi.service;

import com.fushi.dto.comment.CommentDTO;
import com.fushi.model.CommentModel;
import com.fushi.util.PaginationRequest;
import com.fushi.util.PaginationResponse;
import com.fushi.util.Response;

public interface CommentService {
    Response insert(CommentDTO comment);
    Response update(CommentModel comment,Integer id);
    Response delete(Integer id);
    Response<PaginationResponse<CommentModel>> getAllBy(PaginationRequest pagePaginationRequest,Integer id);
}
