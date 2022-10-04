package com.demo.Project.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserEntity {

@Id
@Column(name="customername")
private String customerName;

@Column(name="customerpassword")
private String customerPassword;

@Column(name="firstname")
private String firstName;

@Column(name="lastname")
private String lastName;

@Column(name="dob")
private LocalDate dob;

@Column(name="email")
private String email;

public String getCustomerName() {
	return customerName;
}

public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

public String getCustomerPassword() {
	return customerPassword;
}

public void setCustomerPassword(String customerPassword) {
	this.customerPassword = customerPassword;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public LocalDate getDob() {
	return dob;
}

public void setDob(LocalDate dob) {
	this.dob = dob;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}



	
}
