package com.springboot.security.SpringSecurity.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.security.SpringSecurity.exception.ExistingEmailException;
import com.springboot.security.SpringSecurity.model.UserInfo;
import com.springboot.security.SpringSecurity.repository.UserRepository;
import com.springboot.security.SpringSecurity.services.ISecurityService;
import com.springboot.security.SpringSecurity.services.IUserService;

@Controller
public class RegistrationController {
	
	
	
	@Autowired 
	private IUserService userService;
	
	@Autowired 
	private ISecurityService securityService;
	
	
	
	
	@GetMapping(value="/registration")
	public String registrationPage(Model model) {
		model.addAttribute("user", new UserInfo());
		return "view/registration";
	}
	
	
	
	
	@PostMapping(value="/register-process")
	public String registrationPage(@ModelAttribute UserInfo userInfo, HttpServletRequest request, Principal principal) throws ExistingEmailException {
		String password = userInfo.getPassword();
		
			
		UserInfo dbUser = userService.save(userInfo);
		if(dbUser!=null) {
			securityService.autoLogin(userInfo.getEmail(), password, request);
			if(userInfo.getRole().equalsIgnoreCase("USER")) {
				return "redirect:/users/dashboard";
			}
			if(userInfo.getRole().equalsIgnoreCase("ADMIN")) {
				
				return "redirect:/admin/dashboard";
				
			}
			if(userInfo.getRole().equalsIgnoreCase("SUPERADMIN")) {
				return "redirect:/superadmin/dashboard";
			}
		}
		return "redirect:/registration";
	}
}
