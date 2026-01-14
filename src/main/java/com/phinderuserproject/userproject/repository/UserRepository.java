package com.phinderuserproject.userproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phinderuserproject.userproject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
}
