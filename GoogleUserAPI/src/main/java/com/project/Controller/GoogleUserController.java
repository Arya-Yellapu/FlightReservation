package com.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.Model.GoogleUser;
import com.project.Service.GoogleUserService;

@RestController
@RequestMapping(value="/google")
public class GoogleUserController {

@Autowired
private GoogleUserService gs;

@GetMapping(value="/details/{customerEmail}/{customerPassword}")
public ResponseEntity<GoogleUser> getUserDetails(@PathVariable String customerEmail, @PathVariable String customerPassword)
{
	ResponseEntity<GoogleUser> response = null;
	try {
		GoogleUser g = gs.getData(customerEmail, customerPassword);
		response = new ResponseEntity<GoogleUser>(g,HttpStatus.OK);
	}
	catch(Exception e)
	{
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"No Data Fetched");
	}
	return response;
}
	
}
