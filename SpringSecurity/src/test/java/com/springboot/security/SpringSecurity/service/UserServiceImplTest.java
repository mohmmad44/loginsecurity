package com.springboot.security.SpringSecurity.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.security.SpringSecurity.model.UserInfo;
import com.springboot.security.SpringSecurity.repository.UserRepository;
import com.springboot.security.SpringSecurity.servicesImpl.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
	
	@Autowired 
	UserService userService;
	
	@MockBean 
	UserRepository userRepository;
	
	
	@Test
	public void testCreateUser()  {
		UserInfo info = new UserInfo();
		info.setId(100L);
		info.setAddress("Address Test");
		info.setEmail("test@gmail.com");
		info.setCreatedDate(new Date());
		info.setEnabled(true);
		info.setFirstName("first name");
		info.setLastName("last name");
		info.setPassword("password");
		info.setPhoneNumber("1234567890");
		info.setRole("USER");
		Mockito.when(userRepository.save(info)).thenReturn(info);
		assertThat(userService.save(info)).isEqualTo(info);
	}
	
	@Test
	public void testFindByEmail() {
		UserInfo info = new UserInfo();
		info.setId(100L);
		info.setAddress("Address Test");
		info.setEmail("test@gmail.com");
		info.setCreatedDate(new Date());
		info.setEnabled(true);
		info.setFirstName("test");
		info.setLastName("test");
		info.setPassword("password");
		info.setPhoneNumber("1234567890");
		info.setRole("USER");
		Mockito.when(userRepository.findEmailIgnoreCase("test@gmail.com", true)).thenReturn(info);
		assertThat(userService.findByEmail("test@gmail.com")).isEqualTo(info);
	}
	
	
	@Test
	public void testFindAll() {
		UserInfo info = new UserInfo();
		info.setId(100L);
		info.setAddress("Address Test");
		info.setEmail("test@gmail.com");
		info.setCreatedDate(new Date());
		info.setEnabled(true);
		info.setFirstName("test");
		info.setLastName("test");
		info.setPassword("password");
		info.setPhoneNumber("1234567890");
		info.setRole("USER");
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		userInfos.add(info);
		
		Mockito.when(userRepository.findAll()).thenReturn(userInfos);
		assertThat(userService.getAllUsers()).isNotEqualTo(info);
	}
}
