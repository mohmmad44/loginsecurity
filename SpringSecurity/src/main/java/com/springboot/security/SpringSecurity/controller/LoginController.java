package com.springboot.security.SpringSecurity.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@Autowired
	private ServletContext context;

	
	/**
     * Entering into the port 8080 will redirect to login  
     * @return redirect to login
     */
	
	@GetMapping(value = "/")
	public String login() {
		return "redirect:/login";
	}

	
	/**
     * Entering into login port 
     * @return redirect to login
     */
	@GetMapping(value = "/login")
	public String loginpage() {
		return "view/login";
	}

	
	
	/**
     * shows login failure when enters wrong credentials 
     * @return redirect to login
     */
	@GetMapping(value = "/loginfailure")
	public String loginfailure(Model model) {
		String email = (String) context.getAttribute("email");
		System.out.println(email + "  & its password  is Invalid  ");
		model.addAttribute("errormessage", "Invalid Email & Password");
		return "view/login";
	}

	/**
     * shows access denied when enters wrong credentials 
     * @return redirect to login
     */
	@GetMapping(value = "/access-denied")
	public String accessdenied(Model model) {
		model.addAttribute("errormessage", "Access Denied");
		return "view/login";
	}

	
	
	/**
     * logout the already logedin user
     * @return redirect to login
     */
	@GetMapping(value = "/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login";
	}

}
