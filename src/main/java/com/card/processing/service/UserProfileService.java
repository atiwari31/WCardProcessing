package com.card.processing.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.card.processing.JasyptConfig;
import com.card.processing.dto.UserProfileDTO;
import com.card.processing.model.UserProfileEntity;
import com.card.processing.repository.UserProfileRepository;

@Service
public class UserProfileService {
	
	@Autowired
	UserProfileRepository userProfileRepository;
	
	public List<UserProfileEntity> getAllUsersProfile(){
		List<UserProfileEntity> userProfileList = userProfileRepository.findAllUserProfileactivrTrue();
		List<UserProfileEntity> userProfileEn = new ArrayList<>();
		UserProfileEntity userProfileEntityEncr= null;
		if(userProfileList.size()>0) {
			for(UserProfileEntity userProfileEntity :userProfileList) {
				userProfileEntityEncr= new UserProfileEntity();
				userProfileEntityEncr.setId(userProfileEntity.getId());
				userProfileEntityEncr.setProfileName(JasyptConfig.decryptKey(userProfileEntity.getProfileName()));
				userProfileEntityEncr.setIsALL(userProfileEntity.getIsALL());
				userProfileEntityEncr.setIsOCR(userProfileEntity.getIsOCR());
				userProfileEntityEncr.setIsSCAN(userProfileEntity.getIsSCAN());
				userProfileEntityEncr.setIsVOICE(userProfileEntity.getIsVOICE());
				userProfileEn.add(userProfileEntityEncr);
			}
			
			return userProfileEn;
			
			}else {
				return new ArrayList<UserProfileEntity>();
			}
	}
	
	public void saveUsersProfile(UserProfileDTO userProfile){
		UserProfileEntity userProfileEntity= new UserProfileEntity();

		if(null!=userProfile.getOcr() && userProfile.getOcr().equalsIgnoreCase("OCR"))
			userProfileEntity.setIsOCR(true);
		if(null!=userProfile.getScanning() && userProfile.getScanning().equalsIgnoreCase("SCANNING"))
			userProfileEntity.setIsSCAN(true);
		if(null!=userProfile.getVoice() && userProfile.getVoice().equalsIgnoreCase("VOICE"))
			userProfileEntity.setIsVOICE(true);
		if(null!=userProfile.getAll() && userProfile.getAll().equalsIgnoreCase("ALL"))
			userProfileEntity.setIsALL(true);
		userProfileEntity.setProfileName(JasyptConfig.encryptKey((userProfile.getProfileName())));
		userProfileEntity.setActive(true);
		userProfileRepository.save(userProfileEntity);
		}
	@Transactional
	public void updateUsersProfile(UserProfileDTO userProfile){
		UserProfileEntity userProfileEntity= new UserProfileEntity();
		if(null!=userProfile.getOcr() && userProfile.getOcr().equalsIgnoreCase("OCR"))
			userProfileEntity.setIsOCR(true);
		if(null!=userProfile.getScanning() && userProfile.getScanning().equalsIgnoreCase("SCANNING"))
			userProfileEntity.setIsSCAN(true);
		if(null!=userProfile.getVoice() && userProfile.getVoice().equalsIgnoreCase("VOICE"))
			userProfileEntity.setIsVOICE(true);
		if(null!=userProfile.getAll() && userProfile.getAll().equalsIgnoreCase("ALL"))
			userProfileEntity.setIsALL(true);
		userProfileEntity.setProfileName(JasyptConfig.encryptKey(userProfile.getProfileName()));
		userProfileEntity.setActive(true);
		userProfileEntity.setId(userProfile.getId());
		userProfileRepository.save(userProfileEntity);
		}
	
	public void deleteProfileById(Long Id){
		
		userProfileRepository.updateProfile(Id);
	}
	
public Optional<UserProfileEntity> editProfileById(Long Id){
		
		return userProfileRepository.findById(Id);
	}
}
