package com.infy.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class AccountEntity {

@Id
@Column(name="accountno")
private long accountno;

@Column(name="accountholdername")
private String accountholdername;

@Column(name="accountbalance")
private long accountbalance;

@Column(name="accounttype")
private String accounttype;

public long getAccountno() {
	return accountno;
}

public void setAccountno(long accountno) {
	this.accountno = accountno;
}

public String getAccountholdername() {
	return accountholdername;
}

public void setAccountholdername(String accountholdername) {
	this.accountholdername = accountholdername;
}

public long getAccountbalance() {
	return accountbalance;
}

public void setAccountbalance(long accountbalance) {
	this.accountbalance = accountbalance;
}

public String getAccounttype() {
	return accounttype;
}

public void setAccounttype(String accounttype) {
	this.accounttype = accounttype;
}


	
}
