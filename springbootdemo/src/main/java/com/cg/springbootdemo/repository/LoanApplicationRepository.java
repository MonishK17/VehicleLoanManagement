package com.cg.springbootdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.springbootdemo.entities.LoanApplication;
import com.cg.springbootdemo.entities.UserDetails;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long>{

	List<LoanApplication> findAllByUserDetails(UserDetails userDetails);
}