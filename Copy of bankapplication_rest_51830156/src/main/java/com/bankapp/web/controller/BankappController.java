package com.bankapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.Service.AccountService;

@RestController
@RequestMapping(path = "/api")
public class BankappController {
	@Autowired
	private AccountService accountservice;

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
}
