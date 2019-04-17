package com.springboot.security.SpringSecurity.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.security.SpringSecurity.model.UserInfo;
import com.springboot.security.SpringSecurity.servicesImpl.UserService;



/**
 *  RestApi Controller to return all the records of the existing registered customers to JSON format 
 * @return the information of all registered users
 */
@RestController
public class RestApiController {
	
	@Autowired private UserService userService;
	
	@GetMapping("/getusers")
	public ResponseEntity<List<UserInfo>> users() {
		List<UserInfo> users = userService.getAllUsers();
		return new ResponseEntity<List<UserInfo>>(users, HttpStatus.OK);
	}
	
	

}
