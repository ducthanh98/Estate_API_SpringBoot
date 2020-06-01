package com.fushi.service;

import com.fushi.dto.report.ReportDTO;
import com.fushi.dto.report.UpdateReportDTO;
import com.fushi.model.ReportModel;
import com.fushi.util.PaginationRequest;
import com.fushi.util.PaginationResponse;
import com.fushi.util.Response;


public interface ReportService {
    Response insert(ReportDTO report);
    Response update(Integer id,UpdateReportDTO report);
    Response delete(Integer id);
    Response<PaginationResponse<ReportModel>> getAllBy(PaginationRequest pagePaginationRequest);
}
