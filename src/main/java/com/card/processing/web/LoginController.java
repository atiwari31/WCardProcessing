package com.card.processing.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.card.processing.dto.LoginDTO;
import com.card.processing.model.UserEntity;
import com.card.processing.service.UserService;


@Controller
@SessionAttributes({ "login"})
@RequestMapping("/card")
public class LoginController {
	
	@Autowired
	private UserService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService;
	  @RequestMapping(value="/login", method = RequestMethod.GET)
	    public String showLoginPage(ModelMap model){
	        return "login";
	    }
	  @RequestMapping(value="/index", method = RequestMethod.GET)
	    public String showIndexPage(ModelMap model){
	        return "index";
	    }
	  
	  @RequestMapping(value="/rag", method = RequestMethod.GET)
	    public String showsPage(ModelMap model){
	        return "ragistration";
	    }
	  
	  @GetMapping("/logout")
		public String logOut(HttpServletResponse response, HttpServletRequest request) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth != null) {
				new SecurityContextLogoutHandler().logout(request, response, auth);
			}
			return "redirect:/card/index";
		}
	
	  @ModelAttribute("login")
		public LoginDTO setUpUserForm() {
			return new LoginDTO();
		}
	
	  @PostMapping("/loginAuthentication")
		public String loginAuthentication(@Valid @ModelAttribute("login") LoginDTO login, BindingResult bindingResult,
				Model model,RedirectAttributes redirectAttrs, HttpServletResponse response, String error, String logout) {

			if (bindingResult.hasErrors()) {
				return "index";
			}

			try {

				if (null == login.getUsername() || null == login.getPassword() || login.getUsername().isEmpty() ||login.getPassword().isEmpty()) {
					model.addAttribute("error", "Username and Password is Empty");
					return "index";
				}

				final UserDetails userDetails = userDetailsService.loadUserByUsername(login.getUsername());
				
				UserEntity user = userDetailsService.getUserByUsername(login.getUsername());
				login.setUserType(user.getUserType());
				login.setName(user.getName());
				login.setUserId(user.getId());
				login.setLicensePassword(user.getLicensePassword());
				if (null == userDetails) {
					model.addAttribute("error", "Invalid credentials. Please check the username and password.");
					return "index";
				}
				 else if (!passwordEncoder.matches(login.getPassword(), user.getPassword())) {
					model.addAttribute("error", "Password is incorrect");
					return "index";
				}

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, userDetails.getPassword(), userDetails.getAuthorities());

				if (usernamePasswordAuthenticationToken.isAuthenticated()) {
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
				UserDetails users = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				model.addAttribute("email", users.getUsername());
				//model.addAttribute("name", users.getFirstName()+" "+users.getLastName() );
				
				redirectAttrs.addFlashAttribute("error", "Username and Password is incorrect");
				redirectAttrs.addFlashAttribute("successful", "Login Successful");
				model.addAttribute("login", login);
				return "redirect:/admin/dashboard";
			} catch (Exception e) {
				model.addAttribute("error", "Invalid credentials. Please check the username and password.");
				return "redirect:/card/index";
			}
		}
}
