package com.bankapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bankapp.model.Repository.AccountRepository;
import com.bankapp.model.Repository.AppUserRepository;
import com.bankapp.model.Repository.CustomerRepository;
import com.bankapp.model.Repository.TranscationDataRepository;
import com.bankapp.model.Repository.TranscationLogRepository;
import com.bankapp.model.Service.AccountService;
import com.bankapp.model.Service.AppUserservice;
import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Address;
import com.bankapp.model.entities.AppUser;
import com.bankapp.model.entities.Customer;
@EnableTransactionManagement
@SpringBootApplication
public class BankapplicationBootV1Application implements CommandLineRunner {
	
	@Autowired
	private AppUserservice appUserservice;
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(BankapplicationBootV1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	/*accountService.deposit(3L, 600);*/
	
	/*accountService.withdraw(2L, 1000);*/
		
	/*	accountService.transfer(1L, 2L, 100);*/
		
		/*Address address1=new Address("12-673", "cmk/4-9886", "55645", "cmk", "india");
		Address address2=new Address("13-6673", "ong/7-999", "6877", "ong", "india");
		Address address3=new Address("15-7876", "hyd/8-886", "778945", "hyd", "india");
	
		Customer customer1=new Customer("kittu", "kittu@gmail.com", "1234556678",address1);
		Customer customer2=new Customer("lithu", "lithu@gmail.com", "5675787623",address2);
		Customer customer3=new Customer("lithi", "lithi@gmail.com", "998765433",address3);
		
		Account account=new Account(1000.0, false, customer1);
        Account account2=new Account(2000.0, false,customer2);
        Account account3=new Account(3000.0, false,customer3);

  
		
        address1.setCustomer(customer1);
		address2.setCustomer(customer2);
		address3.setCustomer(customer3);
		
		customer1.setAccount(account);
		customer2.setAccount(account2);
		customer3.setAccount(account3);
		
		
		accountRepository.save(account);
		accountRepository.save(account2);
		accountRepository.save(account3);
		
		customerRepository.save(customer1);
		customerRepository.save(customer2);	
		customerRepository.save(customer3);*/

	/*appUserservice.addUser(new AppUser("kittu", "kittu123", "kittu@gmail.com", 
				true, new String[]{"ROLE_ADMIN"}));
		appUserservice.addUser(new AppUser("lithu", "lithu123", "lithu@gmail.com", 
				true, new String[]{"ROLE_MGR"}));
		appUserservice.addUser(new AppUser("lithi", "lithi123", "lithi@gmail.com", 
				true, new String[]{"ROLE_CLERK"}));*/
		
	}

}
