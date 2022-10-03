package com.demo.Project.DAO;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.demo.Project.Entity.UserEntity;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

@PersistenceContext
private EntityManager em;

public int checkValidity(Map<String,String> credentials)
{
	String userName=null;
	String passWord=null;
	int flag=0;
	for(Map.Entry<String, String> m : credentials.entrySet())
	{
		userName=m.getKey();
		passWord=m.getValue();
	}
	
	Query query = em.createQuery("select u from UserEntity u where u.customerName = ?1 and u.customerPassword = ?2");
	query.setParameter(1, userName);
	query.setParameter(2, passWord);
	
	List<UserEntity> list = query.getResultList();
	if(list.size()==0)
	{
		flag=1;
	}
	return flag;
}

public String injectUsers(String customerName, String customerPassword, String firstName, String lastName, LocalDate dob, String email)
{
   UserEntity ue = new UserEntity();
   ue.setCustomerName(customerName);
   ue.setCustomerPassword(customerPassword);
   ue.setFirstName(firstName);
   ue.setLastName(lastName);
   ue.setDob(dob);
   ue.setEmail(email);
   
   em.persist(ue);
   
   return ue.getCustomerName();
}

public int checkUserExistence(String customerName)
{
	int flag=1;
	UserEntity ue = em.find(UserEntity.class, customerName);
	if(ue!=null)
	{
		flag=0;
	}
	return flag;
}
	
}
