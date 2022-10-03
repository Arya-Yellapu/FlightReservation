package com.project.Service;

import java.util.List;

import com.project.Model.Flights;

public interface FlightService {
	public List<Flights> getFlightsAvailable(String source, String destination, String traveldate) throws Exception;
}
