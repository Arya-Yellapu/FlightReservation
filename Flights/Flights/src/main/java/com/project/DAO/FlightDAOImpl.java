package com.project.DAO;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.project.Entity.FlightEntity;
import com.project.Model.Flights;

@Repository
public class FlightDAOImpl implements FlightDAO {

@PersistenceContext
private EntityManager em;

public List<Flights> getFlightsAvailable(String source, String destination, LocalDate traveldate)
{
	Query query = em.createQuery("select fs from FlightEntity fs where fs.source=?1 and fs.destination=?2 and fs.traveldate=?3");
	query.setParameter(1, source);
	query.setParameter(2, destination);
	query.setParameter(3, traveldate);
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
			
			modellist.add(f);
		});
	}
	return modellist;
}
}
