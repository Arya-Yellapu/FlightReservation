package com.demo.Project.Controller;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.demo.Project.Service.CustomerService;
import com.deno.Project.model.Flights;
import com.deno.Project.model.FlightsRoundTrip;
import com.deno.Project.model.Seats;
import com.deno.Project.model.User;

@Controller
@RequestMapping("/users")
public class CustomerController {

	
	
@Autowired
private CustomerService customerService;

Logger logger = LoggerFactory.getLogger(this.getClass());
	
@GetMapping("/signIn")
public ModelAndView login(@RequestParam String userName,@RequestParam String passWord)
{
	Map<String,String> credentials = new HashMap<String,String>();
	credentials.put(userName, passWord);
	ModelAndView m1 = null;
    try {
    	int flag = customerService.checkValidity(credentials);
        if(flag==0)
        {
             m1= new ModelAndView("welcome");
             m1.addObject("username", userName);
             m1.addObject("password", passWord);
        }
}
    catch(Exception e)
    {
    	m1= new ModelAndView("erro");
    	logger.error(e.getMessage());
    }
	return m1;
}

@GetMapping("/Register")
public ModelAndView homeRegister()
{
	ModelAndView m1 = new ModelAndView("register");
	return m1;
}

@GetMapping("/Submit")
public ModelAndView injectDetails(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String dob,@RequestParam String eMail,@RequestParam String customerName,@RequestParam String customerPassword)
{
	ModelAndView m1 = null;
	try {
		if(customerName.isBlank() && customerPassword.isBlank() && firstName.isBlank() && lastName.isBlank() && dob.isBlank() && eMail.isBlank())
		{
			m1= new ModelAndView("blankregister");
	      
		}
		else
		{
			customerService.injectUsers(customerName, customerPassword, firstName, lastName, dob, eMail);
		      m1 = new ModelAndView("welcome");
		      m1.addObject("username", customerName);
	          m1.addObject("password", customerPassword);
			
		}
	}
	catch(Exception e)
	{
		m1= new ModelAndView("register_error");
		logger.error(e.getMessage());
	}
	
	return m1;
	
}

@GetMapping("/RegisterWithGoogle")
public ModelAndView registerWithGoogle()
{
	ModelAndView m1 = new ModelAndView("registerG");
	return m1;
}

@GetMapping("/submitGoogle")
public ModelAndView submitThroughGoogle(@RequestParam String email,@RequestParam String password)
{
	ModelAndView m1= null;
	RestTemplate res = new RestTemplate();
	try {
		ResponseEntity<User> user = res.getForEntity("http://localhost:3466/google/details/"+email+"/"+password, User.class);
		try {
			customerService.injectUsers(user.getBody().getName(),user.getBody().getPassword(),user.getBody().getFirstname(),user.getBody().getLastname(),user.getBody().getDob().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),user.getBody().getEmail());
            m1 = new ModelAndView("welcome");
            m1.addObject("username", user.getBody().getName());
            m1.addObject("password", user.getBody().getPassword());
		}
		catch(Exception e)
		{
			m1=new ModelAndView("GoogleInjectError");
			logger.error(e.getMessage());
		}
	}
	catch(Exception e)
	{
		m1 = new ModelAndView("registerGerror");
		logger.error(e.getMessage());
	}
	return m1;
	
}

