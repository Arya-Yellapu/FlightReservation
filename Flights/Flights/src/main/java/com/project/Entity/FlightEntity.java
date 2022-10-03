package com.project.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flights")
public class FlightEntity {
	
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
