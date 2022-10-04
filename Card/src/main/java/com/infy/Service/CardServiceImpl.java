package com.infy.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.DAO.CardDAO;

@Transactional
@Service
public class CardServiceImpl implements CardService{

@Autowired
private CardDAO cardDAO;

public int checkValidity(long cardNo, int cvv, int expiryMonth, int expiryYear, String name, int amount) throws Exception
{
	int flag = cardDAO.checkValidity(cardNo, cvv, expiryMonth, expiryYear, name, amount);
	if(flag==-1)
	{
		throw new Exception("Card Number Invalid");
	}
	if(flag==-2)
	{
		throw new Exception("cvv Invalid");
	}
	if(flag==-3)
	{
		throw new Exception("expiryYear Invalid");
	}
	if(flag==-4)
	{
		throw new Exception("expiryMonth Invalid");
	}
	if(flag==-5)
	{
		throw new Exception("Name Invalid");
	}
	if(flag==-6)
	{
		throw new Exception("Not Enough Balance");
	}
	return flag;
}
	
}
