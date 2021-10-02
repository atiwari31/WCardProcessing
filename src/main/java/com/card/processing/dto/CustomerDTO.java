package com.card.processing.dto;

import java.math.BigInteger;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CustomerDTO {

	 private Long id;
	 @NotEmpty(message = "Please enter your  Name.")
	 private String customerName;
	 @NotEmpty(message = "Please enter your Address.")
	 private String address;
	 @NotNull(message = "Please enter your Mobile Number.")
	 private BigInteger mobile;
	 @NotEmpty(message = "Please enter your Email ID.")
	 private String email;
	 @NotEmpty(message = "Please enter Contact Person.")
	 private String contactPerson;
	 @NotNull(message = "Please enter your Contact Mobile Number.")
	 private BigInteger contactMobile;
	 List<String> profile;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the mobile
	 */
	public BigInteger getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(BigInteger mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the contactPerson
	 */
	public String getContactPerson() {
		return contactPerson;
	}
	/**
	 * @param contactPerson the contactPerson to set
	 */
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	/**
	 * @return the contactMobile
	 */
	public BigInteger getContactMobile() {
		return contactMobile;
	}
	/**
	 * @param contactMobile the contactMobile to set
	 */
	public void setContactMobile(BigInteger contactMobile) {
		this.contactMobile = contactMobile;
	}
	/**
	 * @return the profile
	 */
	public List<String> getProfile() {
		return profile;
	}
	/**
	 * @param profile the profile to set
	 */
	public void setProfile(List<String> profile) {
		this.profile = profile;
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
