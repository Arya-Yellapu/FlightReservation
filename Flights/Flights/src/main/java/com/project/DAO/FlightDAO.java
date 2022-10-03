package com.project.DAO;

import java.time.LocalDate;
import java.util.List;

import com.project.Model.Flights;

public interface FlightDAO {
	public List<Flights> getFlightsAvailable(String source, String destination, LocalDate traveldate);
}
