package com.project.Model;

import java.time.LocalDate;

public class Flights {

private String flightno;
private String source;
private String destination;
private int seatsavailable;
private LocalDate traveldate;
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



}
