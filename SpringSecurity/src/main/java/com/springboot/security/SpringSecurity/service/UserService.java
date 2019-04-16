package com.springboot.security.SpringSecurity.service;

import java.util.List;

import com.springboot.security.SpringSecurity.model.UserInfo;

public interface UserService {

	UserInfo findByEmail(String email);

	UserInfo save(UserInfo userInfo);
	
	UserInfo update(UserInfo userInfo);
	
	List<UserInfo> getAllUsers();

}
