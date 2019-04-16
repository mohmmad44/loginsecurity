package com.springboot.security.SpringSecurity.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.security.SpringSecurity.model.UserInfo;
import com.springboot.security.SpringSecurity.service.UserService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/dashboard")
	public String userDashboard(Model model, Principal principal) {
		UserInfo userInfo = userService.findByEmail(principal.getName());
		model.addAttribute("user", userInfo);
		return "view/admindashboard";
	}
	
	@GetMapping(value = "/edituserinfo")
	public String editUserInfo(Model model, Principal principal) {
		UserInfo userInfo = userService.findByEmail(principal.getName());
		model.addAttribute("user", userInfo);
		model.addAttribute("action", "/admin/updateuserinfo");
		return "view/edituserinfo";

	}

	@PostMapping(value = "/updateuserinfo")
	public String updateuserinfo(@ModelAttribute UserInfo userInfo, Model model, Principal principal,
			RedirectAttributes attributes) {
		if (principal.getName().equalsIgnoreCase(userInfo.getEmail())) {
			UserInfo dbuserInfo = userService.findByEmail(principal.getName());
			if (dbuserInfo != null) {
				userInfo.setId(dbuserInfo.getId());
				userInfo.setEnabled(dbuserInfo.isEnabled());
				userInfo.setPassword(dbuserInfo.getPassword());
				userInfo.setCreatedDate(dbuserInfo.getCreatedDate());
				UserInfo updateUserInfo =  userService.update(userInfo);
				if(updateUserInfo!=null) {
					attributes.addFlashAttribute("successmessage","User Updated Successfully!");
				} else {
					attributes.addFlashAttribute("errormessage","User is not Update! Please try again!");
				}

			} else {
				attributes.addFlashAttribute("errormessage","User is not found! Please try again!");
			}
		} else {
			attributes.addFlashAttribute("errormessage","Access Denied");
		}

		return "redirect:/admin/dashboard";

	}

}
