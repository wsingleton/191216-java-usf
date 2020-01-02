package com.userFront.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class PrimaryAccount {

	@Id
	@GeneratedValue
	private Long id;
	private int accountNumber;
	//BigDecimal represents a floating number. Since this is not a primitive you cannot use arithmetic operators
	//you must used calculation methods.
	private BigDecimal accountBalance;

	//One primary account can have many transactions
	@OneToMany(mappedBy = "primaryAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore //
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
