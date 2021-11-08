package com.cg.springbootdemo.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class LoanApplication {
	
	@Id
	@GeneratedValue
	private Long chassisNumber;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="UserDetails", referencedColumnName="userDetailsId")
	private UserDetails userDetails;
	private String loanApplicationDate = new Date().toString();
	private Double loanAmount;
	private Integer loanTenure;
	private Double loanInterest=9.19;
	private String loanApplicationStatus="Submitted";
	private Double userExistingEMI;
	private String vehicleBrand;
	private String vehicleModel;
	private String vehicleType;
	private String vehicleColor;
	private Double vehicleExShowroomPrice;
	private Double vehicleOnRoadPrice;
	@OneToOne(cascade=CascadeType.ALL,mappedBy="loanapp")
	private ApprovedLoans approvedLoan;
	
	
	
	public Long getChassisNumber() {
		return chassisNumber;
	}
	public void setChassisNumber(Long chasisNumber) {
		this.chassisNumber = chasisNumber;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public String getLoanApplicationDate() {
		return loanApplicationDate;
	}
	public void setLoanApplicationDate(String loanApplicationDate) {
		this.loanApplicationDate = loanApplicationDate;
	}
	public Double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Integer getLoanTenure() {
		return loanTenure;
	}
	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}
	public Double getLoanInterest() {
		return loanInterest;
	}
	public void setLoanInterest(double loanInterest) {
		this.loanInterest = loanInterest;
	}
	public String getLoanApplicationStatus() {
		return loanApplicationStatus;
	}
	public void setLoanApplicationStatus(String loanApplicationStatus) {
		this.loanApplicationStatus = loanApplicationStatus;
	}
	public double getUserExistingEMI() {
		return userExistingEMI;
	}
	public void setUserExistingEMI(double userExistingEMI) {
		this.userExistingEMI = userExistingEMI;
	}
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleColor() {
		return vehicleColor;
	}
	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}
	public double getVehicleExShowroomPrice() {
		return vehicleExShowroomPrice;
	}
	public void setVehicleExShowroomPrice(double vehicleExShowroomPrice) {
		this.vehicleExShowroomPrice = vehicleExShowroomPrice;
	}
	public double getVehicleOnRoadPrice() {
		return vehicleOnRoadPrice;
	}
	public void setVehicleOnRoadPrice(double vehicleOnRoadPrice) {
		this.vehicleOnRoadPrice = vehicleOnRoadPrice;
	}
	public ApprovedLoans getApprovedLoan() {
		return approvedLoan;
	}
	public void setApprovedLoan(ApprovedLoans approvedLoan) {
		this.approvedLoan = approvedLoan;
	}
	
	
}