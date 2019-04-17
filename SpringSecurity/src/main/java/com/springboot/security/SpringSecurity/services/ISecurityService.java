package com.springboot.security.SpringSecurity.services;

import javax.servlet.http.HttpServletRequest;
/**
 * <p>This is ISecurityService Interface  . . .
 */
public interface ISecurityService {

	void autoLogin(String email, String password, HttpServletRequest request);

}
