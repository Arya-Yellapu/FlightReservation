package com.infy.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.infy.Service.CardService;

@RestController
@RequestMapping(value="/cards")
public class CardController {
	
@Autowired
private CardService cardService;

@GetMapping(value="/{cardNo}/{cvv}/{expiryMonth}/{expiryYear}/{name}")
public ResponseEntity<String> checkValidity(@PathVariable long cardNo, @PathVariable int cvv, @PathVariable int expiryMonth,@PathVariable int expiryYear, @PathVariable String name)
{
	ResponseEntity<String> response=null;
	try {
		int flag=cardService.checkValidity(cardNo, cvv, expiryMonth, expiryYear, name);
		String message=null;
		if(flag==1)
		{
			message="Success";
		}
		response = new ResponseEntity<String>(message,HttpStatus.OK);
		
	}
	catch(Exception e)
	{
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
	}
	return response;
}

}
