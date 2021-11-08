package com.cg.springbootdemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.springbootdemo.entities.Account;
import com.cg.springbootdemo.entities.AdminRegistration;
import com.cg.springbootdemo.entities.ApprovedLoans;
import com.cg.springbootdemo.entities.LoanApplication;
import com.cg.springbootdemo.entities.LoginDetail;
import com.cg.springbootdemo.entities.UserDetails;
import com.cg.springbootdemo.entities.UserRegistration;
import com.cg.springbootdemo.repository.AccountRepository;
import com.cg.springbootdemo.repository.AdminRegistrationRepository;
import com.cg.springbootdemo.repository.ApprovedLoanRepository;
import com.cg.springbootdemo.repository.LoanApplicationRepository;
import com.cg.springbootdemo.repository.LoginDetailRepository;
import com.cg.springbootdemo.repository.UserRepository;

@Repository
public class AdminDaoImpl implements AdminDao{
	@Autowired
	private AdminRegistrationRepository adminRegRepo;

	@Autowired
	private LoanApplicationRepository loanAppRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private LoginDetailRepository loginRepo;
	
	@Autowired
	private ApprovedLoanRepository approvedLoanRepo;
	
	@Autowired
	private AccountRepository accountRepo;
	
	
	@Override
	public AdminRegistration adminRegisterService(AdminRegistration admin) {
		return adminRegRepo.save(admin);
	}

	@Override
	public LoginDetail verifyAdminLogin(LoginDetail login) {
		return loginRepo.findByEmailAndPassword(login.getEmail(),login.getPassword());
	}

	@Override
	public void modifyLoanApplicationStatus(LoanApplication loanapp) {
		 loanAppRepo.save(loanapp);
	}

	@Override
	public AdminRegistration getAdminRegistrationDetailsByEmail(String email) {
		return adminRegRepo.findById(email).get();
	}

	@Override
	public List<UserRegistration> findAllUserRegistrationDetails() {
		return userRepo.findAll();
	}

	@Override
	public List<UserDetails> viewAllApprovedUser() {
		List<ApprovedLoans> list=approvedLoanRepo.findAll();
		List<UserDetails> approvedUser=null;
		for(ApprovedLoans item:list) {
			Account i=item.getAccount();
			UserDetails u=i.getUserDetails();
			approvedUser.add(u);
		}
		return approvedUser;
	}

	@Override
	public List<UserDetails> viewAllRejectedUser() {
		List<UserDetails> Rejected=null;
		List<LoanApplication> list=loanAppRepo.findAll();
		for(LoanApplication item:list) {
			if(item.getLoanApplicationStatus().equals("Rejected")) {
				Rejected.add(item.getUserDetails());
			}
		}
		return Rejected;
	}

	@Override
	public List<UserDetails> viewAllPendingUser() {
		List<UserDetails> Pending=null;
		List<LoanApplication> list=loanAppRepo.findAll();
		for(LoanApplication item:list) {
			if(item.getLoanApplicationStatus().equals("Pending")) {
				Pending.add(item.getUserDetails());
			}
		}
		return Pending;
	}
	
	@Override
	public Account getAccountByEmailService(String email) {
		
		UserDetails userDetails = userRepo.findById(email).get().getUserDetails();
		List<Account> list=accountRepo.findAll();
		for(Account acc:list) {
			if(acc.getUserDetails().getUserDetailsId()==userDetails.getUserDetailsId()) {
				return acc;
			}
		}
		return null;
	}
	
	@Override
	public void addApprovedLoan(ApprovedLoans approved) {
		approvedLoanRepo.save(approved);
	}

	@Override
	public List<LoanApplication> viewAllAcceptedLoanApplications() {
		return loanAppRepo.findAll();
	}
	
	@Override
	public List<LoanApplication> viewAllRejectedLoanApplications() {
		return loanAppRepo.findAll();
	}

}


