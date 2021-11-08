package com.cg.springbootdemo.dao;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.cg.springbootdemo.entities.Account;
import com.cg.springbootdemo.entities.AdminRegistration;
import com.cg.springbootdemo.entities.ApprovedLoans;
import com.cg.springbootdemo.entities.LoanApplication;
import com.cg.springbootdemo.entities.LoginDetail;
import com.cg.springbootdemo.entities.UserDetails;
import com.cg.springbootdemo.entities.UserRegistration;

public interface AdminDao {
	public AdminRegistration adminRegisterService(AdminRegistration admin);
	public LoginDetail verifyAdminLogin(LoginDetail login);
	public void modifyLoanApplicationStatus(LoanApplication loanapp);
	public AdminRegistration getAdminRegistrationDetailsByEmail(String email);
	public List<UserRegistration> findAllUserRegistrationDetails();
	public List<UserDetails> viewAllApprovedUser();
	public List<UserDetails> viewAllRejectedUser();
	public List<UserDetails> viewAllPendingUser();
	public Account getAccountByEmailService(String email);
	public void addApprovedLoan(ApprovedLoans approved);
	public List<LoanApplication> viewAllAcceptedLoanApplications();
	public List<LoanApplication> viewAllRejectedLoanApplications();
	
}
