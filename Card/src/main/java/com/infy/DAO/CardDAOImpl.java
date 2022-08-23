package com.infy.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.infy.Entity.AccountEntity;
import com.infy.Entity.CardEntity;

@Repository
public class CardDAOImpl implements CardDAO{

@PersistenceContext
private EntityManager em;

@Override
public int checkValidity(long cardNo, int cvv, int expiryMonth, int expiryYear, String name, int amount) {
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
		AccountEntity ae = ce.getAccountEntity();
		if(ae.getAccountbalance()>=amount)
		{
			ae.setAccountbalance(ae.getAccountbalance()-amount);
			flag=1;
		}
		else
		{
			flag=-6;
		}
		}
	}
	return flag;
}


}
