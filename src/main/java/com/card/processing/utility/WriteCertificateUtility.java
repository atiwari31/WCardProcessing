package com.card.processing.utility;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.card.processing.ApplicationConfiguration;
import com.card.processing.JasyptConfig;
import com.card.processing.model.CustomerLicenseEntity;

@Component
public class WriteCertificateUtility {
	
	@Autowired
	private ApplicationConfiguration ApplicationConfiguration;

	public void certificateWrite(CustomerLicenseEntity customerLicenseEntity) {
		//Creating a JSONObject object
	      JSONObject jsonObject = new JSONObject();
	      //Inserting key-value pairs into the json object
	      jsonObject.put("ID", "4532167890114567");
	      jsonObject.put("Customer Name", customerLicenseEntity.getCustomerName());
	      if(customerLicenseEntity.getDays()!=null) {
	    	  jsonObject.put("Days", customerLicenseEntity.getDays());
	      }else if(customerLicenseEntity.getHostIp()!=null && customerLicenseEntity.getEndDate()!=null){
	    	  jsonObject.put("Host IP", customerLicenseEntity.getHostIp());
	    	  jsonObject.put("Start Date", customerLicenseEntity.getStartDate());
	    	  jsonObject.put("End Date", customerLicenseEntity.getEndDate());
	      }else if(customerLicenseEntity.getEndDate()!=null) {
	    	  jsonObject.put("End Date", customerLicenseEntity.getEndDate());
	      }
	      try {
	    	 
	         FileWriter file = new FileWriter(ApplicationConfiguration.getLicensePath()+JasyptConfig.decryptKey(customerLicenseEntity.getCustomerName())+".json");
	         file.write(jsonObject.toJSONString());
	         file.close();
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      System.out.println("JSON file created: "+jsonObject);
	   }
	}

