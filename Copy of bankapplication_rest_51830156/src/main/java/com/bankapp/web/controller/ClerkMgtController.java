package com.bankapp.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.Service.AccountService;
import com.bankapp.web.formbean.DepositRequest;
import com.bankapp.web.formbean.TransactionResponse;
import com.bankapp.web.formbean.TransferRequest;
import com.bankapp.web.formbean.WithdrawRequest;

@RestController

@RequestMapping(path = "/api/forms")
public class ClerkMgtController {
	@Autowired
	private AccountService accountService;

	/*@GetMapping(path = "account/withdraw/{id}/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> withdrawMoney(@PathVariable(name = "id") Long accountNumber,
			@PathVariable(name = "amount") double amount) {
		accountService.withdraw(accountNumber, amount);
		return null;
	}

	@PostMapping(path = "account/deposit/{id}/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> depositMoney(@PathVariable(name = "id") Long accountNumber,
			@PathVariable(name = "amount") double amount) {
		accountService.deposit(accountNumber, amount);
		return null;
	}

	@PostMapping(path = "account/transfer/{fromAcc}/{toAcc}/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> transferMoney(@PathVariable(name = "fromAcc") Long fromAccNumber,
			@PathVariable(name = "toAcc") Long toAccNumber, @PathVariable(name = "amount") double amount) {
		accountService.transfer(fromAccNumber, toAccNumber, amount);
		return null;
	}
	*/
	
	
	
	@PostMapping(path="/withdraw",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionResponse> getMoneyFromAccount(@RequestBody WithdrawRequest request,
			TransactionResponse response,Principal principal)
	{
		accountService.withdraw(request.getFromAccountNumber(),request.getAmount(),principal.getName());
	
		TransactionResponse response1=new TransactionResponse(request.getAmount()+"you amount is witthdwawn from"+request.getFromAccountNumber());
		
	return  ResponseEntity.ok().body(response1);
	}
	
	@PostMapping(path="/deposit",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionResponse> DepositMoney(@RequestBody DepositRequest request,
		 TransactionResponse response ,Principal principal){
		accountService.deposit(request.getToAccountNumber(),request.getAmount(),principal.getName());
	
		TransactionResponse response1=new TransactionResponse(request.getAmount()+"you amount is deposited to"+request.getToAccountNumber());
		
	return  ResponseEntity.ok().body(response1);
	}
	
	@PostMapping(path="/transfer",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionResponse> transferFund(@RequestBody TransferRequest request,
		TransactionResponse response,Principal principal){
		accountService.transfer(request.getFromAccountNumber(), request.getToAccountNumber(), request.getAmount(),principal.getName());
	
		TransactionResponse response1=new TransactionResponse(request.getAmount()+"you amount is transfered to"+request.getToAccountNumber());
		
	return  ResponseEntity.ok().body(response1);
	}
		
}
