package com.card.processing.utility;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.card.processing.ApplicationConfiguration;
import com.card.processing.JasyptConfig;
import com.card.processing.model.CustomerLicenseEntity;

@Component
public class EmailUtility {
	@Autowired
	public JavaMailSender mailSender;
	@Autowired
	private ApplicationConfiguration applicationConfiguration;

	public void sendEmail(String toEmail, String body, String subject) {
		try {
			MimeMessage message = mailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(message, false, "utf-8");
			;

			helper.setFrom(applicationConfiguration.getAdminEmail());
			//helper.setTo("tiwarijeedavidjee@gmail.com");
			helper.setTo(toEmail);

			helper.setBcc(applicationConfiguration.getAdminEmail());
			message.setContent(body, "text/html");
			helper.setSubject(subject);
			mailSender.send(message);
			System.out.println("Mail Send");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public String prepareEmail(CustomerLicenseEntity customerLicenseEntity) {
		String text = "<html> <head><body>";
		text = text + "Hello Mr.<B>" + JasyptConfig.decryptKey(customerLicenseEntity.getCustomerName())
				+ "</B><BR></BR>";
		text = text + "Below is your License inoformation <BR></BR>";
		text = text + "<table width='100%' border='1' align='center'>"
				+ "<tr align='center' style='background-color:#f2f2f2'>" + "<td><b>Customer Name<b></td>"
				+ "<td><b>license type<b></td>" + "<td><b>license Start<b></td>" + "<td><b>license expiry<b></td>"
				+ "</tr>";

		text = text + "<tr align='center' style='background-color:#f2f2f2'>" + "<td>"
				+ JasyptConfig.decryptKey(customerLicenseEntity.getCustomerName()) + "</td>" + "<td>"
				+ licenseType(customerLicenseEntity) + "</td>" + "<td>" + customerLicenseEntity.getStartDate() + "</td>"
				+ "<td>" + customerLicenseEntity.getEndDate() + "</td>" + "</tr></table>";
		text = text + "</body></head></html>";
		return text;
	}

	private String licenseType(CustomerLicenseEntity customerLicenseEntity) {
		if (null != customerLicenseEntity.getDays()) {
			return customerLicenseEntity.getDays().toString();
		} else if (null != customerLicenseEntity.getHostIp()) {
			return customerLicenseEntity.getHostIp();
		} else if (null != customerLicenseEntity.getEndDate()) { 
					return customerLicenseEntity.getEndDate();
		}
		return "";
	}

	public String prepareScheduleEmail(List<CustomerLicenseEntity> customerList) {
		String text = "<html> <head><body>";
		text = text + "Hello Mr.<BR></BR>";
		text = text + "Below Weekly License Report <BR></BR>";
		text = text + "<table width='100%' border='1' align='center'>"
				+ "<tr align='center' style='background-color:#f2f2f2'>" + "<td><b>Customer Name<b></td>"
				+ "<td><b>license type<b></td>" + "<td><b>license Start<b></td>" + "<td><b>license expiry<b></td>"
				+ "</tr>";
		for (CustomerLicenseEntity customerLicenseEntity : customerList) {

			text = text + "<tr align='center' style='background-color:#f2f2f2'>" + "<td>"
					+ customerLicenseEntity.getCustomerName() + "</td>" + "<td>"
					+ licenseType(customerLicenseEntity) + "</td>" + "<td>" + customerLicenseEntity.getStartDate()
					+ "</td>" + "<td>" + customerLicenseEntity.getEndDate() + "</td>" + "</tr>";
			

		}
		
		text = text + "</table></body></head></html>";
		return text;
	}

}
