package com.demo.Project.DAO;

import java.time.LocalDate;
import java.util.Map;

public interface CustomerDAO {
	public int checkValidity(Map<String,String> credentials);
	public String injectUsers(String customerName, String customerPassword, String firstName, String lastName, LocalDate dob, String email);
	public int checkUserExistence(String customerName);
}
