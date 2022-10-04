package com.project.Entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.project.Model.Seats;

@Entity
@Table(name="flightsforroundtrip")
public class FlightRoundTripEntity {

@Id
@Column(name="flightno")
private String flightno;

@Column(name="source")
private String source;

@Column(name="destination")
private String destination;

@Column(name="seatsavailable")
private int seatsavailable;

@Column(name="traveldate")
private LocalDate traveldate;

@Column(name="name")
private String name;

@Column(name="priceperperson")
private int priceperperson;

@Column(name="returndate")
private LocalDate returndate;

@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="flightnoforroundtrip")
private List<SeatEntity> seats;

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

public LocalDate getReturndate() {
	return returndate;
}

public void setReturndate(LocalDate returndate) {
	this.returndate = returndate;
}

public List<SeatEntity> getSeats() {
	return seats;
}

public void setSeats(List<SeatEntity> seats) {
	this.seats = seats;
}
}
