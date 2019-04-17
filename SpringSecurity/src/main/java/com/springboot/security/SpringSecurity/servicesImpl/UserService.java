package com.springboot.security.SpringSecurity.servicesImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.springboot.security.SpringSecurity.exception.ExistingEmailException;
import com.springboot.security.SpringSecurity.model.UserInfo;
import com.springboot.security.SpringSecurity.repository.UserRepository;
import com.springboot.security.SpringSecurity.services.IUserService;
import com.springboot.security.SpringSecurity.util.PasswordUtil;



/**
 * <p>This is UserService, All the methods in  Interface IUserService are implemented here  . . .
 */
@Service
@Transactional
public class UserService implements IUserService   {
	
	
	
	
	@Autowired 
	private UserRepository userRepository;

	static final Logger logger = LoggerFactory.getLogger(LoginServcie.class);
	
	
	/**
	 * <p>This is findByEmail method, used  find userInfo based on email
	 * </p>
	 * @param Stirng email 
	 * @return UserInfo userInfo.
	 */
	@Override
	public UserInfo findByEmail(String email) {
		logger.info(" Inside findByEmail : UserServiceImpl  ");
		return userRepository.findEmailIgnoreCase(email, true);
	}

	
	/**
	 * <p>This is save method, used  to save userinfo in db.
	 * </p>
	 * @param UserInfo userInfo
	 * @return UserInfo userInfo.
	 */
	@Override
	public UserInfo save(UserInfo userInfo) {
		
		
		//TODO check for existing previous emails
		
		
		
		
		logger.info(" Inside save : UserServiceImpl  ");
		String password = PasswordUtil.getPasswordHash(userInfo.getPassword());
		userInfo.setPassword(password);
		userInfo.setEnabled(true);
		userInfo.setCreatedDate(new Date());
		return userRepository.save(userInfo);
	}
	
	
	
	/**
	 * <p>This is update method, used  to update userinfo in database.
	 * </p>
	 * @param UserInfo userInfo 
	 * @return UserInfo userInfo.
	 */
	@Override
	public UserInfo update(UserInfo userInfo) {
		logger.info(" Inside update : UserServiceImpl  ");
		return userRepository.save(userInfo);
	}

	
	/**
	 * <p>This is getAllUsers method, used  to all the users from database.
	 * </p>
	 * 
	 * @return List of UserInfos
	 */
	@Override
	public List<UserInfo> getAllUsers() {
		logger.info(" Inside getAllUsers : UserServiceImpl  ");
		return (List<UserInfo>) userRepository.findAll();
	}


}
