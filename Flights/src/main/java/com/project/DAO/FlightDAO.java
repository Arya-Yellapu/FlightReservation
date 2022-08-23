package com.project.DAO;

import java.time.LocalDate;
import java.util.List;

import com.project.Model.Flights;
import com.project.Model.Seats;

public interface FlightDAO {
	public List<Flights> getFlightsAvailable(String source, String destination, LocalDate traveldate, int seats);
	public List<Seats> getSeatsOfFlight(String flightno);
	public int getPrice(String flightNo, int CountOfHead);
	public String allocatingSeats(String flightNo, String seats);
}
