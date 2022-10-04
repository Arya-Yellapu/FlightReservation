package com.project.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.Model.Flights;
import com.project.Model.FlightsRoundTrip;
import com.project.Model.Seats;
import com.project.Service.FlightService;

@RestController
@RequestMapping(value="/flights")
public class FlightController {
	
Logger logger = LoggerFactory.getLogger(this.getClass());
	
@Autowired
private FlightService fs;

@GetMapping(value="/getAvailableFlights/{source}/{destination}/{traveldate}/{seatsRequired}")
public ResponseEntity<List<Flights>> getAvailableFlights(@PathVariable String source,@PathVariable String destination,@PathVariable String traveldate,@PathVariable String seatsRequired)
{
	ResponseEntity<List<Flights>> response = null;
	try {
		List<Flights> list = fs.getFlightsAvailable(source, destination, traveldate, seatsRequired);
		response=new ResponseEntity<List<Flights>>(list,HttpStatus.OK);
	}
	catch(Exception e)
	{
		logger.error(e.getMessage());
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"No Data Found");
	   	
	}
	return response;
}

@GetMapping(value="/getAvailableReturnFlights/{source}/{destination}/{traveldate}/{returndate}/{seatsRequired}")
public ResponseEntity<List<FlightsRoundTrip>> getReturnFlightsAvailable(@PathVariable String source,@PathVariable String destination,@PathVariable String traveldate,@PathVariable String returndate,@PathVariable String seatsRequired)
{
	ResponseEntity<List<FlightsRoundTrip>> response = null;
	try {
		List<FlightsRoundTrip> list = fs.getReturnFlightsAvailable(source, destination, traveldate, returndate, seatsRequired);
		response=new ResponseEntity<List<FlightsRoundTrip>>(list,HttpStatus.OK);
	}
	catch(Exception e)
	{
		logger.error(e.getMessage());
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"No Data Found");
	   	
	}
	return response;
}

@GetMapping(value="/{flightno}")
public ResponseEntity<List<Seats>> getSeatsAvailable(@PathVariable String flightno)
{
	ResponseEntity<List<Seats>> response = null;
	try
	{
		List<Seats> slist = fs.getSeatsOfFlight(flightno);
		response = new ResponseEntity<List<Seats>>(slist,HttpStatus.OK);
	}
	catch(Exception e)
	{
		logger.error(e.getMessage());
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"No Data Found");
	}
	return response;
}
@GetMapping(value="/roundTrip/{flightno}")
public ResponseEntity<List<Seats>> getReturnSeatsAvailable(@PathVariable String flightno)
{
	ResponseEntity<List<Seats>> response = null;
	try
	{
		List<Seats> slist = fs.getReturnSeatsOfFlight(flightno);
		response = new ResponseEntity<List<Seats>>(slist,HttpStatus.OK);
	}
	catch(Exception e)
	{
		logger.error(e.getMessage());
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"No Data Found");
	}
	return response;
}

@GetMapping(value="/{flightNo}/{countOfHead}")
public ResponseEntity<Integer> getPrice (@PathVariable String flightNo,@PathVariable String countOfHead)
{
	ResponseEntity<Integer> response = null;
	try
	{
		int flag=fs.getPrice(flightNo, Integer.valueOf(countOfHead));
		response = new ResponseEntity<Integer>(flag,HttpStatus.OK);
	}
	catch(Exception e)
	{
		logger.error(e.getMessage());
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Please try again later");
	}
	return response;
}
@GetMapping(value="/roundTrip/{flightNo}/{countOfHead}")
public ResponseEntity<Integer> getReturnPrice (@PathVariable String flightNo,@PathVariable String countOfHead)
{
	ResponseEntity<Integer> response = null;
	try
	{
		int flag=fs.getReturnPrice(flightNo, Integer.valueOf(countOfHead));
		response = new ResponseEntity<Integer>(flag,HttpStatus.OK);
	}
	catch(Exception e)
	{
		logger.error(e.getMessage());
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Please try again later");
	}
	return response;
}
@GetMapping(value="/bookSeats/{flightNo}/{seats}")
public ResponseEntity<String> bookSeats(@PathVariable String flightNo, @PathVariable String seats)
{
	ResponseEntity<String> response = null;
	try {
		String flag=fs.allocatingSeats(flightNo, seats);
		response = new ResponseEntity<String>(flag,HttpStatus.OK);
	}
	catch(Exception e)
	{
		logger.error(e.getMessage());
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Something went wrong, Please try again later");
	}
	return response;
}
@GetMapping(value="/roundTrip/bookSeats/{flightNo}/{seats}")
public ResponseEntity<String> bookReturnSeats(@PathVariable String flightNo, @PathVariable String seats)
{
	ResponseEntity<String> response = null;
	try {
		String flag=fs.allocatingReturnSeats(flightNo, seats);
		response = new ResponseEntity<String>(flag,HttpStatus.OK);
	}
	catch(Exception e)
	{
		logger.error(e.getMessage());
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Something went wrong, Please try again later");
	}
	return response;
}
}
