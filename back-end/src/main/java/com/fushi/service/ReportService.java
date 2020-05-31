package com.fushi.service;

import com.fushi.model.ReportModel;
import com.fushi.util.PaginationRequest;
import com.fushi.util.PaginationResponse;
import com.fushi.util.Response;

import java.util.List;

public interface ReportService {
    Response insertOrUpdate(ReportModel report);
    Response delete(Integer id);
    Response<PaginationResponse<ReportModel>> getAllBy(PaginationRequest pagePaginationRequest);
}
