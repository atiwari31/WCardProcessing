package com.card.processing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@Component
@PropertySource(ignoreResourceNotFound = true, value = "classpath:config.properties")
public class ApplicationConfiguration {

	@Value("${license_path}")
	private String licensePath;

	@Value("${customer.license.email.body}")
	private String customerEmailBody;
	
	@Value("${customer.license.email.subject}")
	private String customerEmailSubject;
	
	@Value("${admin.email.address}")
	private String adminEmail;
	
	/**
	 * @return the licensePath
	 */
	public String getLicensePath() {
		return licensePath;
	}

	/**
	 * @param licensePath the licensePath to set
	 */
	public void setLicensePath(String licensePath) {
		this.licensePath = licensePath;
	}

	/**
	 * @return the customerEmailBody
	 */
	public String getCustomerEmailBody() {
		return customerEmailBody;
	}

	/**
	 * @param customerEmailBody the customerEmailBody to set
	 */
	public void setCustomerEmailBody(String customerEmailBody) {
		this.customerEmailBody = customerEmailBody;
	}

	/**
	 * @return the customerEmailSubject
	 */
	public String getCustomerEmailSubject() {
		return customerEmailSubject;
	}

	/**
	 * @param customerEmailSubject the customerEmailSubject to set
	 */
	public void setCustomerEmailSubject(String customerEmailSubject) {
		this.customerEmailSubject = customerEmailSubject;
	}
	/**
	 * @return the adminEmail
	 */
	public String getAdminEmail() {
		return adminEmail;
	}
	/**
	 * @param adminEmail the adminEmail to set
	 */
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
}
