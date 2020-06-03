package com.fushi.service;

import com.fushi.dto.reportType.ReportTypeDTO;
import com.fushi.model.ReportTypeModel;
import com.fushi.util.PaginationRequest;
import com.fushi.util.PaginationResponse;
import com.fushi.util.Response;

public interface ReportTypeService {
    Response insert(ReportTypeDTO report);
    Response update(ReportTypeDTO report, Integer id);
    Response delete(Integer id);
    Response<PaginationResponse<ReportTypeModel>> getAllBy(PaginationRequest pagePaginationRequest);
}
