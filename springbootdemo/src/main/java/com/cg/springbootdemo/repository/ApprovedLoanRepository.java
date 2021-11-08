package com.cg.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.springbootdemo.entities.ApprovedLoans;

@Repository
public interface ApprovedLoanRepository extends JpaRepository<ApprovedLoans, Long>{

}