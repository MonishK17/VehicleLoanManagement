package com.cg.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springbootdemo.dao.AdminDao;
import com.cg.springbootdemo.entities.Account;
import com.cg.springbootdemo.entities.AdminRegistration;
import com.cg.springbootdemo.entities.ApprovedLoans;
import com.cg.springbootdemo.entities.LoanApplication;
import com.cg.springbootdemo.entities.LoginDetail;
import com.cg.springbootdemo.entities.UserDetails;
import com.cg.springbootdemo.entities.UserRegistration;



@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao adminDao;
	
	@Override
	public AdminRegistration adminRegisterService(AdminRegistration admin) {
		return adminDao.adminRegisterService(admin);
	}
	@Override
	public LoginDetail verifyAdminLogin(LoginDetail login) {
		return adminDao.verifyAdminLogin(login);
	}
	@Override
	public void modifyLoanApplicationStatus(LoanApplication loanapp) {
		adminDao.modifyLoanApplicationStatus(loanapp);
	}
	@Override
	public AdminRegistration getAdminRegistrationDetailsByEmail(String email) {
		return adminDao.getAdminRegistrationDetailsByEmail(email);
	}
	@Override
	public List<UserRegistration> findAllUserRegistrationDetails() {
		return adminDao.findAllUserRegistrationDetails();
	}
	
	@Override
	public List<UserDetails> viewAllApprovedUser() {
		return adminDao.viewAllApprovedUser();
	}
	@Override
	public List<UserDetails> viewAllRejectedUser() {
		return adminDao.viewAllRejectedUser();
	}
	@Override
	public List<UserDetails> viewAllPendingUser() {
		return adminDao.viewAllPendingUser();
	}
	@Override
	public Account getAccountByEmailService(String email) {
			return adminDao.getAccountByEmailService(email);
	}
	
	@Override
	public void addApprovedDetails(ApprovedLoans approved) {
		adminDao.addApprovedLoan(approved);
	}

	@Override
	public List<LoanApplication> viewAllAcceptedLoanApplications() {
		List<LoanApplication> list = adminDao.viewAllAcceptedLoanApplications();
		for(LoanApplication loan: list) {
			if(!loan.getLoanApplicationStatus().equals("Accepted"))
				list.remove(loan);
		}
		return list;
	}

	@Override
	public List<LoanApplication> viewAllRejectedLoanApplications() {
		List<LoanApplication> list = adminDao.viewAllRejectedLoanApplications();
		for(LoanApplication loan: list) {
			if(!loan.getLoanApplicationStatus().equals("Rejected"))
				list.remove(loan);
		}
		return list;
	}
	
	@Override
	public double emiCalculate(double loanAmount, int termInYears, double interestRate) {
		double n=Math.pow((interestRate+1), (termInYears*12));
		double d=Math.pow((interestRate+1), (termInYears*12)-1);
		double emi=loanAmount*interestRate*(n/d);
		return emi;
	}
}
