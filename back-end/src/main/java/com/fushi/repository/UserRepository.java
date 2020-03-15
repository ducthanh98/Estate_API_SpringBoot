package com.fushi.repository;

import com.fushi.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel,Integer> {
    UserModel findByEmailAndPassword(String email,String password);
    boolean existsByEmail(String email);

}
