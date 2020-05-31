package com.fushi.repository;

import com.fushi.model.AmentitiesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AmentitiesRepository extends JpaRepository<AmentitiesModel,Integer> {
    List<AmentitiesModel> findByIdIn(Integer[] id);

}