package com.infy.Service;

public interface CardService {
	public int checkValidity(long cardNo, int cvv, int expiryMonth, int expiryYear, String name) throws Exception;
}
