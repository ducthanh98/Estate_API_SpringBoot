package com.fushi.repository;

import com.fushi.model.HouseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface HouseRepository extends JpaRepository<HouseModel,Integer> {
    Page<HouseModel> findAll(Pageable pageable);
}
