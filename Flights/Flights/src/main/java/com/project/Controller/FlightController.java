package com.project.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.Model.Flights;
import com.project.Service.FlightService;

@RestController
@RequestMapping(value="/flights")
public class FlightController {
	
Logger logger = LoggerFactory.getLogger(this.getClass());
	
@Autowired
private FlightService fs;

@GetMapping(value="/getAvailableFlights/{source}/{destination}/{traveldate}")
public ResponseEntity<List<Flights>> getAvailableFlights(@PathVariable String source,@PathVariable String destination,@PathVariable String traveldate)
{
	ResponseEntity<List<Flights>> response = null;
	try {
		List<Flights> list = fs.getFlightsAvailable(source, destination, traveldate);
		response=new ResponseEntity<List<Flights>>(list,HttpStatus.OK);
	}
	catch(Exception e)
	{
		logger.error(e.getMessage());
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"No Data Found");
	   	
	}
	return response;
}
	
}
