package com.bankapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.Repository.AccountRepository;
import com.bankapp.model.Repository.TranscationDataRepository;
import com.bankapp.model.Repository.TranscationLogRepository;
import com.bankapp.model.Service.AccountService;
import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.entities.TranscationData;

@RestController
@RequestMapping("/api/transactions")
public class TranscatoinMagtController {
	@Autowired
	private TranscationDataRepository transactionDataRepo;
	@Autowired
	private TranscationLogRepository transactionLogRepo;
	@Autowired
	private AccountService accountService;
	@Autowired
	private AccountRepository accountRepository;

	@GetMapping(path = "/transaction", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TranscationData>> getAllTransactions() {

		return new ResponseEntity<List<TranscationData>>(transactionDataRepo.findAll(), HttpStatus.OK);

	}

	@GetMapping(path = "/transaction/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TranscationData>> getTransactionById(@PathVariable(name = "id") Long accountNumber) {
		Account account = accountRepository.findByAccountNumber(accountNumber);
		List<TranscationData> transcationData = account.getTx();
		return new ResponseEntity<List<TranscationData>>(transcationData, HttpStatus.OK);
	}

	@GetMapping(path = "/transactionslog", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TransactionLog>> getAllTransactionsLogs() {

		return new ResponseEntity<List<TransactionLog>>(transactionLogRepo.findAll(), HttpStatus.OK);

	}

}
