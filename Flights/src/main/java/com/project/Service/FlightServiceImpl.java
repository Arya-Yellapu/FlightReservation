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
import com.project.Model.Seats;

@Transactional
@Service
public class FlightServiceImpl implements FlightService {

@Autowired
private FlightDAO flightdao;

public List<Flights> getFlightsAvailable(String source, String destination, String traveldate, String seatsRequired) throws Exception
{
	List<Flights> list = new LinkedList<Flights>();
	LocalDate date = LocalDate.parse(traveldate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	LocalDate today = LocalDate.now();
	int seats=Integer.valueOf(seatsRequired);
	try {
		list=flightdao.getFlightsAvailable(source, destination, date,seats);
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

public List<Flights> getReturnFlightsAvailable(String source, String destination, String traveldate, String returndate, String seatsRequired) throws Exception
{
	List<Flights> list = new LinkedList<Flights>();
	LocalDate date = LocalDate.parse(traveldate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	LocalDate returnDate = LocalDate.parse(returndate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	LocalDate today = LocalDate.now();
	int seats=Integer.valueOf(seatsRequired);
	try {
		list=flightdao.getReturnFlightsAvailable(source, destination, date, returnDate, seats);
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
		throw new Exception("The  Travel Date is before Today");
	}
	if(returnDate.isBefore(today))
	{
		throw new Exception("The Return Date is before Today");
	}
	if(returnDate.isBefore(date))
	{
		throw new Exception("The Return Date is before Travel Date");
	}
	return list;
}

public List<Seats> getSeatsOfFlight(String flightno) throws Exception
{
	List<Seats> slist = new LinkedList<Seats>();
	try
	{
		slist=flightdao.getSeatsOfFlight(flightno);
	}
	catch(Exception e)
	{
		throw e;
	}
	
	if(slist.isEmpty())
	{
		throw new Exception("No Seats Available");
	}
	return slist;
}

public int getPrice(String flightNo, int CountOfHead) throws Exception
{
	int flag=0;
	if(flightNo==null)
	{
		throw new Exception("Flight number cannot be empty");
	}
	if(CountOfHead==0)
	{
		throw new Exception("Seats cannot be Empty");
	}
	try
	{
		flag=flightdao.getPrice(flightNo, CountOfHead);
	}
	catch(Exception e)
	{
		throw e;
	}
	return flag;
}

public String allocatingSeats(String flightNo, String seats) throws Exception
{
	String flag=null;
	if(flightNo==null)
	{
		throw new Exception("Flight number cannot be empty");
	}
	if(seats==null)
	{
		throw new Exception("Seats cannot be Empty");
	}
	try
	{
		flag=flightdao.allocatingSeats(flightNo, seats);
	}
	catch(Exception e)
	{
		throw e;
	}
	return flag;
}
}
