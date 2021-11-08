package com.cg.springbootdemo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdminRegistration {
	@Id	
	private String adminEmail;
	private String adminFullName;
	private String adminPassword;
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminFullName() {
		return adminFullName;
	}
	public void setAdminFullName(String adminFullName) {
		this.adminFullName = adminFullName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	
}