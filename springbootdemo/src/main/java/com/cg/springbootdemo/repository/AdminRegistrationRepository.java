package com.cg.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.springbootdemo.entities.AdminRegistration;

@Repository
public interface AdminRegistrationRepository extends JpaRepository<AdminRegistration,String>{

}
