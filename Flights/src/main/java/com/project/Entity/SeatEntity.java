package com.project.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.project.Model.Seats.Status;

@Entity
@Table(name="seats")
public class SeatEntity {

@Id
@Column(name="seatno")
private String seatno;

@Enumerated(EnumType.STRING)
private Status status;

@Column(name="reservationid")
private String reservationid;

public String getSeatno() {
	return seatno;
}

public void setSeatno(String seatno) {
	this.seatno = seatno;
}

public Status getStatus() {
	return status;
}

public void setStatus(Status status) {
	this.status = status;
}

public String getReservationid() {
	return reservationid;
}

public void setReservationid(String reservationid) {
	this.reservationid = reservationid;
}	


}
