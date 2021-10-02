package com.card.processing.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user_profile")
public class UserProfileEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Column(name = "name")
	private String profileName;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "active")
	private Boolean active;
	
	@Column(name = "isVOICE")
	private Boolean isVOICE;
	
	@Column(name = "isOCR")
	private Boolean isOCR;
	
	@Column(name = "isSCAN")
	private Boolean isSCAN;
	
	@Column(name = "isALL")
	private Boolean isALL;


	
	/**
	 * @return the isALL
	 */
	public Boolean getIsALL() {
		return isALL;
	}

	/**
	 * @param isALL the isALL to set
	 */
	public void setIsALL(Boolean isALL) {
		this.isALL = isALL;
	}

	/**
		 * @return the date
		 */
		public Date getDate() {
			return date;
		}

		/**
		 * @param date the date to set
		 */
		public void setDate(Date date) {
			this.date = date;
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
	 * @return the profileName
	 */
	public String getProfileName() {
		return profileName;
	}

	/**
	 * @param profileName the profileName to set
	 */
	public void setProfileName(String profileName) {
		this.profileName = profileName;
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
	 * @return the isVoice
	 */
	
	/**
	 * @return the isOCR
	 */
	public Boolean getIsOCR() {
		return isOCR;
	}

	/**
	 * @return the isVOICE
	 */
	public Boolean getIsVOICE() {
		return isVOICE;
	}

	/**
	 * @param isVOICE the isVOICE to set
	 */
	public void setIsVOICE(Boolean isVOICE) {
		this.isVOICE = isVOICE;
	}

	/**
	 * @return the isSCAN
	 */
	public Boolean getIsSCAN() {
		return isSCAN;
	}

	/**
	 * @param isSCAN the isSCAN to set
	 */
	public void setIsSCAN(Boolean isSCAN) {
		this.isSCAN = isSCAN;
	}

	/**
	 * @param isOCR the isOCR to set
	 */
	public void setIsOCR(Boolean isOCR) {
		this.isOCR = isOCR;
	}





	
	
	

}
