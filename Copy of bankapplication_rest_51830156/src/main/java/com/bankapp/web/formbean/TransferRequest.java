package com.bankapp.web.formbean;

public class TransferRequest {

	
	private Long fromAccountNumber;
	private Long toAccountNumber;
	private double amount;
	
	
	public Long getFromAccountNumber() {
		return fromAccountNumber;
	}
	public void setFromAccountNumber(Long fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}
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
	public TransferRequest(Long fromAccountNumber, Long toAccountNumber, double amount) {
		super();
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.amount = amount;
	}
	public TransferRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
