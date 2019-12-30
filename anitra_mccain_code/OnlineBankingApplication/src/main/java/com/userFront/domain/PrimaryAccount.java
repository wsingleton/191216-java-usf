package com.userFront.domain;

import java.math.BigDecimal;
import java.util.List;

public class PrimaryAccount {
	private Long id;
	private int accountNumber;
	//BigDecimal represents a floating number. Since this is not a primitive you cannot use arithmetic operators
	//you must used calculation methods.
	private BigDecimal accountBalance;
	
	private List<PrimaryTransaction> primaryTransactionList;
	
	//------------------------------------------------------------------------------------------------------------------
	//Auto generate getters and setters for the private fields

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public List<PrimaryTransaction> getPrimaryTransactionList() {
		return primaryTransactionList;
	}

	public void setPrimaryTransactionList(List<PrimaryTransaction> primaryTransactionList) {
		this.primaryTransactionList = primaryTransactionList;
	}
	
	
	

}