@GetMapping("/selectTrip")
public ModelAndView selectTypeOfTrip(@RequestParam(required=false) String Trip, @RequestParam String userName, @RequestParam String passWord,@RequestParam String source,@RequestParam String destination,@RequestParam String traveldate,@RequestParam String seats, @RequestParam String returndate)
{
	ModelAndView m1 = null;
	RestTemplate res= new RestTemplate();
	try {
		if(Trip!=null)
		{
		if(Trip.equalsIgnoreCase("oneWay") && returndate=="")
		{
		ResponseEntity<Flights[]> response = res.getForEntity("http://localhost:3465/flights/getAvailableFlights/"+source+"/"+destination+"/"+traveldate+"/"+seats, Flights[].class);
	    Flights[] flights = response.getBody();
	    List<Flights> list = new LinkedList<Flights>();
	    for(Flights f: flights)
	    {
	    	list.add(f);
	    }
	    m1 = new ModelAndView("flightsview");
	    m1.addObject("list",list);
	    m1.addObject("count",seats);
	    m1.addObject("username", userName);
	    m1.addObject("password", passWord);
	    m1.addObject("Trip",Trip);
	    }
		else if(Trip.equalsIgnoreCase("roundTrip") && returndate!="")
		{
			ResponseEntity<FlightsRoundTrip[]> response = res.getForEntity("http://localhost:3465/flights/getAvailableReturnFlights/"+source+"/"+destination+"/"+traveldate+"/"+returndate+"/"+seats, FlightsRoundTrip[].class);
			FlightsRoundTrip[] flights = response.getBody();
		    List<FlightsRoundTrip> list = new LinkedList<FlightsRoundTrip>();
		    for(FlightsRoundTrip f: flights)
		    {
		    	list.add(f);
		    }
		    m1 = new ModelAndView("flightsviewwithreturn");
		    m1.addObject("list",list);
		    m1.addObject("count",seats);
		    m1.addObject("username", userName);
		    m1.addObject("password", passWord);
		    m1.addObject("Trip",Trip);
		}
		if(Trip.equalsIgnoreCase("oneWay") && returndate!="")
		{
			m1= new ModelAndView("TripError");
			m1.addObject("username", userName);
		    m1.addObject("password", passWord);
			logger.error(userName+" selected returndate for oneway");
	    }
		if(Trip.equalsIgnoreCase("roundTrip") && returndate=="")
		{
			m1= new ModelAndView("TripError");
			m1.addObject("username", userName);
		    m1.addObject("password", passWord);
			logger.error(userName+" has not selected returndate for roundtrip");
		}
		}
		else
		{
			m1= new ModelAndView("TripError");
			m1.addObject("username", userName);
		    m1.addObject("password", passWord);
			logger.error(userName+" has not selected any of the trip options");
		}
	}
	catch(Exception e)
	{
		m1= new ModelAndView("flightserror");
		logger.error(e.getMessage());
	}
	return m1;
}

/*@GetMapping("/getAvailableFlights")
public ModelAndView getAvailableFlights(@RequestParam String source,@RequestParam String destination,@RequestParam String traveldate,@RequestParam String seats,@RequestParam String userName,@RequestParam String passWord)
{
	ModelAndView m1 = null;
	RestTemplate res= new RestTemplate();
	try {
		ResponseEntity<Flights[]> response = res.getForEntity("http://localhost:3465/flights/getAvailableFlights/"+source+"/"+destination+"/"+traveldate+"/"+seats, Flights[].class);
	    Flights[] flights = response.getBody();
	    List<Flights> list = new LinkedList<Flights>();
	    for(Flights f: flights)
	    {
	    	list.add(f);
	    }
	    m1 = new ModelAndView("flightsview");
	    m1.addObject("list",list);
	    m1.addObject("count",seats);
	    m1.addObject("username", userName);
	    m1.addObject("password", passWord);
	    }
	catch(Exception e)
	{
		m1= new ModelAndView("flightserror");
		logger.error(e.getMessage());
	}
	return m1;
}*/

@GetMapping("/getSeatsAvailable")
public ModelAndView getSeatsAvailable(@RequestParam String trip,@RequestParam String flightno,@RequestParam String seats,@RequestParam String userName,@RequestParam String passWord)
{
	RestTemplate rest= new RestTemplate();
	ResponseEntity<Seats []> res = null;
	if(trip.equals("oneWay"))
	{
	 res = rest.getForEntity("http://localhost:3465/flights/"+flightno, Seats[].class);
	}
	if(trip.equals("roundTrip"))
	{
		System.out.println(flightno);
	 res = rest.getForEntity("http://localhost:3465/flights/roundTrip/"+flightno, Seats[].class);
	}
	Seats[] seatsArr = res.getBody();
	List<Seats> seatsList = new LinkedList<Seats>();
	for(Seats s : seatsArr)
	{
		seatsList.add(s);
	}
	ModelAndView m1= new ModelAndView("SeatsView");
	m1.addObject("seatsList", seatsList);
	m1.addObject("flightNo", flightno);
	m1.addObject("count",seats);
	m1.addObject("username", userName);
    m1.addObject("password", passWord);
    m1.addObject("Trip",trip);
	return m1;
}

