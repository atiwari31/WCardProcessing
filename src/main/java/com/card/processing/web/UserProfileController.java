package com.card.processing.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.card.processing.dto.UserProfileDTO;
import com.card.processing.model.UserProfileEntity;
import com.card.processing.service.UserProfileService;

@Controller
@RequestMapping("/userprofile")
public class UserProfileController {

	@Autowired
	UserProfileService userProfileService;

	@RequestMapping(value = "/userProfilePage", method = RequestMethod.GET)
	public ModelAndView userProfilePage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("userProfilePage", "userProfilePage");
		mv.setViewName("addprofile");
		return mv;

	}

	@RequestMapping(value = "/allusersprofile", method = RequestMethod.GET)
	public ModelAndView getAllUser() {
		ModelAndView mv = new ModelAndView();
		List<UserProfileEntity> userList = userProfileService.getAllUsersProfile();
		mv.addObject("userList", userList);
		mv.addObject("userProfileListPage", "userProfileListPage");
		mv.setViewName("dashboard");
		return mv;
	}

	@RequestMapping(value = "/adduserprofile", method = RequestMethod.POST)
	public ModelAndView addUserProfile(@Valid @ModelAttribute("userProfileDto") UserProfileDTO userEntity,
			BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		if (bindingResult.hasErrors()) {

			mv.addObject("userProfilePage", "userProfilePage");
			mv.addObject("userEntity", userEntity);
			mv.setViewName("addprofile");
			return mv;
		} else if (userEntity != null
				&& (userEntity.getScanning() == null && userEntity.getOcr() == null && userEntity.getVoice() == null)) {
			mv.addObject("ErrorMsg", "Please Select One Feature. ");
			mv.addObject("userProfilePage", "userProfilePage");
			mv.setViewName("addprofile");
			return mv;
		}
		userProfileService.saveUsersProfile(userEntity);
		userEntity.setProfileName(null);
		mv.addObject("userProfilePage", "userProfilePage");
		mv.addObject("msg", "Profile Added Successfully");
		mv.addObject("userProfilePage", "userProfilePage");
		mv.setViewName("addprofile");
		return mv;

	}

	@PostMapping(value = "/deleteprofile")
	public ModelAndView deleteuserprofile(@ModelAttribute("userProfileDto") UserProfileDTO userEntity) {
		ModelAndView mv = new ModelAndView();

		userProfileService.deleteProfileById(userEntity.getId());
		List<UserProfileEntity> userList = userProfileService.getAllUsersProfile();
		mv.addObject("userList", userList);

		mv.addObject("delmsg", "Profile Deleted Successfully");
		mv.addObject("userProfileListPage", "userProfileListPage");
		mv.setViewName("userprofile");
		return mv;

	}

	@RequestMapping(value = "/updateuserprofile", method = RequestMethod.POST)
	public ModelAndView updateUserProfile(@ModelAttribute("userProfileDto") UserProfileDTO userEntity,
			BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();

		if (bindingResult.hasErrors()) {

			mv.addObject("userProfileListPage", "userProfileListPage");
			mv.setViewName("userprofile");
			return mv;
		} else if (userEntity != null
				&& (userEntity.getScanning() == null && userEntity.getOcr() == null && userEntity.getVoice() == null)) {
			mv.addObject("ErrorMsg", "Please Select One Feature. ");
			mv.addObject("userProfileListPage", "userProfileListPage");
			mv.setViewName("userprofile");
			return mv;
		}

		userProfileService.updateUsersProfile(userEntity);
		List<UserProfileEntity> userList = userProfileService.getAllUsersProfile();
		mv.addObject("userList", userList);

		mv.addObject("prupmsg", "Profile Updated Successfully");
		mv.addObject("userProfileListPage", "userProfileListPage");
		mv.setViewName("userprofile");
		return mv;

	}
}
