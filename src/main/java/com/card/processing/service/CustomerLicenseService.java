package com.card.processing.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.processing.ApplicationConfiguration;
import com.card.processing.JasyptConfig;
import com.card.processing.dto.CustomerLicenseDTO;
import com.card.processing.model.CustomerEntity;
import com.card.processing.model.CustomerLicenseEntity;
import com.card.processing.model.UserEntity;
import com.card.processing.repository.CustomerLicenseRepository;
import com.card.processing.repository.CustomerRepository;
import com.card.processing.utility.EmailUtility;
import com.card.processing.utility.WriteCertificateUtility;

@Service
public class CustomerLicenseService {
	
	@Autowired
	private CustomerLicenseRepository customerLicenseRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private WriteCertificateUtility writeCertificateUtility;
	@Autowired
	private EmailUtility utility;
	
	@Autowired
	private ApplicationConfiguration applicationConfiguration;
	
	public void saveCustomerLicense(CustomerLicenseDTO customerLicenseDTO){
		UserEntity user= new UserEntity();
		CustomerLicenseEntity customerLicenseEntity= new CustomerLicenseEntity();
		customerLicenseEntity.setCustomerId(new Long(customerLicenseDTO.getCustomer().get(0)));
		Optional<CustomerEntity> customerEntity=customerRepository.findById(new Long(customerLicenseDTO.getCustomer().get(0)));
		customerLicenseEntity.setCustomerName(customerEntity.get().getCustomerName());
		LocalDate myObj = LocalDate.now();
		
		if(null!=customerLicenseDTO.getLicenseType() && customerLicenseDTO.getLicenseType().equalsIgnoreCase("date")) {
			customerLicenseEntity.setStartDate(myObj.toString());
			customerLicenseEntity.setEndDate(customerLicenseDTO.getLicenseEndDate());
		}
		if(null!=customerLicenseDTO.getLicenseType() && customerLicenseDTO.getLicenseType().equalsIgnoreCase("day")) {
			customerLicenseEntity.setDays(1l);
			customerLicenseEntity.setStartDate(myObj.toString());
			customerLicenseEntity.setEndDate(customerLicenseDTO.getDays());
		}
		if(null!=customerLicenseDTO.getLicenseType() && customerLicenseDTO.getLicenseType().equalsIgnoreCase("host")) {
			customerLicenseEntity.setStartDate(customerLicenseDTO.getStartLicenseDate());
			customerLicenseEntity.setEndDate(customerLicenseDTO.getEndLicenseDate());
			customerLicenseEntity.setHostIp(customerLicenseDTO.getHostip());
			}
			customerLicenseEntity.setActive(true);
			user.setId(customerLicenseDTO.getUserId());
			customerLicenseEntity.setUser(user);
			customerLicenseRepository.save(customerLicenseEntity);
			writeCertificateUtility.certificateWrite(customerLicenseEntity);
			utility.sendEmail(customerEntity.get().getEmail(),utility.prepareEmail(customerLicenseEntity), applicationConfiguration.getCustomerEmailSubject());
		}
	
	public List<CustomerLicenseEntity> getAllCustomerLicense(){
		List<CustomerLicenseEntity> customerLicenseEntityList = customerLicenseRepository.findAllCustomerLicenseActiveTrue();
		CustomerLicenseEntity customerLicenseEntityDerc= new CustomerLicenseEntity();
		List<CustomerLicenseEntity> customerLicenseEntityDecrList =new ArrayList<>();
		
		if(customerLicenseEntityList.size()>0) {
			for(CustomerLicenseEntity customerLicenseEntity:customerLicenseEntityList) {
				customerLicenseEntityDerc= new CustomerLicenseEntity();
				customerLicenseEntityDerc.setCustomerId(customerLicenseEntity.getId());
				customerLicenseEntityDerc.setCustomerName(JasyptConfig.decryptKey(customerLicenseEntity.getCustomerName()));
				customerLicenseEntityDerc.setDays(customerLicenseEntity.getDays());
				customerLicenseEntityDerc.setEndDate(customerLicenseEntity.getEndDate());
				customerLicenseEntityDerc.setHostIp(customerLicenseEntity.getHostIp());
				customerLicenseEntityDerc.setStartDate(customerLicenseEntity.getStartDate());
				customerLicenseEntityDerc.setUser(customerLicenseEntity.getUser());
				customerLicenseEntityDecrList.add(customerLicenseEntityDerc);
			}
			
			return customerLicenseEntityDecrList;
			
			}else {
				return new ArrayList<CustomerLicenseEntity>();
			}
	}
	
	public List<CustomerLicenseEntity> getAllCustomerLicenseByuserId(Long userId){
		List<CustomerLicenseEntity> customerLicenseEntityList = customerLicenseRepository.findAllCustomerLicenseByUserId(userId);
		CustomerLicenseEntity customerLicenseEntityDerc= new CustomerLicenseEntity();
		List<CustomerLicenseEntity> customerLicenseEntityDecrList =new ArrayList<>();
		
		if(customerLicenseEntityList.size()>0) {
			for(CustomerLicenseEntity customerLicenseEntity:customerLicenseEntityList) {
				customerLicenseEntityDerc= new CustomerLicenseEntity();
				customerLicenseEntityDerc.setCustomerId(customerLicenseEntity.getId());
				customerLicenseEntityDerc.setCustomerName(JasyptConfig.decryptKey(customerLicenseEntity.getCustomerName()));
				customerLicenseEntityDerc.setDays(customerLicenseEntity.getDays());
				customerLicenseEntityDerc.setEndDate(customerLicenseEntity.getEndDate());
				customerLicenseEntityDerc.setHostIp(customerLicenseEntity.getHostIp());
				customerLicenseEntityDerc.setStartDate(customerLicenseEntity.getStartDate());
				customerLicenseEntityDerc.setUser(customerLicenseEntity.getUser());
				customerLicenseEntityDecrList.add(customerLicenseEntityDerc);
			}
			
			return customerLicenseEntityDecrList;
			
			}else {
				return new ArrayList<CustomerLicenseEntity>();
			}
	}

	public List<CustomerLicenseEntity> getAllCustomerLicenseForEmail(){
		List<CustomerLicenseEntity> customerLicenseEntityList = customerLicenseRepository.findAllCustomerLicenseActiveTrue();
		CustomerLicenseEntity customerLicenseEntityDerc= new CustomerLicenseEntity();
		List<CustomerLicenseEntity> customerLicenseEntityDecrList =new ArrayList<>();
		
		if(customerLicenseEntityList.size()>0) {
			for(CustomerLicenseEntity customerLicenseEntity:customerLicenseEntityList) {
				customerLicenseEntityDerc= new CustomerLicenseEntity();
				customerLicenseEntityDerc.setCustomerId(customerLicenseEntity.getId());
				customerLicenseEntityDerc.setCustomerName(JasyptConfig.decryptKey(customerLicenseEntity.getCustomerName()));
				customerLicenseEntityDerc.setDays(customerLicenseEntity.getDays());
				customerLicenseEntityDerc.setEndDate(customerLicenseEntity.getEndDate());
				customerLicenseEntityDerc.setHostIp(customerLicenseEntity.getHostIp());
				customerLicenseEntityDerc.setStartDate(customerLicenseEntity.getStartDate());
				customerLicenseEntityDecrList.add(customerLicenseEntityDerc);
			}
			
			return customerLicenseEntityDecrList;
			
			}else {
				return new ArrayList<CustomerLicenseEntity>();
			}
	}

}
