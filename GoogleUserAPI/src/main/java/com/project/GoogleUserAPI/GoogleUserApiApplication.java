package com.project.GoogleUserAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.project.Controller, com.project.DAO, com.project.Entity, com.project.Model, com.project.Service, com.project.AOP")
@EntityScan(basePackages="com.project.Entity")
public class GoogleUserApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoogleUserApiApplication.class, args);
	}

}
