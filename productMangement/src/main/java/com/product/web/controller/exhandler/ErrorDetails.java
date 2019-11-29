package com.product.web.controller.exhandler;


import java.time.LocalDate;


public class ErrorDetails {
	
	private String message;
	private LocalDate timestamp;
	private String detail;
	private String contactTo;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDate getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getContactTo() {
		return contactTo;
	}
	public void setContactTo(String contactTo) {
		this.contactTo = contactTo;
	}
	public ErrorDetails(String message, LocalDate timestamp, String detail, String contactTo) {
	
		this.message = message;
		this.timestamp = timestamp;
		this.detail = detail;
		this.contactTo = contactTo;
	}
	public ErrorDetails() {
	
		
	}
	

}
