package com.card.processing.dto;

import javax.validation.constraints.NotEmpty;

public class UserProfileDTO {
    
	@NotEmpty(message = "Please enter  Profile Name.")
	private String profileName;
	private String ocr;
	private String voice;
	private String scanning;
	private String all;
	private Long id;
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
	 * @return the ocr
	 */
	public String getOcr() {
		return ocr;
	}
	/**
	 * @param ocr the ocr to set
	 */
	public void setOcr(String ocr) {
		this.ocr = ocr;
	}
	/**
	 * @return the voice
	 */
	public String getVoice() {
		return voice;
	}
	/**
	 * @param voice the voice to set
	 */
	public void setVoice(String voice) {
		this.voice = voice;
	}
	/**
	 * @return the scanning
	 */
	public String getScanning() {
		return scanning;
	}
	/**
	 * @param scanning the scanning to set
	 */
	public void setScanning(String scanning) {
		this.scanning = scanning;
	}
	/**
	 * @return the all
	 */
	public String getAll() {
		return all;
	}
	/**
	 * @param all the all to set
	 */
	public void setAll(String all) {
		this.all = all;
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
	
	
}
