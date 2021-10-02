package com.card.processing.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CustomerLicenseDTO {

	 private Long id;
	 private Long customerId;
	 @NotEmpty(message = "Please enter Customer Name.")
	 private String customerName;
	 @NotEmpty(message = "Please enter License Date.")
	 private String licenseEndDate;
	 @NotEmpty(message = "Please enter End Date.")
	 private String startLicenseDate;
	 @NotEmpty(message = "Please enter End Date.")
	 private String endLicenseDate;
	 @NotNull(message = "Please Fill Days.")
	 private String days;
	 @NotNull(message = "This Field Is Required.")
	 private String hostip;
	 
	 
	 private String licenseType;
	 
	 private List<String> customer= new ArrayList<String>();
	 
	 private Long userId;
	 
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	/**
	 * @return the days
	 */
	public String getDays() {
		return days;
	}
	/**
	 * @param days the days to set
	 */
	public void setDays(String days) {
		this.days = days;
	}
	/**
	 * @return the customer
	 */
	public List<String> getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(List<String> customer) {
		this.customer = customer;
	}



	/**
	 * @return the licenseEndDate
	 */
	public String getLicenseEndDate() {
		return licenseEndDate;
	}
	/**
	 * @param licenseEndDate the licenseEndDate to set
	 */
	public void setLicenseEndDate(String licenseEndDate) {
		this.licenseEndDate = licenseEndDate;
	}
	/**
	 * @return the startLicenseDate
	 */
	public String getStartLicenseDate() {
		return startLicenseDate;
	}
	/**
	 * @param startLicenseDate the startLicenseDate to set
	 */
	public void setStartLicenseDate(String startLicenseDate) {
		this.startLicenseDate = startLicenseDate;
	}
	/**
	 * @return the endtLicenseDate
	 */
	public String getEndLicenseDate() {
		return endLicenseDate;
	}
	/**
	 * @param endtLicenseDate the endtLicenseDate to set
	 */
	public void setEndLicenseDate(String endLicenseDate) {
		this.endLicenseDate = endLicenseDate;
	}
	/**
	 * @return the licenseType
	 */
	public String getLicenseType() {
		return licenseType;
	}
	/**
	 * @param licenseType the licenseType to set
	 */
	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}
	/**
	 * @return the hostip
	 */
	public String getHostip() {
		return hostip;
	}
	/**
	 * @param hostip the hostip to set
	 */
	public void setHostip(String hostip) {
		this.hostip = hostip;
	}
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	 
	 
}
