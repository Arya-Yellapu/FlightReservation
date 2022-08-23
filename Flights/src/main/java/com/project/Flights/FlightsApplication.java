package com.project.Flights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.project.AOP, com.project.Controller, com.project.DAO, com.project.Flights, com.project.Model, com.project.Service")
@EntityScan(basePackages="com.project.Entity")
public class FlightsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightsApplication.class, args);
	}

}
