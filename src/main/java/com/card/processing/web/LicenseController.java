package com.card.processing.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("login")
@RequestMapping("/card")
public class LicenseController {

	  @RequestMapping(value="/addLicensePage", method = RequestMethod.GET)
	    public ModelAndView addLicensePage(ModelMap model){
		  ModelAndView mv = new ModelAndView();
		  mv.addObject("addlicensepage", "addlicensepage");
		  mv.setViewName("dashboard");
	        return mv;
	    }
}
