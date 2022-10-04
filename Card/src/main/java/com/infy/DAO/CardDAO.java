package com.infy.DAO;

public interface CardDAO {

public int checkValidity(long cardNo, int cvv, int expiryMonth, int expiryYear, String name, int amount);	
	
}
