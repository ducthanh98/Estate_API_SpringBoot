package com.fushi.repository;

import com.fushi.model.HouseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public interface HouseRepository extends JpaRepository<HouseModel,Integer> {
    Page<HouseModel> findAllByStatus(Boolean status, Pageable pageable);
    List<HouseModel> findAllByStatusAndTitleContainsAndLocationContainsAndAreaBetweenAndPriceBetweenAndBedroomsAndBathrooms(Boolean status,String title,String location,Float area,Float area2, Float price,Float price2,Integer bedrooms,Integer bathrooms);

}
