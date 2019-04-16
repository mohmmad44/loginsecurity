package com.springboot.security.SpringSecurity.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.security.SpringSecurity.model.UserInfo;
import com.springboot.security.SpringSecurity.repository.UserRepository;
import com.springboot.security.SpringSecurity.util.PasswordUtil;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	
	
	
	@Autowired 
	private UserRepository userRepository;

	
	
	
	
	@Override
	public UserInfo findByEmail(String email) {
		return userRepository.findEmailIgnoreCase(email, true);
	}

	
	
	
	
	@Override
	public UserInfo save(UserInfo userInfo) {
		String password = PasswordUtil.getPasswordHash(userInfo.getPassword());
		userInfo.setPassword(password);
		userInfo.setEnabled(true);
		userInfo.setCreatedDate(new Date());
		return userRepository.save(userInfo);
	}
	
	@Override
	public UserInfo update(UserInfo userInfo) {
		return userRepository.save(userInfo);
	}

	@Override
	public List<UserInfo> getAllUsers() {
		return (List<UserInfo>) userRepository.findAll();
	}


}
