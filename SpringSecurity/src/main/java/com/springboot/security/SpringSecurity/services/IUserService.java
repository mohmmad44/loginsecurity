package com.springboot.security.SpringSecurity.services;

import java.util.List;

import com.springboot.security.SpringSecurity.exception.ExistingEmailException;
import com.springboot.security.SpringSecurity.model.UserInfo;


/**
 * <p>This is IUserService Interface  . . .
 */
public interface IUserService {

	UserInfo findByEmail(String email);

	UserInfo save(UserInfo userInfo) throws ExistingEmailException;
	
	UserInfo update(UserInfo userInfo);
	
	List<UserInfo> getAllUsers();

}
