package com.springboot.security.SpringSecurity.servicesImpl;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.security.SpringSecurity.services.ISecurityService;


/**
 * <p>This is SecurityService, All the methods in  Interface ISecurityService are implemented here  . . .
 */
@Service
@Transactional
public class SecurityService implements ISecurityService {
	
	
	@Autowired 
	private AuthenticationManager authenticationManager;
	
	@Autowired 
	private UserDetailsService userDetailsService;

	
	
	
	
	@Override
	public void autoLogin(String email, String password, HttpServletRequest request) {
	
		
		
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(email);
		
		
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password, userDetails.getAuthorities()));
		
		
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
		
	}

}
