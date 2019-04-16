package com.springboot.security.SpringSecurity.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFailureUrlHandler implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

	@Autowired
	private ServletContext context;

	@Override
	public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
		Object email = event.getAuthentication().getPrincipal();
		Object password = event.getAuthentication().getCredentials();
		context.setAttribute("email", email);
		context.setAttribute("password", password);
	}

}
