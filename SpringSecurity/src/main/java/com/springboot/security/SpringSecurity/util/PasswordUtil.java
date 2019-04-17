package com.springboot.security.SpringSecurity.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * <p>This is PasswordUtil class
 * 
 */
public class PasswordUtil {
	
	static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	/**
	 * <p>This is getPasswordHash method, used  to encode the password.
	 * </p>
	 * @param Stirng password 
	 * @return String encoded paswword.
	 */
	public static String getPasswordHash(String password) {
		return passwordEncoder.encode(password);
	}

}
