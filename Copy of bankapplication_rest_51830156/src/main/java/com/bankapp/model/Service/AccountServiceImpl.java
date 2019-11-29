package com.bankapp.model.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.Repository.AccountRepository;
import com.bankapp.model.Repository.CustomerRepository;
import com.bankapp.model.Repository.TranscationDataRepository;
import com.bankapp.model.Repository.TranscationLogRepository;
import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.entities.TranscationData;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CustomerRepository  customerRepository;
	@Autowired
	private TranscationDataRepository  txDataRepository;
	@Autowired
	private TranscationLogRepository  txLogRepository;

	@Override
	public void deposit(Long accountNumber, double amount,String authname) {
	Account account=accountRepository.findByAccountNumber(accountNumber);
	
	account.setBalance(account.getBalance()+amount);
	TranscationData transcationData=new TranscationData("deposit", amount);
	account.addTranscation(transcationData);
	accountRepository.save(account);
	TransactionLog log=new TransactionLog(accountNumber, null, "deposit", amount, authname, "done");
	txLogRepository.save(log);
	
	}

	@Override
	public void withdraw(Long accountNumber, double amount,String authname) {
	
		Account account=accountRepository.findByAccountNumber(accountNumber);
		
		account.setBalance(account.getBalance()-amount);
		TranscationData transcationData=new TranscationData("withdraw", amount);
		account.addTranscation(transcationData);
		accountRepository.save(account);
		TransactionLog log=new TransactionLog(accountNumber, null, "withdraw", amount, authname, "done");
		txLogRepository.save(log);
		
		}
		
	

	@Override
	public void transfer(Long fromAccNumber, Long toAccNumber, double amount,String authname) {
   /*withdraw(fromAccNumber, amount);
    deposit(toAccNumber, amount);*/
		
	
		Account account1=accountRepository.findByAccountNumber(fromAccNumber);
	Account account2=accountRepository.findByAccountNumber(toAccNumber);
	   account1.setBalance(account1.getBalance()-amount);
		account2.setBalance(account2.getBalance()+amount);
		
		accountRepository.save(account1);
		accountRepository.save(account2);

		TranscationData transcationData=new TranscationData("transcations", amount);
		account1.addTranscation(transcationData);
		account2.addTranscation(transcationData);
		
		TransactionLog log=new TransactionLog(fromAccNumber, toAccNumber, "transfer", amount,authname, "done");
        txLogRepository.save(log);
		
		
}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}


	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}



}
