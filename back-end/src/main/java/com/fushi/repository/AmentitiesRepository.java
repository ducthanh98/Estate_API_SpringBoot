package com.fushi.repository;

import com.fushi.model.AmentitiesModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmentitiesRepository extends JpaRepository<AmentitiesModel,Integer> {
    void deleteById(Integer id);

}