package com.springboot.security.SpringSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springboot.security.SpringSecurity.service.LoginService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired 
	private LoginService loginService;
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	
	@Autowired
	public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(this.loginService).passwordEncoder(passwordEncoder());
	}
	
	
	
	
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
	
	
	
	
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
		.antMatchers("/users/**").hasAnyRole("USER")
		.antMatchers("/admin/**").hasAnyRole("ADMIN")
		.antMatchers("/superadmin/**").hasAnyRole("SUPERADMIN")
		
		.and().formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/login-process")
		.usernameParameter("email")
		.passwordParameter("password")
		.defaultSuccessUrl("/redirectdashboard")
		.failureUrl("/loginfailure")
		.and().logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/logoutsuccess")
		
		.and().exceptionHandling().accessDeniedPage("/access-denied");
	}
}
