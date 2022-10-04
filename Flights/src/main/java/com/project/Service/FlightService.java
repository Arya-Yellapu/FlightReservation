package com.project.Service;

import java.util.List;

import com.project.Model.Flights;
import com.project.Model.FlightsRoundTrip;
import com.project.Model.Seats;

public interface FlightService {
	public List<Flights> getFlightsAvailable(String source, String destination, String traveldate, String seatsRequired) throws Exception;
	public List<FlightsRoundTrip> getReturnFlightsAvailable(String source, String destination, String traveldate, String returndate, String seatsRequired) throws Exception;
	public List<Seats> getSeatsOfFlight(String flightno) throws Exception;
	public List<Seats> getReturnSeatsOfFlight(String flightno) throws Exception;
	public int getPrice(String flightNo, int CountOfHead) throws Exception;
	public int getReturnPrice(String flightNo, int CountOfHead) throws Exception;
	public String allocatingSeats(String flightNo, String seats) throws Exception;
	public String allocatingReturnSeats(String flightNo, String seats) throws Exception;
}
