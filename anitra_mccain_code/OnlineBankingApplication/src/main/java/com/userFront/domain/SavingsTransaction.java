package com.userFront.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SavingsTransaction {
	private Long id;
	private Date date;
	private String description;
	private String type;
	private String status;
	private BigDecimal availableBalance;
	
	private SavingsAccount savingsAccount;
	
	public SavingsTransaction() {}
	
	
	//Auto generate constructor
	public SavingsTransaction(Date date, String description, String type, String status, BigDecimal availableBalance,
			SavingsAccount savingsAccount) {
		super();
		this.date = date;
		this.description = description;
		this.type = type;
		this.status = status;
		this.availableBalance = availableBalance;
		this.savingsAccount = savingsAccount;
	}


	//Auto generate accessors and modifiers
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}


	public void setAvailableBalance(BigDecimal availableBalance) {
		this.availableBalance = availableBalance;
	}


	public SavingsAccount getSavingsAccount() {
		return savingsAccount;
	}


	public void setSavingsAccount(SavingsAccount savingsAccount) {
		this.savingsAccount = savingsAccount;
	}
	
	
	
	
	
	
}
