package com.example.demo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SampleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApiApplication.class, args);
	}
}


@RestController
class SampleController{
	
	private User user;
	
	@GetMapping(value="/", produces="application/xml")
	public User getUserDetails(){
		return user;
	}
	
	@PostMapping(value="/", consumes="application/xml")
	public void postDetails(@RequestBody User user){
		this.user = user;
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