package com.fushi.repository;

import com.fushi.model.HouseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<HouseModel,Integer> {
}
