package com.cg.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.springbootdemo.entities.UserRegistration;

@Repository
public interface UserRepository extends JpaRepository<UserRegistration, String>{

}
