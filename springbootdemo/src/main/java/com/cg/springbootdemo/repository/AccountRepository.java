package com.cg.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.springbootdemo.entities.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{

}
