package com.project.DAO;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.project.Entity.FlightEntity;
import com.project.Entity.FlightRoundTripEntity;
import com.project.Entity.SeatEntity;
import com.project.Model.Flights;
import com.project.Model.FlightsRoundTrip;
import com.project.Model.Seats;
import com.project.Model.Seats.Status;

@Repository
public class FlightDAOImpl implements FlightDAO {
	
static int counter=0;

@PersistenceContext
private EntityManager em;

public List<Flights> getFlightsAvailable(String source, String destination, LocalDate traveldate, int seats)
{
	Query query = em.createQuery("select fs from FlightEntity fs where fs.source=?1 and fs.destination=?2 and fs.traveldate=?3 and fs.seatsavailable>=?4");
	query.setParameter(1, source);
	query.setParameter(2, destination);
	query.setParameter(3, traveldate);
	query.setParameter(4, seats);
	List<FlightEntity> entitylist = query.getResultList();
	List<Flights> modellist = new LinkedList<>();
	if(!entitylist.isEmpty())
	{
		entitylist.stream().forEach(n->{
			Flights f = new Flights();
			f.setDestination(n.getDestination());
			f.setFlightno(n.getFlightno());
			f.setSeatsavailable(n.getSeatsavailable());
			f.setSource(n.getSource());
			f.setTraveldate(n.getTraveldate());
			f.setName(n.getName());
			f.setPriceperperson(n.getPriceperperson());
			List<SeatEntity> selist = n.getList();
			List<Seats> slist = new LinkedList<>(); 
			selist.stream().forEach(m->{
				Seats s = new Seats();
				s.setReservationid(m.getReservationid());
				s.setSeatno(m.getSeatno());
				s.setStatus(m.getStatus());
				slist.add(s);
			});
			f.setSeats(slist);
			modellist.add(f);
		});
	}
	return modellist;
}

public List<FlightsRoundTrip> getReturnFlightsAvailable(String source, String destination, LocalDate traveldate, LocalDate returndate, int seats)
{
	Query query=em.createQuery("select fs from FlightRoundTripEntity fs where fs.source=?1 and fs.destination=?2 and fs.traveldate=?3 and fs.returndate=?4 and fs.seatsavailable>=?5");
	query.setParameter(1, source);
	query.setParameter(2, destination);
	query.setParameter(3, traveldate);
	query.setParameter(4, returndate);
	query.setParameter(5, seats);
	
	List<FlightRoundTripEntity> elist = query.getResultList();
	List<FlightsRoundTrip> mlist = new LinkedList<>();
	if(!elist.isEmpty())
	{
		elist.stream().forEach(n->{
			FlightsRoundTrip f = new FlightsRoundTrip();
			f.setDestination(n.getDestination());
			f.setFlightno(n.getFlightno());
			f.setName(n.getName());
			f.setPriceperperson(n.getPriceperperson());
			f.setReturndate(n.getReturndate());
			f.setSeatsavailable(n.getSeatsavailable());
			f.setSource(n.getSource());
			f.setTraveldate(n.getTraveldate());
			List<SeatEntity> selist = n.getSeats();
			if(!selist.isEmpty())
			{
			List<Seats> smlist= new LinkedList<>();
			selist.stream().forEach(m->{
				Seats s = new Seats();
				s.setReservationid(m.getReservationid());
				s.setSeatno(m.getSeatno());
				s.setStatus(m.getStatus());
				smlist.add(s);
			});
			f.setSeats(smlist);
			}
			mlist.add(f);
			});
	}
	return mlist;
}

public List<Seats> getSeatsOfFlight(String flightno)
{
	FlightEntity fe = em.find(FlightEntity.class, flightno);
	List<SeatEntity> flist=fe.getList();
	List<Seats> slist = new LinkedList<Seats>();
	
	if(!flist.isEmpty()) {
	flist.stream().forEach(n->{
		
		if(n.getStatus().equals(com.project.Model.Seats.Status.Available)) {
		Seats s = new Seats();
		s.setSeatno(n.getSeatno());
		s.setStatus(n.getStatus());
		s.setReservationid(n.getReservationid());
		
		slist.add(s);
		}
	});
	}
	return slist;
}

public List<Seats> getReturnSeatsOfFlight(String flightno)
{
	FlightRoundTripEntity fe = em.find(FlightRoundTripEntity.class, flightno);
	System.out.println(flightno);
	List<SeatEntity> flist=fe.getSeats();
	List<Seats> slist = new LinkedList<Seats>();
	
	if(!flist.isEmpty()) {
	flist.stream().forEach(n->{
		
		if(n.getStatus().equals(com.project.Model.Seats.Status.Available)) {
		Seats s = new Seats();
		s.setSeatno(n.getSeatno());
		s.setStatus(n.getStatus());
		s.setReservationid(n.getReservationid());
		
		slist.add(s);
		}
	});
	}
	return slist;
}

public int getPrice(String flightNo, int CountOfHead)
{
	int flag=0;
	FlightEntity fe = em.find(FlightEntity.class, flightNo);
	if(fe!=null)
	{
		flag=fe.getPriceperperson()*CountOfHead;
	}
	return flag;
	
}

public int getReturnPrice(String flightNo, int CountOfHead)
{
	int flag=0;
	FlightRoundTripEntity fe = em.find(FlightRoundTripEntity.class, flightNo);
	if(fe!=null)
	{
		flag=fe.getPriceperperson()*CountOfHead;
	}
	return flag;
	
}

public String allocatingSeats(String flightNo, String seats)
{
	FlightEntity fe = em.find(FlightEntity.class, flightNo);
	if(fe!=null)
	{
		List<SeatEntity> list = fe.getList();
		String arr[] = seats.split(",");
		for ( String s : arr)
		{
			list.stream().forEach(n->{
				if(n.getSeatno().equalsIgnoreCase(s))
				{
					n.setStatus(Status.Booked);
					n.setReservationid("R"+counter);
					
				}
			});
		}
		fe.setSeatsavailable(fe.getSeatsavailable()-arr.length);
	}
	return "R"+counter++;
}
public String allocatingReturnSeats(String flightNo, String seats)
{
	FlightRoundTripEntity fe = em.find(FlightRoundTripEntity.class, flightNo);
	if(fe!=null)
	{
		List<SeatEntity> list = fe.getSeats();
		String arr[] = seats.split(",");
		for ( String s : arr)
		{
			list.stream().forEach(n->{
				if(n.getSeatno().equalsIgnoreCase(s))
				{
					n.setStatus(Status.Booked);
					n.setReservationid("R"+counter);
					
				}
			});
		}
		fe.setSeatsavailable(fe.getSeatsavailable()-arr.length);
	}
	return "R"+counter++;
}
}
