package com.fushi.service;

import com.fushi.model.ReportTypeModel;
import com.fushi.util.PaginationRequest;
import com.fushi.util.PaginationResponse;
import com.fushi.util.Response;

public interface ReportTypeService {
    Response insert(ReportTypeModel report);
    Response update(ReportTypeModel report,Integer id);
    Response delete(Integer id);
    Response<PaginationResponse<ReportTypeModel>> getAllBy(PaginationRequest pagePaginationRequest);
}
