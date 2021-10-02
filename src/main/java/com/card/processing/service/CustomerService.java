package com.card.processing.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.processing.JasyptConfig;
import com.card.processing.dto.CustomerDTO;
import com.card.processing.model.CustomerEntity;
import com.card.processing.model.UserEntity;
import com.card.processing.model.UserProfileEntity;
import com.card.processing.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	UserProfileService userProfileService;

	public void saveCustomer(CustomerDTO customerDTO) {
		List<UserProfileEntity> userProfileEntityList = new ArrayList<UserProfileEntity>();
		UserEntity userEntity=new UserEntity();
		UserProfileEntity userProfileEntity = null;
		for (String profileId : customerDTO.getProfile()) {
			userProfileEntity = new UserProfileEntity();
			userProfileEntity.setId(Long.valueOf(profileId));
			userProfileEntityList.add(userProfileEntity);
		}
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setCustomerName(JasyptConfig.encryptKey(customerDTO.getCustomerName()));
		customerEntity.setAddress(JasyptConfig.encryptKey(customerDTO.getAddress()));
		customerEntity.setMobile(customerDTO.getMobile());
		customerEntity.setEmail(customerDTO.getEmail());
		customerEntity.setContactPerson(JasyptConfig.encryptKey(customerDTO.getContactPerson()));
		customerEntity.setContactMobile(customerDTO.getContactMobile());
		customerEntity.setUserProfile(userProfileEntityList);
		customerEntity.setActive(true);
		userEntity.setId(customerDTO.getUserId());
		customerEntity.setUser(userEntity);
		customerRepository.save(customerEntity);

	}


	public void updateCustomer(CustomerDTO customerDTO){
		List<UserProfileEntity> userProfileEntityList= new ArrayList<UserProfileEntity>();
		UserProfileEntity userProfileEntity= null;
		for(String profileId:customerDTO.getProfile()) {
			userProfileEntity= new UserProfileEntity();
			userProfileEntity.setId(Long.valueOf(profileId));
			userProfileEntityList.add(userProfileEntity);
		}
		CustomerEntity customerEntity= new CustomerEntity();
		customerEntity.setId(customerDTO.getId());
		customerEntity.setCustomerName(JasyptConfig.encryptKey(customerDTO.getCustomerName()));
		customerEntity.setAddress(JasyptConfig.encryptKey(customerDTO.getAddress()));
		customerEntity.setMobile(customerDTO.getMobile());
		//customerEntity.setEmail(JasyptConfig.encryptKey(customerDTO.getEmail()));
		customerEntity.setEmail(customerDTO.getEmail());
		customerEntity.setContactPerson(JasyptConfig.encryptKey(customerDTO.getContactPerson()));
		customerEntity.setContactMobile(customerDTO.getContactMobile());
		customerEntity.setUserProfile(userProfileEntityList);
		customerEntity.setActive(true);
		customerRepository.save(customerEntity);
		}
	
	
	public List<CustomerEntity> getAllCustomer(){
		List<CustomerEntity> customerEntityList = customerRepository.findAllCustomerActiveTrue();
		List<UserProfileEntity> userProfileListAll = userProfileService.getAllUsersProfile();
		CustomerEntity customerEntityDecr = null;
		UserProfileEntity userProfileDecr=null;
		List<UserProfileEntity> userProfileList=null;
		List<CustomerEntity> customerEntityDecrList=new ArrayList<>();
		if(customerEntityList.size()>0) {
			for(CustomerEntity customerEntity:customerEntityList) {
				customerEntityDecr = new CustomerEntity();
				customerEntityDecr.setAddress(JasyptConfig.decryptKey(customerEntity.getAddress()));
				customerEntityDecr.setContactMobile(customerEntity.getContactMobile());
				customerEntityDecr.setContactPerson(JasyptConfig.decryptKey(customerEntity.getContactPerson()));
				customerEntityDecr.setCustomerName(JasyptConfig.decryptKey(customerEntity.getCustomerName()));
				customerEntityDecr.setEmail(customerEntity.getEmail());
				customerEntityDecr.setMobile(customerEntity.getMobile());
				customerEntityDecr.setId(customerEntity.getId());
				for(UserProfileEntity userProfile:customerEntity.getUserProfile()) {
					userProfileList=new ArrayList<>();
					userProfileDecr=new UserProfileEntity();
					userProfileDecr.setId(userProfile.getId());
					userProfileDecr.setProfileName(JasyptConfig.decryptKey(userProfile.getProfileName()));
					userProfileList.add(userProfileDecr);
				}
				customerEntityDecr.setUserProfile(userProfileList);
				customerEntityDecr.setUserProfileList(userProfileListAll);
				customerEntityDecrList.add(customerEntityDecr);
			}
			return customerEntityDecrList;

		} else {
			return new ArrayList<CustomerEntity>();
		}
	}
	public List<CustomerEntity> getAllCustomerByUserId(Long userId){
		List<CustomerEntity> customerEntityList = customerRepository.findAllCustomerByUserId(userId);
		CustomerEntity customerEntityDecr = null;
		UserProfileEntity userProfileDecr=null;
		List<UserProfileEntity> userProfileList=new ArrayList<>();
		List<CustomerEntity> customerEntityDecrList=new ArrayList<>();
		if(customerEntityList.size()>0) {
			for(CustomerEntity customerEntity:customerEntityList) {
				customerEntityDecr = new CustomerEntity();
				customerEntityDecr.setAddress(JasyptConfig.decryptKey(customerEntity.getAddress()));
				customerEntityDecr.setContactMobile(customerEntity.getContactMobile());
				customerEntityDecr.setContactPerson(JasyptConfig.decryptKey(customerEntity.getContactPerson()));
				customerEntityDecr.setCustomerName(JasyptConfig.decryptKey(customerEntity.getCustomerName()));
				customerEntityDecr.setEmail(customerEntity.getEmail());
				customerEntityDecr.setMobile(customerEntity.getMobile());
				customerEntityDecr.setId(customerEntity.getId());
				for(UserProfileEntity userProfile:customerEntity.getUserProfile()) {
					userProfileDecr=new UserProfileEntity();
					userProfileDecr.setId(userProfile.getId());
					userProfileDecr.setProfileName(JasyptConfig.decryptKey(userProfile.getProfileName()));
					userProfileList.add(userProfileDecr);
				}
				customerEntityDecr.setUserProfile(userProfileList);
				customerEntityDecrList.add(customerEntityDecr);
			}
			return customerEntityDecrList;

		} else {
			return new ArrayList<CustomerEntity>();
		}
	}

	public void deleteCustomerById(Long Id) {

		//customerRepository.deleteById(Id);
		customerRepository.upadteCustomer(Id);
	}
	
	public int isUserExist(String email,BigInteger mobile) {
		return customerRepository.isUserExist(email,mobile);
	}

}
