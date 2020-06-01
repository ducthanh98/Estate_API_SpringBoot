package com.fushi.repository;

import com.fushi.model.CommentModel;
import com.fushi.model.HouseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentModel,Integer> {
    Page<CommentModel> findAllByPost(HouseModel post, Pageable pageable);
}
