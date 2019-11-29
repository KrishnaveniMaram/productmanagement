package com.bankapp.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.Repository.AccountRepository;
import com.bankapp.model.Repository.AppUserRepository;
import com.bankapp.model.Repository.CustomerRepository;
import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AppUser;
import com.bankapp.model.entities.Customer;

@RestController
@RequestMapping(path = "/api/accounts")
public class AccountMangController {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private AppUserRepository appuserRepository;
	@Autowired
	private CustomerRepository customerRepo;

	@GetMapping(path = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> getAllAccountDetails() {

		return new ResponseEntity<List<Account>>(accountRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/account/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> getAccountwithAccId(@PathVariable(name = "id") Long accountNumber) {

		Account account = accountRepository.findByAccountNumber(accountNumber);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}

	@PostMapping(path = "/account", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> createnewAccount(@RequestBody Account account) {
		Account account2 = accountRepository.save(account);

		return new ResponseEntity<Account>(account2, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/account/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> deleteAccount(@PathVariable(name = "id") Long accountNumber) {

		Account account = accountRepository.findByAccountNumber(accountNumber);
		accountRepository.delete(account);

		return new ResponseEntity<Account>(HttpStatus.OK);
	}

	@GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AppUser>> getAllUsers() {
		return new ResponseEntity<List<AppUser>>(appuserRepository.findAll(), HttpStatus.OK);
	}
//updating users
	//gettting customer with account id and updating
	@PostMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AppUser> createNewUser(@RequestBody AppUser appUser) {
		AppUser appUser2 = appuserRepository.save(appUser);
		return new ResponseEntity<AppUser>(appUser2, HttpStatus.CREATED);
	}

	@GetMapping(path = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<List<Customer>>(customerRepo.findAll(), HttpStatus.OK);
	}

	/*@PutMapping(path = "/customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> updateCustomer(@PathVariable(name = "id") Long id, 
			@RequestBody Customer customer) {
		Optional<Customer> customer1 = customerRepo.findById(id);
		Customer customer2 = customerRepo.save(customer);
		return new ResponseEntity<Customer>(customer2, HttpStatus.OK);

	}*/
	/*@PostMapping(path="/")
	public ResponseEntity<Account> AccountUpdation(){
		return null;
	}*/
	
	
	/*@GetMapping(path="/customer/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> getCustomerByAccountId(@PathVariable(name="id")long accountNumber){
		Account account=accountRepository.findByAccountNumber(accountNumber);
		List<Customer> customers =account.getCustomer();
		return new ResponseEntity<List<Customer>>((List<Customer>) customers,HttpStatus.OK);
	}
	*/

}
