package com.springboot.security.SpringSecurity.services;

import javax.servlet.http.HttpServletRequest;

public interface ISecurityService {

	void autoLogin(String email, String password, HttpServletRequest request);

}
