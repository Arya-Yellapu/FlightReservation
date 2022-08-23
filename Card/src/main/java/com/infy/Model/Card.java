package com.infy.Model;

public class Card {

private long cardNo;
private int cvv;
private int expiryMonth;
private int expiryYear;
private String name;
private Account account;

public Account getAccount() {
	return account;
}
public void setAccount(Account account) {
	this.account = account;
}
public long getCardNo() {
	return cardNo;
}
public void setCardNo(long cardNo) {
	this.cardNo = cardNo;
}
public int getCvv() {
	return cvv;
}
public void setCvv(int cvv) {
	this.cvv = cvv;
}

public int getExpiryMonth() {
	return expiryMonth;
}
public void setExpiryMonth(int expiryMonth) {
	this.expiryMonth = expiryMonth;
}
public int getExpiryYear() {
	return expiryYear;
}
public void setExpiryYear(int expiryYear) {
	this.expiryYear = expiryYear;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}



	
}
