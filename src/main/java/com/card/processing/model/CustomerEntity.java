package com.card.processing.model;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="customer")
public class CustomerEntity {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 private String customerName;
	 private String address;
	 private BigInteger mobile;
	 private String email;
	 private String contactPerson;
	 private BigInteger contactMobile;
	 private Boolean active ;
	 
	 @OneToMany(fetch = FetchType.LAZY)
	 @JoinTable(name = "customer_profile_join",
     joinColumns = {@JoinColumn(name = "customer_id")},
     inverseJoinColumns = {@JoinColumn(name = "user_profile_id")}
)
	    private List<UserProfileEntity> userProfile;
	 
	  @ManyToOne  
	  private UserEntity user;
	  
	  @Transient
	  private List<UserProfileEntity> userProfileList;
	 
	/**
	 * @return the userProfileList
	 */
	public List<UserProfileEntity> getUserProfileList() {
		return userProfileList;
	}
	/**
	 * @param userProfileList the userProfileList to set
	 */
	public void setUserProfileList(List<UserProfileEntity> userProfileList) {
		this.userProfileList = userProfileList;
	}
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
	 * @return the userProfile
	 */
	public List<UserProfileEntity> getUserProfile() {
		return userProfile;
	}
	/**
	 * @param userProfile the userProfile to set
	 */
	public void setUserProfile(List<UserProfileEntity> userProfile) {
		this.userProfile = userProfile;
	}
	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}
	/**
	 * @return the user
	 */
	public UserEntity getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(UserEntity user) {
		this.user = user;
	}
	 
	 
	 
}
