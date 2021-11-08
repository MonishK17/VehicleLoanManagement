package com.cg.springbootdemo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ApprovedLoans {
	
	@Id
	@GeneratedValue
	private Long approvedLoanId;
	private Double emiAmount;
	private String emiStartingDate;
	@ManyToOne(cascade=CascadeType.ALL)   
	@JoinColumn(name="AccountNumber", referencedColumnName="accountNumber")
	private Account account;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ChassisNumber", referencedColumnName="chassisNumber")
	private LoanApplication loanapp;
	public Long getApprovedLoanId() {
		return approvedLoanId;
	}
	public void setApprovedLoanId(Long approvedLoanId) {
		this.approvedLoanId = approvedLoanId;
	}
	public Double getEmiAmount() {
		return emiAmount;
	}
	public void setEmiAmount(Double emiAmount) {
		this.emiAmount = emiAmount;
	}
	public String getEmiStartingDate() {
		return emiStartingDate;
	}
	public void setEmiStartingDate(String emiStartingDate) {
		this.emiStartingDate = emiStartingDate;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public LoanApplication getLoanapp() {
		return loanapp;
	}
	public void setLoanapp(LoanApplication loanapp) {
		this.loanapp = loanapp;
	}
	
	
}