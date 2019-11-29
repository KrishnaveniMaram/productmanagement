package com.bankapp.web.formbean;

public class TransactionResponse {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TransactionResponse() {
		
	}

	public TransactionResponse(String message) {
		super();
		this.message = message;
	}
	
	
	
	

}
