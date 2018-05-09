package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SecurityCredentials {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String username, password;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	public SecurityCredentials(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public SecurityCredentials() {
	}
	
	
	
}
