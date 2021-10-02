package com.card.processing.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.card.processing.JasyptConfig;
import com.card.processing.dto.CustomerLicenseDTO;
import com.card.processing.dto.LoginDTO;
import com.card.processing.model.CustomerEntity;
import com.card.processing.model.CustomerLicenseEntity;
import com.card.processing.service.CustomerLicenseService;
import com.card.processing.service.CustomerService;

@Controller
@RequestMapping("/license")
@SessionAttributes("login")
public class CustomerLicenseController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerLicenseService customerLicenseService;

	 @RequestMapping(value="/getlicensepage", method = RequestMethod.GET)
	 public ModelAndView getLicensesPage(){
		    	  ModelAndView mv = new ModelAndView();
		    	  List<CustomerEntity> customerList=customerService.getAllCustomer();
		    	  mv.addObject("addlicensepage", "addlicensepage");
		    	  mv.addObject("customerList", customerList);
				  mv.setViewName("addlicense");
			  return mv; 
		    }
	 
	 @RequestMapping(value="/addcustomerlicense", method = RequestMethod.POST)
	 public ModelAndView addCustomerlicense(@Valid @ModelAttribute("customerLicenseDTO") CustomerLicenseDTO customerLicenseDTO,BindingResult bindingResult,@SessionAttribute("login") LoginDTO login){
		      ModelAndView mv = new ModelAndView();
		      List<CustomerEntity> customerList=customerService.getAllCustomer();
		      mv.addObject("customerList", customerList);
		      if(customerLicenseDTO!=null && customerLicenseDTO.getLicenseType()==null) {
		    	  mv.addObject("errormsg", "Please Select License Type");
		    	  mv.addObject("addlicensepage", "addlicensepage");
		    	  mv.setViewName("addlicense");
		    	  return mv;
		      }
		      if(customerLicenseDTO!=null && customerLicenseDTO.getLicenseType()!=null && customerLicenseDTO.getLicenseType().equalsIgnoreCase("day") && customerLicenseDTO.getDays()==null ) {
		    	  mv.addObject("daymsg", "Please Fill Days");
		    	  mv.addObject("addlicensepage", "addlicensepage");
		    	  mv.setViewName("addlicense");
		    	  return mv;
		      }
		      if(customerLicenseDTO!=null && customerLicenseDTO.getLicenseType()!=null && customerLicenseDTO.getLicenseType().equalsIgnoreCase("date") && customerLicenseDTO.getLicenseEndDate()=="") {
		    	  mv.addObject("datemsg", "Please Select Date");
		    	  mv.addObject("addlicensepage", "addlicensepage");
		    	  mv.setViewName("addlicense");
				return mv;
		      } 
		      if(customerLicenseDTO!=null && customerLicenseDTO.getLicenseType()!=null && customerLicenseDTO.getLicenseType().equalsIgnoreCase("user") && customerLicenseDTO.getStartLicenseDate()==null && customerLicenseDTO.getEndLicenseDate()=="") {
		    	  mv.addObject("daydatemsg", "Please Fill day and Date ");
		    	  mv.addObject("addlicensepage", "addlicensepage");
		    	  mv.setViewName("addlicense");
				return mv;
		      }
		      customerLicenseDTO.setUserId(login.getUserId());
		      customerLicenseService.saveCustomerLicense(customerLicenseDTO);
		     
		      mv.addObject("msg", "Lincense Added Successfully and Send Mail To Customer");
		      mv.addObject("licmsg", "Lincense Certficate Downloaded");
	    	  mv.addObject("addlicensepage", "addlicensepage");
			  mv.setViewName("addlicense");
			return mv;

}
	 @RequestMapping(value="/getAllLicense", method = RequestMethod.GET)
	 public ModelAndView getAllLicense(@SessionAttribute("login") LoginDTO login){
		    	  ModelAndView mv = new ModelAndView();
		    	  List<CustomerLicenseEntity> customerLicenseEntityList= null;
		    	  if(login.getUserType()==2) {
		    		  customerLicenseEntityList=customerLicenseService.getAllCustomerLicenseByuserId(login.getUserId());
		    	  }else {
		    		  customerLicenseEntityList=customerLicenseService.getAllCustomerLicense();
		    	  }
		    	  
		    	  mv.addObject("alllicense", "alllicense");
		    	  mv.addObject("customerLicenseEntityList", customerLicenseEntityList);
				  mv.setViewName("viewlicense");
			  return mv; 
		    }
	 


	 @GetMapping(value = "/confirmpassword/{password}")
	 public @ResponseBody String confirmPassword(@SessionAttribute("login") LoginDTO login,@PathVariable String password,@ModelAttribute("customerLicenseDTO") CustomerLicenseDTO customerLicenseDTO){
		 String msg="success";
		 try {
		  if(customerLicenseDTO!=null && customerLicenseDTO.getLicenseType()!=null && customerLicenseDTO.getLicenseType().equalsIgnoreCase("day") && customerLicenseDTO.getDays()==null ) {
			  msg= "Please Select Scanning Date";
	    	
	      }
		  
		   if((login.getUserType()!=1) &&  null!= login.getLicensePassword() && !JasyptConfig.decryptKey(login.getLicensePassword()).equalsIgnoreCase(password)) 
		   {
			   msg="Please enter valid password OR not authorized for license creation";
			   
		   }
		 }catch(Exception e) {
			 
		 }
		return msg;
}


}
