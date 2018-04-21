package com.example.demo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SampleClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleClientApplication.class, args);
	}
	
}

@RestController
class ClientController{
	
	@GetMapping
	public User getUserDetails(){
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<User> resp = restTemplate.exchange("http://localhost:8080/", HttpMethod.GET, null, User.class);
		return resp.getBody();
	}
	
	@PostMapping(value="/", consumes="application/xml")
	public void postUserDetails(@RequestBody User user){
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<User> resp = restTemplate.postForEntity("http://localhost:8080/", user, User.class);
	}
	
}

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
class User{
	
	@XmlElement
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}