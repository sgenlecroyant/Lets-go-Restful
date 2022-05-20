package com.sgenlecroyant.gorestful.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.SequenceGenerators;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "users")
@Table(name = "users")
@SequenceGenerators(value = {
		@SequenceGenerator(name = "users_sequence", initialValue = 1, allocationSize = 1, sequenceName = "users_sequence")
})
@JsonIgnoreProperties(value = {"firstName"})
@JsonFilter(value = "UserBeanPropsFilter")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
	private Integer id;
	@NotNull(message = "first name should never be null")
	private String firstName;
	@NotNull(message = "last name should never be null")
	private String lastName;
	private String username;
	@Size(min = 5, max = 30, message = "password length 5-30")
	@JsonIgnore(value = true)
	private String password;

	public User() {
		// TODO Auto-generated constructor stub
	}

	// @formatter:off
	public User(String firstName, String lastName, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
