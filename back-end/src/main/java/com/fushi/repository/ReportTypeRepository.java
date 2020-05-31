package com.fushi.repository;

import com.fushi.model.ReportTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportTypeRepository extends JpaRepository<ReportTypeModel,Integer> {
    void deleteById(Integer id);

}
