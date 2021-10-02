package com.card.processing.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.card.processing.dto.LoginDTO;
import com.card.processing.model.CustomerEntity;
import com.card.processing.model.UserProfileEntity;
import com.card.processing.service.CustomerService;
import com.card.processing.service.UserProfileService;

@Controller
@RequestMapping("/admin")
public class DashBoardController {

	@Autowired
	private UserProfileService userProfileService;

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView showsDhashboard(@SessionAttribute("login") LoginDTO login) {
		ModelAndView mv = new ModelAndView();
		List<UserProfileEntity> userProfileList = userProfileService.getAllUsersProfile();
		mv.addObject("userList", userProfileList);
		mv.addObject("userType", login.getUserType());

		if (login.getUserType() == 2) {
			List<CustomerEntity> customerList = customerService.getAllCustomerByUserId(login.getUserId());
			mv.addObject("customerList", customerList);
			mv.addObject("customerAll", "customerAll");
			mv.setViewName("viewcustomer");
		} else {
			mv.addObject("userProfileListPage", "userProfileListPage");
			mv.setViewName("userprofile");
		}
		return mv;
	}
}
