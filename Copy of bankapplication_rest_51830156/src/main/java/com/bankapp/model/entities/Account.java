package com.bankapp.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "account_table_101")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountNumber;

	private Double balance;
	private boolean blocked;
	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Customer customer;
	//@OneToOne
	//@JsonIgnore
	//private Address address;
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<TranscationData> tx = new ArrayList<>();

	public void addTranscation(TranscationData transcationData) {
		tx.add(transcationData);
		transcationData.setAccount(this);
	}

	
	public List<TranscationData> getTx() {
		return tx;
	}

	public void setTx(List<TranscationData> tx) {
		this.tx = tx;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
		customer.setAccount(this);
	}

	public Account(Double balance, boolean blocked, Customer customer) {
		super();
		this.balance = balance;
		this.blocked = blocked;
		this.customer = customer;

	}

	public Account() {

	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

}
