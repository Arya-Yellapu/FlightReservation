package com.infy.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cards")
public class CardEntity {

@Id
@Column(name="cardno")
private long cardNo;

@Column(name="cvv")
private int cvv;

@Column(name="expirymonth")
private int expiryMonth;

@Column(name="expiryyear")
private int expiryYear;

@Column(name="name")
private String name;

@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="accountno")
private AccountEntity accountEntity;



public AccountEntity getAccountEntity() {
	return accountEntity;
}

public void setAccountEntity(AccountEntity accountEntity) {
	this.accountEntity = accountEntity;
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
