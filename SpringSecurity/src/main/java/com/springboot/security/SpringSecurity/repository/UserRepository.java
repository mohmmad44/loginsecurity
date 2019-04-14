package com.springboot.security.SpringSecurity.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.security.SpringSecurity.model.UserInfo;

@Repository
public interface UserRepository extends CrudRepository<UserInfo, Long> {

	@Query("select u from UserInfo as u where u.email = ?1 and u.enabled = ?2")
	UserInfo findEmailIgnoreCase(String username, boolean enabled);

}
