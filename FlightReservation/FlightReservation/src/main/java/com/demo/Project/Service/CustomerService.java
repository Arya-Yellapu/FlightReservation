package com.demo.Project.Service;

import java.util.Map;

public interface CustomerService {

	public int checkValidity(Map<String,String> credentials) throws Exception;
	public String injectUsers(String customerName, String customerPassword, String firstName, String lastName, String dob, String email) throws Exception;
	
}