@GetMapping("/proceedToPayment")
public ModelAndView makePayment(@RequestParam String trip,@RequestParam(value="selectedseats", required=false) String selectedSeats,@RequestParam String flightno,@RequestParam String seats,@RequestParam String userName,@RequestParam String passWord)
{
    System.out.println(trip);
	ModelAndView m1 = null;
	RestTemplate rest = new RestTemplate();
	if(!(selectedSeats==null))
	{
		String[] arr = selectedSeats.split(",");
		 if(arr.length!=Integer.valueOf(seats))
		    {
		    	m1 = new ModelAndView("InvalidSelection");
		    	m1.addObject("flightNo", flightno);
		    	m1.addObject("count",seats);
		    	m1.addObject("username", userName);
			    m1.addObject("password", passWord);
			    m1.addObject("Trip",trip);
		    }
		 else
		 {
	    ResponseEntity<Integer> response = null;
	    if(trip.equalsIgnoreCase("oneWay"))
	    {
	    	response = rest.getForEntity("http://localhost:3465/flights/"+flightno+"/"+seats, Integer.class);
	    }
	    if(trip.equalsIgnoreCase("roundTrip"))
	    {
	    	response = rest.getForEntity("http://localhost:3465/flights/roundTrip/"+flightno+"/"+seats, Integer.class);
	    }
	    int flag=response.getBody();
		m1=new ModelAndView("payment");
		m1.addObject("total", flag);
		m1.addObject("seats", selectedSeats);
		m1.addObject("flightNo", flightno);
		m1.addObject("username", userName);
	    m1.addObject("password", passWord);
	    m1.addObject("Trip",trip);
		 }
	}
   else
	{
		
		m1 = new ModelAndView("emptySelection");
		m1.addObject("flightNo", flightno);
    	m1.addObject("count",seats);
    	m1.addObject("username", userName);
	    m1.addObject("password", passWord);
	    m1.addObject("Trip",trip);
	}
	return m1;
}

@GetMapping("/PaymentDetails")
public ModelAndView PaymentDetails(@RequestParam String trip,@RequestParam String cost,@RequestParam String cardNumber,@RequestParam String cvv,@RequestParam String expiryMonth,@RequestParam String expiryYear,@RequestParam String cardHolderName,@RequestParam String Seats,@RequestParam String flightno,@RequestParam String userName,@RequestParam String passWord)
{
	ModelAndView m1 =null;
	RestTemplate rest = new RestTemplate();
	ResponseEntity<String> response = null;
	try {
		response=rest.getForEntity("http://localhost:3456/cards/"+cardNumber+"/"+cvv+"/"+expiryMonth+"/"+expiryYear+"/"+cardHolderName+"/"+cost, String.class);
		String flag= response.getBody();
		if(flag.equalsIgnoreCase("Success"))
		{
			if(trip.equalsIgnoreCase("oneWay"))
			{
			response=rest.getForEntity("http://localhost:3465/flights/bookSeats/"+flightno+"/"+Seats, String.class);
			}
			if(trip.equalsIgnoreCase("roundTrip"))
			{
			response=rest.getForEntity("http://localhost:3465/flights/roundTrip/bookSeats/"+flightno+"/"+Seats, String.class);
			}
			m1=new ModelAndView("final");
			m1.addObject("ReservationId", response.getBody());
			m1.addObject("username", userName);
		    m1.addObject("password", passWord);
		}
		}
	catch(Exception e)
	{
		m1=new ModelAndView("ErrorInPayment");
		m1.addObject("username", userName);
	    m1.addObject("password", passWord);
		logger.error(e.getMessage());
	}
	return m1;
}


	
}
