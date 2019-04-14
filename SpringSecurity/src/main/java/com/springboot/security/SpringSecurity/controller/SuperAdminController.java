package com.springboot.security.SpringSecurity.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.security.SpringSecurity.model.UserInfo;
import com.springboot.security.SpringSecurity.service.UserService;



@Controller
@RequestMapping(value="/superadmin")
public class SuperAdminController {
	
	
	

	
	@Autowired 
	private UserService userService;

	
	
	
	
	@GetMapping(value="/dashboard")
	public String userDashboard(Model model, Principal principal) {
		UserInfo userInfo = userService.findByEmail(principal.getName());
		model.addAttribute("user", userInfo);
		return "view/superadmindashboard";
		
	}

}
