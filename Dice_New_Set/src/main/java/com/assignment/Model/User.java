package com.assignment.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@NotNull(message = "Name can't be null")
	@NotBlank(message = "Name can't be blank")
	private String name;
	
	@Email(message = "Email is not in format")
	@Column(unique = true)
	@NotNull(message = "Email can't be null")
	@NotBlank(message = "Email can't be blank")
	private String email;
	
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{6,12}$", message = "Password contains one capital letter, one small letter and one digit not symbol and password length should be atleast 6 to 12")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	public User(Integer userId, String name, String email, String password) {
		
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		
	}

	public User() {
		
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
}
