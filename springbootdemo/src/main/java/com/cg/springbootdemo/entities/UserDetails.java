package com.cg.springbootdemo.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserDetails {
	
	@Id
	@GeneratedValue
	private Integer userDetailsId;
	private String userState;
	private String userCity;
	private int userPinCode;
	private String userEmployeementType;
	private double userSalary;
	private String userAadharUrl;
	private String userPanUrl;
	private String userAddressProofUrl;
	private String userSalarySlipUrl;
	
	
	public Integer getUserDetailsId() {
		return userDetailsId;
	}
	public void setUserDetailsId(Integer userDetailsId) {
		this.userDetailsId = userDetailsId;
	}
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
	public String getUserCity() {
		return userCity;
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	public int getUserPinCode() {
		return userPinCode;
	}
	public void setUserPinCode(int userPinCode) {
		this.userPinCode = userPinCode;
	}
	public String getUserEmployeementType() {
		return userEmployeementType;
	}
	public void setUserEmployeementType(String userEmployeementType) {
		this.userEmployeementType = userEmployeementType;
	}
	public double getUserSalary() {
		return userSalary;
	}
	public void setUserSalary(double userSalary) {
		this.userSalary = userSalary;
	}
	public String getUserAadharUrl() {
		return userAadharUrl;
	}
	public void setUserAadharUrl(String userAadharUrl) {
		this.userAadharUrl = userAadharUrl;
	}
	public String getUserPanUrl() {
		return userPanUrl;
	}
	public void setUserPanUrl(String userPanUrl) {
		this.userPanUrl = userPanUrl;
	}
	public String getUserAddressProofUrl() {
		return userAddressProofUrl;
	}
	public void setUserAddressProofUrl(String userAddressProofUrl) {
		this.userAddressProofUrl = userAddressProofUrl;
	}
	public String getUserSalarySlipUrl() {
		return userSalarySlipUrl;
	}
	public void setUserSalarySlipUrl(String userSalarySlipUrl) {
		this.userSalarySlipUrl = userSalarySlipUrl;
	}
	
	
	
}
