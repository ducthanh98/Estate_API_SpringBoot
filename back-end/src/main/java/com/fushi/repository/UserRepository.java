package com.fushi.repository;

import com.fushi.model.CommentModel;
import com.fushi.model.HouseModel;
import com.fushi.model.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel,Integer> {
    UserModel findByEmailAndPassword(String email,String password);
    boolean existsByEmail(String email);
    UserModel findByEmail(String email);
    List<UserModel> findBySubcribe(Boolean subcribe);
    Page<UserModel> findAllByRoleNot(Integer role, Pageable pageable);



}
