package com.fushi.service;

import com.fushi.dto.house.HouseDTO;
import com.fushi.model.HouseModel;
import com.fushi.util.PaginationRequest;
import com.fushi.util.PaginationResponse;
import com.fushi.util.Response;

import java.util.List;

public interface HouseService {
    Response<List<HouseModel>> getNewest();
    Response<HouseModel> getByID(Integer id);

    Response insert(HouseDTO report);
    Response update(HouseModel report,Integer id);
    Response delete(Integer id);
    Response<PaginationResponse<HouseModel>> getAllBy(PaginationRequest pagePaginationRequest);
    Response<List<HouseModel>> searchAdvanced(String title,String location,Float area,Float area2, Float price,Float price2,Integer bedrooms,Integer bathrooms);
    }
