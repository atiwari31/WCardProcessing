package com.card.processing.utility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import com.card.processing.model.CustomerLicenseEntity;
import com.card.processing.service.CustomerLicenseService;

@Component
@EnableAsync
public class EmailScheduleUtility {

	@Autowired
	private CustomerLicenseService customerLicenseService;
	@Autowired
	private EmailUtility emailUtility;

	// @Scheduled(fixedRate = 5000)
	// @Async
	public void emailScheduled() {
		List<CustomerLicenseEntity> customerList = customerLicenseService.getAllCustomerLicense();
		String emailBody = emailUtility.prepareScheduleEmail(customerList);
		String subject = "Weekly License Report";
		emailUtility.sendEmail(null, emailBody, subject);
	}

}
