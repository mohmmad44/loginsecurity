package com.springboot.security.SpringSecurity.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@Autowired 
	private ServletContext context;
	
	@GetMapping(value="/")
	public String login() {
		return "redirect:/login";
	}
	
	@GetMapping(value="/login")
	public String loginpage() {
		return "view/login";
		
	}
	
	@GetMapping(value="/loginfailure")
	public String loginfailure(Model model) {
		String email = (String)context.getAttribute("email");
		String password = (String)context.getAttribute("password");
		System.out.println(email+ " "+password);
		model.addAttribute("errormessage", "Invalid Email & Password");
		return "view/login";
	}
	
	@GetMapping(value="/access-denied")
	public String accessdenied(Model model) {
		model.addAttribute("errormessage", "Access Denied");
		return "view/login";
	}
	
	
	@GetMapping(value="/logout")
	public String logout(Model model) {
		model.addAttribute("successmessage", "Logout Successfully");
		return "view/login";
	}
	
	

}
