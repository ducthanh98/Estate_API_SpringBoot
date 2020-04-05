package com.fushi.service;

import com.fushi.model.AmentitiesModel;
import com.fushi.util.PaginationRequest;
import com.fushi.util.PaginationResponse;
import com.fushi.util.Response;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AmentitiesService {
    Response<List<AmentitiesModel>> getAll();
    Response insertOrUpdate(AmentitiesModel amentities);
    Response delete(Integer id);
    Response<PaginationResponse<AmentitiesModel>> getAllBy(PaginationRequest pagePaginationRequest);
}
