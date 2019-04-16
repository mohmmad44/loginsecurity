package com.springboot.security.SpringSecurity.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	static final Logger logger = LoggerFactory.getLogger(LoginServcieImpl.class);
	
	
	
	@Override
	public UserInfo findByEmail(String email) {
		logger.info(" Inside findByEmail : UserServiceImpl  ");
		return userRepository.findEmailIgnoreCase(email, true);
	}

	
	
	@Override
	public UserInfo save(UserInfo userInfo) {
		logger.info(" Inside save : UserServiceImpl  ");
		String password = PasswordUtil.getPasswordHash(userInfo.getPassword());
		userInfo.setPassword(password);
		userInfo.setEnabled(true);
		userInfo.setCreatedDate(new Date());
		return userRepository.save(userInfo);
	}
	
	
	
	
	@Override
	public UserInfo update(UserInfo userInfo) {
		logger.info(" Inside update : UserServiceImpl  ");
		return userRepository.save(userInfo);
	}

	
	
	@Override
	public List<UserInfo> getAllUsers() {
		logger.info(" Inside getAllUsers : UserServiceImpl  ");
		return (List<UserInfo>) userRepository.findAll();
	}


}
