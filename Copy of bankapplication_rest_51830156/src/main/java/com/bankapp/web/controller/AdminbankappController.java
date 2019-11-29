/*package com.bankapp.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.Repository.AccountRepository;
import com.bankapp.model.Repository.CustomerRepository;
import com.bankapp.model.Service.AppUserservice;

@Controller
@RequestMapping(path="/admin")
public class AdminbankappController {
	@Autowired
	private AppUserservice appUserService;
	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private CustomerRepository customerRepo;
	
	@GetMapping("/hi")
	public String hello(){
		return "hello";
	}
    @GetMapping("/users")
	public ModelAndView getAllUsersAccounts(ModelAndView mv){
		
		mv.setViewName("all_users");
		mv.addObject("appuser",appUserService.getAllusers());
		return mv;
	}
    
    @GetMapping("/customers")
	public ModelAndView getAllAccounts(ModelAndView mv){
		
		mv.setViewName("all_customers");
		mv.addObject("allcustomers",customerRepo.findAll());
		return mv;
	}

}
*/