package com.bankapp.model.Service;

import java.util.List;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;

public interface AccountService {
	  void deposit(Long accountNumber, double amount, String authname);
	    void withdraw(Long accountNumber, double amount,String authname);
	    void transfer(Long fromAccNumber, Long toAccNumber, double amount,String authname);
	    public List<Account> findAll();
	  public List<Customer> getAllCustomers();
}
