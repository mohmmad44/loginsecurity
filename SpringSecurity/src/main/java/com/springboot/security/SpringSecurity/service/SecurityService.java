package com.springboot.security.SpringSecurity.service;

import javax.servlet.http.HttpServletRequest;

public interface SecurityService {

	void autoLogin(String email, String password, HttpServletRequest request);

}
