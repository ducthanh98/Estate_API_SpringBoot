package com.fushi.repository;

import com.fushi.model.AmentitiesModel;
import com.fushi.model.ReportModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<ReportModel,Integer> {
}
