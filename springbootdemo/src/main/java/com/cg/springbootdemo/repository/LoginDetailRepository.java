package com.cg.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.springbootdemo.entities.LoginDetail;

@Repository
public interface LoginDetailRepository extends JpaRepository<LoginDetail, String>{

	LoginDetail findByEmailAndPassword(String email, String password);


}
