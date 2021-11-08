package com.cg.springbootdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.springbootdemo.entities.Account;
import com.cg.springbootdemo.entities.AdminRegistration;
import com.cg.springbootdemo.entities.ApprovedLoans;
import com.cg.springbootdemo.entities.LoanApplication;
import com.cg.springbootdemo.entities.LoginDetail;
import com.cg.springbootdemo.entities.UserDetails;
import com.cg.springbootdemo.entities.UserRegistration;
import com.cg.springbootdemo.repository.AdminRegistrationRepository;
import com.cg.springbootdemo.repository.LoanApplicationRepository;
import com.cg.springbootdemo.repository.LoginDetailRepository;
import com.cg.springbootdemo.repository.UserRepository;
import com.cg.springbootdemo.service.AdminService;

@RestController
@RequestMapping("/api")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private LoginDetailRepository loginRepo;
	@Autowired
	private AdminRegistrationRepository adminRepo;
	@Autowired
	private LoanApplicationRepository loanAppRepo;
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/admin/newuser")
	public AdminRegistration adminRegisterService(@RequestBody AdminRegistration admin) {		
		LoginDetail login = new LoginDetail();
		login.setEmail(admin.getAdminEmail());
		login.setFullname(admin.getAdminFullName());
		login.setPassword(admin.getAdminPassword());
		login.setType("admin");
		loginRepo.save(login);
		return adminService.adminRegisterService(admin);
    }
	@PostMapping("/checkadmin")
	public LoginDetail verifyAdminLogin(@RequestBody LoginDetail login) {
		return adminService.verifyAdminLogin(login);
	}
	
	@PutMapping("/update/{chassisNumber}")
	public void modifyLoanApplicationStatus(@PathVariable Long chassisNumber, @RequestBody LoanApplication loanApplication) {
		LoanApplication loanApp = loanAppRepo.findById(chassisNumber).get();
		loanApp.setChassisNumber(loanApp.getChassisNumber());
		adminService.modifyLoanApplicationStatus(loanApplication);
	}
	
	@GetMapping("/getadmindetails/{email}")
	public AdminRegistration getAdminRegistrationDetailsByEmail(@PathVariable String email) {
		return adminService.getAdminRegistrationDetailsByEmail(email);
	}
	
	@GetMapping("/registeredusers")
	public List<UserRegistration> findAllUserRegistrationDetails(){
		return userRepo.findAll();
    }
	
	@GetMapping("/approvedusers")
	public List<UserDetails> viewAllApprovedUser(){
	return adminService.viewAllApprovedUser();
	}
	
	@GetMapping("/rejectedusers")
	public List<UserDetails> viewAllRejectedUser(){
	return adminService.viewAllRejectedUser();
	}
	
	@GetMapping("/pendingusers")
	public List<UserDetails> viewAllPendingUser(){
	return adminService.viewAllPendingUser();
	}
	
	@GetMapping("/logindetail")
	public List<LoginDetail> viewLoginDetailDB(){
		return loginRepo.findAll();
	}
	
	@GetMapping("/getAccount/{Email}")
    public Account getAccountByEmailService(String email) {
    	return adminService.getAccountByEmailService(email);
    }
    
    @PostMapping("/admin/addapprovedloan")
	public String addApprovedLoan(@RequestBody ApprovedLoans aprLoan) {
		adminService.addApprovedDetails(aprLoan);
		return "Added approved loan to DB";
	}
	
	@GetMapping("/admin/acceptedloanapps")
	public List<LoanApplication> viewAllAcceptedLoanApplications() {
		return adminService.viewAllAcceptedLoanApplications();
	}
	
	@GetMapping("/admin/rejectedloanapps")
	public List<LoanApplication> viewAllRejectedLoanApplications() {
		return adminService.viewAllRejectedLoanApplications();
	}
	
	@GetMapping("/user/getemi/{p}/{n}/{r}")
	public double emiCalculate(@PathVariable double p, @PathVariable int n, @PathVariable double r) {
		return adminService.emiCalculate(p, n, r);
	}
	
}