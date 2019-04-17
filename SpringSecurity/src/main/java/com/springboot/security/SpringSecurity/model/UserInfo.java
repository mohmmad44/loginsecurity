package com.springboot.security.SpringSecurity.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The UserInfo Model object contains main details about Users
 */
@Entity
@Table(name = "user")
public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7449027738620253765L;
	
	
	/**
     * Unique identifier of the UserInfo Model
     */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	/**
     * First name of the customer
     */
	@Column(name="first_name")
	private String firstName;
	
	
	/**
     * Last name of the customer
     */
	@Column(name="last_name")
	private String lastName;
	
	
	
	/**
     * email of the customer
     */
	@Column(name="email", nullable = false)
	private String email;
	
	
	
	/**
     * bycripted Password of the customer
     */
	@Column(name="password", nullable = false)
	private String password;
	
	
	
	/**
     * Role of the customer
     */
	@Column(name="role")
	private String role;
	
	
	
	
	/**
     * to know the customer is allowed to access or not according to Role
     */
	@Column(name="enabled")
	private boolean enabled;
	
	
	
	/**
     * Phone number of the customer
     */
	@Column(name="phone_number")
	private String phoneNumber;
	
	
	
	/**
     * Account creation date of the customer
     */
	@Column(name="created_date")
	private Date createdDate;
	
	
	
	/**
     * Address of the customer
     */
	@Column(name="address")
	private String address;

	
	
	
	
	

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public String getAddress() {
		return address;
	}

}
