package com.demo.Project.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Project.DAO.CustomerDAO;
import com.demo.Project.Entity.UserEntity;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService{

@Autowired
private CustomerDAO customerDAO;

public int checkValidity(Map<String,String> credentials) throws Exception
{
	int flag=0;
	if(customerDAO.checkValidity(credentials)==1)
	{
		throw new Exception("UserName or Password is wrong, please check again");
	}
	else
	{
		flag=customerDAO.checkValidity(credentials);
	}
    return flag;
	}

public String injectUsers(String customerName, String customerPassword, String firstName, String lastName, String dob, String email) throws Exception
{
	String flag=null;
	if(customerDAO.checkUserExistence(customerName)==0)
	{
		throw new Exception("User Exists");
	}
	else
	{
		LocalDate date = LocalDate.parse(dob, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		flag=customerDAO.injectUsers(customerName, customerPassword, firstName, lastName, date, email);
	}
	return flag;
}
	
}
