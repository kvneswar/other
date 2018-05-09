package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.SecurityCredentials;

public interface SecurityCredentialsRepository extends JpaRepository<SecurityCredentials, Long>{

	SecurityCredentials findByUsernameAndPassword(String username, String password);
}
