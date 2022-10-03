package com.project.Model;

import java.time.LocalDate;
import java.util.List;

public class Flights {

private String flightno;
private String source;
private String destination;
private int seatsavailable;
private LocalDate traveldate;
private String name;
private int priceperperson;
private List<Seats> seats;

public List<Seats> getSeats() {
	return seats;
}
public void setSeats(List<Seats> seats) {
	this.seats = seats;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPriceperperson() {
	return priceperperson;
}
public void setPriceperperson(int priceperperson) {
	this.priceperperson = priceperperson;
}
public String getFlightno() {
	return flightno;
}
public void setFlightno(String flightno) {
	this.flightno = flightno;
}
public String getSource() {
	return source;
}
public void setSource(String source) {
	this.source = source;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public int getSeatsavailable() {
	return seatsavailable;
}
public void setSeatsavailable(int seatsavailable) {
	this.seatsavailable = seatsavailable;
}
public LocalDate getTraveldate() {
	return traveldate;
}
public void setTraveldate(LocalDate traveldate) {
	this.traveldate = traveldate;
}

@Override
public String toString()
{
	return this.getFlightno();
}

}
