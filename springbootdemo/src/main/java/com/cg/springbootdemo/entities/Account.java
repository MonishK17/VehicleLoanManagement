package com.cg.springbootdemo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Account {
	
	@Id
	@GeneratedValue
	private long accountNumber;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="UserDetailsId", referencedColumnName="userDetailsId")
	private UserDetails userDetails;
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
}
