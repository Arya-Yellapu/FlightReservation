package com.infy.Card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.infy.Card, com.infy.Controller, com.infy.DAO, com.infy.Entity, com.infy.Model, com.infy.Service, com.infy.Utility")
@EntityScan(basePackages = {"com.infy.Entity"})
public class CardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardApplication.class, args);
	}

}
