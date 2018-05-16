package com.example.demo.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SecurityCredentials;
import com.example.demo.repository.SecurityCredentialsRepository;

@RestController   
public class AuthenticationController {

	@Autowired
	private SecurityCredentialsRepository securityCredentialsRepository;  
	
	@PostMapping("/login")
	public ResponseEntity<String> authenticate(@RequestHeader(name="Authorization") String auth){
		
		String credentials = auth.substring("Basic ".length());
		String decoder = new String(Base64.getDecoder().decode(credentials));
		String[] userDetails = decoder.split(":");
		SecurityCredentials securityCredentials = securityCredentialsRepository.findByUsernameAndPassword(userDetails[0], userDetails[1]);
		ResponseEntity<String> responseEntity;
		if(securityCredentials == null){
			responseEntity = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}else{
			securityCredentials.setPassword(null);
			responseEntity = new ResponseEntity<>(HttpStatus.OK);
		}
		return responseEntity;
	}
	
}
