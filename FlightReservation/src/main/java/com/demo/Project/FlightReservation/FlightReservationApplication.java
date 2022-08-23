package com.demo.Project.FlightReservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.demo.Project.Controller, com.demo.Project.DAO, com.demmo.Project.Entity,com.demo.Project.Service,com.deno.Project.model")
@EntityScan(basePackages = {"com.demo.Project.Entity"})
public class FlightReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightReservationApplication.class, args);
	}

}
