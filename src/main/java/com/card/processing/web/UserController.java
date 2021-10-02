package com.card.processing.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.card.processing.JasyptConfig;
import com.card.processing.dto.UserDTO;
import com.card.processing.model.UserEntity;
import com.card.processing.service.UserService;
import com.card.processing.utility.EmailUtility;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private EmailUtility emailUtil;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView getAllUser() {
		ModelAndView mv = new ModelAndView();
		List<UserEntity> userList = userService.getAllUsers();
		mv.addObject("userAll", "userAll");
		mv.addObject("userList", userList);
		mv.setViewName("dashboard");
		return mv;
	}

	@RequestMapping(value = "/adduserpage", method = RequestMethod.GET)
	public ModelAndView getUserPage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("adduserpage", "adduserpage");
		mv.setViewName("adduser");
		return mv;
	}

	@RequestMapping(value = "/addusers", method = RequestMethod.POST)
	public ModelAndView addUsers(@ModelAttribute("rag") UserEntity userEntity) {
		ModelAndView mv = new ModelAndView();
		userEntity.setUsername(userEntity.getUsername());
		userEntity.setUserType(2);
		userEntity.setActive(true);
		userEntity.setLicensePassword(JasyptConfig.encryptKey(userEntity.getPassword()));

		if (userService.isUserExist(userEntity.getUsername()) >= 1 ? true : false) {
			mv.addObject("adduserpage", "adduserpage");
			mv.addObject("exragmsg", "User Already Exist");
			mv.setViewName("adduser");

			return mv;
		}
		if (userService.isUserExist(userEntity.getUsername()) >= 1 ? true : false) {
			mv.addObject("adduserpage", "adduserpage");
			mv.addObject("usermsg", "Duplicate User");
			mv.setViewName("adduser");

			return mv;
		}
		if (!userEntity.getPassword().equals(userEntity.getConfirmPassword())) {
			mv.addObject("adduserpage", "adduserpage");
			mv.addObject("pragmsg", "Passwords did not Match");
			
			mv.setViewName("adduser");

			return mv;
		}
		emailUtil.sendEmail(userEntity.getUsername(),
				"  Hello Below is your Change Password Link" + "<BR> </BR> " + " Temporary Password : "
						+ userEntity.getPassword() + "<BR> </BR> "
						+ "https://localhost:8443/user/updateuserpage?username=" + userEntity.getUsername(),
				"Regarding Password");
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
		userService.addUser(userEntity);
		userEntity= new UserEntity();
		mv.addObject("rag", userEntity);
		mv.addObject("adduserpage", "adduserpage");
		mv.addObject("ragmsg", "User Registration Successfully");
		mv.addObject("adduserpage", "adduserpage");
		mv.setViewName("adduser");
		return mv;

	}

	@RequestMapping(value = "/alluser", method = RequestMethod.GET)
	public ModelAndView getUser() {
		ModelAndView mv = new ModelAndView();
		List<UserEntity> userList = userService.getAllUsers();
		mv.addObject("userList", userList);
		mv.addObject("userAll", "userAll");
		mv.setViewName("alluser");
		return mv;
	}

	@PostMapping(value = "/deleteuser")
	public ModelAndView deleteuser(@ModelAttribute("rag") UserEntity userEntity) {
		ModelAndView mv = new ModelAndView();
		userService.deleteUserById(userEntity.getId());
		List<UserEntity> userList = userService.getAllUsers();

		mv.addObject("userList", userList);
		mv.addObject("userAll", "userAll");
		mv.addObject("delragmsg", "User Deleted Successfully");

		mv.setViewName("alluser");
		return mv;
	}

	@GetMapping(value = "/updateuserpage")
	public ModelAndView updateUser(@RequestParam String username, @ModelAttribute("userDto") UserDTO userDTO) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("username", username);
		mv.setViewName("updateuser");
		return mv;
	}

	@PostMapping(value = "/updateuserpassword")
	public ModelAndView updateUserPassword(@ModelAttribute("user") UserDTO userDTO) {
		ModelAndView mv = new ModelAndView();
		UserEntity userEntity = userService.getUserByUsername(userDTO.getUsername());
		if (userEntity == null) {
			mv.addObject("adduserpage", "adduserpage");
			mv.addObject("usermsg", "User Name is not Valid OR Not Exist");
			mv.setViewName("updateuser");
			return mv;
		}
		if (!passwordEncoder.matches(userDTO.getPassword(), userEntity.getPassword())) {
			mv.addObject("adduserpage", "adduserpage");
			mv.addObject("passmsg", "Password is not correct");
			mv.setViewName("updateuser");
			return mv;
		}
		if (!userDTO.getNewpassword().equals(userDTO.getConfirmpassword())) {
			mv.addObject("adduserpage", "adduserpage");
			mv.addObject("confmsg", "Password and Confirm Passwords did not match");
			mv.setViewName("updateuser");
			return mv;
		}

		userEntity.setPassword(passwordEncoder.encode(userDTO.getNewpassword()));
		userService.addUser(userEntity);
		mv.addObject("msg", "Password  Changed Successfully");
		mv.setViewName("updateuser");
		return mv;
	}

	@RequestMapping(value = "/updateusers", method = RequestMethod.POST)
	public ModelAndView updateUsers(@ModelAttribute("rag") UserEntity userEntity) {
		ModelAndView mv = new ModelAndView();
		userEntity.setActive(true);
		userService.addUser(userEntity);
		List<UserEntity> userList = userService.getAllUsers();
		mv.addObject("userList", userList);
		mv.addObject("userAll", "userAll");
		mv.setViewName("dashboard");
		mv.addObject("ragmsg", "User Updated Successfully");
		mv.setViewName("alluser");
		return mv;

	}
}
