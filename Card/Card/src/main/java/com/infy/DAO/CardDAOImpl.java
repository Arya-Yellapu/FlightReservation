package com.infy.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.infy.Entity.CardEntity;

@Repository
public class CardDAOImpl implements CardDAO{

@PersistenceContext
private EntityManager em;

@Override
public int checkValidity(long cardNo, int cvv, int expiryMonth, int expiryYear, String name) {
	int flag=0;
	CardEntity ce=em.find(CardEntity.class, cardNo);
	if(ce==null)
	{
		flag=-1;
	}
	if(ce!=null)
	{
	    if(ce.getCvv()!=cvv)
		{
			flag=-2;
		}
	    else if(ce.getExpiryYear()!=expiryYear)
		{
			flag=-3;
		}
	    else if(ce.getExpiryMonth()!=expiryMonth)
		{
			flag=-4;
		}
	    else if(!ce.getName().equals(name))
		{
			flag=-5;
		}
		else
		{
		flag=1;
		}
	}
	return flag;
}


}
