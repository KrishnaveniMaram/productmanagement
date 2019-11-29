package com.bankapp.web.formbean;

public class WithdrawRequest {
	
	private Long fromAccountNumber;
	private double amount;
	
	public Long getFromAccountNumber() {
		return fromAccountNumber;
	}
	public void setFromAccountNumber(Long fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public WithdrawRequest(Long fromAccountNumber, double amount) {
		super();
		this.fromAccountNumber = fromAccountNumber;
		this.amount = amount;
	}
	public WithdrawRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
