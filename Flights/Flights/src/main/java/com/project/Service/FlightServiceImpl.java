package com.project.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.DAO.FlightDAO;
import com.project.Model.Flights;

@Transactional
@Service
public class FlightServiceImpl implements FlightService {

@Autowired
private FlightDAO flightdao;

public List<Flights> getFlightsAvailable(String source, String destination, String traveldate) throws Exception
{
	List<Flights> list = new LinkedList<Flights>();
	LocalDate date = LocalDate.parse(traveldate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	LocalDate today = LocalDate.now();	
	try {
		list=flightdao.getFlightsAvailable(source, destination, date);
	}
	catch(Exception e)
	{
		throw e;
	}
	if(list.isEmpty())
	{
		throw new Exception("No Flights Found");
	}
	if(date.isBefore(today))
	{
		throw new Exception("The Date is before Today");
	}
	return list;
}
}
