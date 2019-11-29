package com.bankapp.web.formbean;

public class DepositRequest {

	
	private Long toAccountNumber;
	private double amount;
	
	
	
	
	
	public Long getToAccountNumber() {
		return toAccountNumber;
	}
	public void setToAccountNumber(Long toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public DepositRequest(Long toAccountNumber, double amount) {
		super();
		this.toAccountNumber = toAccountNumber;
		this.amount = amount;
	}
	public DepositRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
