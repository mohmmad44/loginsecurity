package com.springboot.security.SpringSecurity.services;

import java.util.List;

import com.springboot.security.SpringSecurity.model.UserInfo;


/**
 * <p>This is IUserService Interface  . . .
 */
public interface IUserService {

	UserInfo findByEmail(String email);

	UserInfo save(UserInfo userInfo);
	
	UserInfo update(UserInfo userInfo);
	
	List<UserInfo> getAllUsers();

}
