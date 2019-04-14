package com.springboot.security.SpringSecurity.service;

import com.springboot.security.SpringSecurity.model.UserInfo;

public interface UserService {

	UserInfo findByEmail(String email);

	UserInfo save(UserInfo userInfo);

}
