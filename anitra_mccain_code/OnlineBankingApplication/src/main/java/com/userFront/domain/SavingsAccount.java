package com.userFront.domain;

import java.math.BigDecimal;
import java.util.List;

public class SavingsAccount {
	private Long id;
	private int accountNumber;
	private BigDecimal accountBalance;
	
	private List<SavingsTransaction> savingsTransactionList;
	
	//------------------------------------------------------------------------------------------------------------------
	//Auto generate accessors and modifiers

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

	public List<SavingsTransaction> getSavingsTransactionList() {
		return savingsTransactionList;
	}

	public void setSavingsTransactionList(List<SavingsTransaction> savingsTransactionList) {
		this.savingsTransactionList = savingsTransactionList;
	}
	
}
