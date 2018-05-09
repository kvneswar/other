package com.example.demo.startup;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.demo.dto.SecurityCredentials;
import com.example.demo.repository.SecurityCredentialsRepository;

@Component
public class LoadUserDetails {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoadUserDetails.class);
	
	@Autowired
	private SecurityCredentialsRepository securityCredentialsRepository;
	
	@Bean
	CommandLineRunner loasUserDetails(){
		return args -> {
			Arrays.asList("user1:password1", "user2:password2", "user3:password3")
				  .stream()
				  .map(userDetails -> userDetails.split(":"))
				  .map(userDetails -> new SecurityCredentials(userDetails[0], userDetails[1]))
				  .forEach(securityCredentials -> {
					  securityCredentialsRepository.save(securityCredentials);
					  LOGGER.debug("Loaded the user: {}", securityCredentials.getUsername());
				  });
		};
	}
}
