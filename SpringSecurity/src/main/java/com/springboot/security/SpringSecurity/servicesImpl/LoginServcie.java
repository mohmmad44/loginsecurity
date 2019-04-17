package com.springboot.security.SpringSecurity.servicesImpl;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.security.SpringSecurity.model.UserInfo;
import com.springboot.security.SpringSecurity.repository.UserRepository;
import com.springboot.security.SpringSecurity.services.ILoginService;



/**
 * <p>This is LoginServcie, All the methods in  Interface ILoginService are implemented here  . . .
 */
@Service
@Transactional
public class LoginServcie implements ILoginService {
	
	
	@Autowired 
	private UserRepository userRepository;

	static final Logger logger = LoggerFactory.getLogger(LoginServcie.class);
	
	/**
	 * <p>This is loadUserByUsername method, used  to get user information based on . . .
	 * </p>
	 * @param username 
	 * @return userDetails returns the user details.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info(" Inside loadUserByUsername : LoginServiceImpl  ");
		UserInfo userInfo = userRepository.findEmailIgnoreCase(username, true);
		
		if(userInfo == null) {
			logger.info("User not found");
			throw new UsernameNotFoundException("Username not found for "+username);
		}
		
		
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+userInfo.getRole());
		
		
		UserDetails userDetails = (UserDetails) new User(userInfo.getEmail(), userInfo.getPassword(), Arrays.asList(authority));
		return userDetails;
	}

}
