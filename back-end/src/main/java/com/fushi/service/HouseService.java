package com.fushi.service;

import com.fushi.dto.house.HouseDTO;
import com.fushi.model.HouseModel;
import com.fushi.model.ReportModel;
import com.fushi.util.PaginationRequest;
import com.fushi.util.PaginationResponse;
import com.fushi.util.Response;

public interface HouseService {
    Response insert(HouseDTO report);
    Response update(HouseModel report,Integer id);
    Response delete(Integer id);
    Response<PaginationResponse<HouseModel>> getAllBy(PaginationRequest pagePaginationRequest);
}
