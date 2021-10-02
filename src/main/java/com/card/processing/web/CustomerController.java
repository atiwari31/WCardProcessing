package com.card.processing.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.card.processing.dto.CustomerDTO;
import com.card.processing.dto.LoginDTO;
import com.card.processing.model.CustomerEntity;
import com.card.processing.model.UserProfileEntity;
import com.card.processing.service.CustomerService;
import com.card.processing.service.UserProfileService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private UserProfileService userProfileService;

	@RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
	public ModelAndView addCustomer(@Valid @ModelAttribute("customerDto") CustomerDTO customerDTO,
			BindingResult bindingResult,@SessionAttribute("login") LoginDTO login) {
		ModelAndView mv = new ModelAndView();
		List<UserProfileEntity> userProfileList = userProfileService.getAllUsersProfile();
		mv.addObject("userProfileListPage", userProfileList);
		if (bindingResult.hasErrors()) {
			mv.addObject("addcustomerpageList", "addcustomerpage");
			mv.addObject("ErrorMsg", "Please Select Profile");
			mv.setViewName("addcustomer");
			return mv;
		} else if (customerDTO != null && customerDTO.getProfile() == null) {
			mv.addObject("ErrorMsg", "Please Select Profile");
			mv.addObject("addcustomerpageList", "addcustomerpage");
			mv.addObject("customerDto", customerDTO);
			mv.setViewName("addcustomer");
			return mv;
		}
		if (customerService.isUserExist(customerDTO.getEmail(), customerDTO.getMobile()) >= 1 ? true : false) {
			mv.addObject("addcustomerpageList", "addcustomerpage");
			mv.addObject("isUserErrorMsg", "Customer Already Exist");
			mv.setViewName("addcustomer");

			return mv;
		}
		customerDTO.setUserId(login.getUserId());
		customerService.saveCustomer(customerDTO);
		
		customerDTO = new CustomerDTO();
		mv.addObject("msg", "Customer Added Successfully");
		mv.addObject("addcustomerpageList", "addcustomerpage");
		mv.addObject("customerDto", customerDTO);
		mv.setViewName("addcustomer");
		return mv;

	}

	@GetMapping(value = "/addCustomerPage")
	public ModelAndView addCustomerPage(ModelMap model) {
		ModelAndView mv = new ModelAndView();
		List<UserProfileEntity> userProfileList = userProfileService.getAllUsersProfile();

		mv.addObject("userProfileListPage", userProfileList);
		mv.addObject("addcustomerpageList", "addcustomerpage");
		mv.setViewName("addcustomer");
		return mv;
	}

	@GetMapping(value = "/allcustomer")
	public ModelAndView getCustomer(@SessionAttribute("login") LoginDTO login) {
		ModelAndView mv = new ModelAndView();
		List<CustomerEntity> customerList=null;
		if(login.getUserType()==2) {
			customerList = customerService.getAllCustomerByUserId(login.getUserId());
		}else {
			customerList = customerService.getAllCustomer();
		}
		mv.addObject("customerList", customerList);
		mv.addObject("customerAll", "customerAll");
		mv.setViewName("viewcustomer");
		return mv;
	}

	@PostMapping(value = "/deletecustomer")
	public ModelAndView deleteuserprofile(@ModelAttribute("customerDto") CustomerDTO customerDTO) {
		ModelAndView mv = new ModelAndView();

		customerService.deleteCustomerById(customerDTO.getId());
		List<CustomerEntity> customerList = customerService.getAllCustomer();
		mv.addObject("customerList", customerList);
		mv.addObject("customerAll", "customerAll");
		mv.addObject("cdelmsg", "Customer Deleted Successfully");

		mv.setViewName("viewcustomer");
		return mv;

	}

	@PostMapping(value = "/updatecustomer")
	public ModelAndView updateCustomer(@Valid @ModelAttribute("customerDto") CustomerDTO customerDTO,
			BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		if (bindingResult.hasErrors()) {
			mv.addObject("addcustomerpageList", "addcustomerpage");
			mv.addObject("ErrorMsg", "Please Select Profile");
			mv.setViewName("viewcustomer");
			return mv;
		} else if (customerDTO != null && customerDTO.getProfile() == null) {
			mv.addObject("ErrorMsg", "Please Select Profile");
			mv.addObject("addcustomerpageList", "addcustomerpage");
			mv.addObject("customerDto", customerDTO);
			mv.setViewName("viewcustomer");
			return mv;
		}

		customerService.updateCustomer(customerDTO);

		List<CustomerEntity> customerList = customerService.getAllCustomer();
		mv.addObject("customerList", customerList);
		mv.addObject("customerAll", "customerAll");
		mv.addObject("updateMsg", "Customer Updated Successfully");
		mv.setViewName("viewcustomer");
		return mv;

	}
}
