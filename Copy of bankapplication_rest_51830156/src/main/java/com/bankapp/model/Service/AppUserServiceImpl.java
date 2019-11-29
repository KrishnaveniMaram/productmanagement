package com.bankapp.model.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.Repository.AppUserRepository;
import com.bankapp.model.entities.AppUser;
@Service
@Transactional

public class AppUserServiceImpl implements AppUserservice {

	@Autowired
	private AppUserRepository appUserRep;
	@Override
	public AppUser findByEmail(String email) {
		// TODO Auto-generated method stub
		return appUserRep.findByEmail(email);
	}

	@Override
	public void addUser(AppUser appUser) {
		// TODO Auto-generated method stub
		appUserRep.save(appUser);
		
	}

	@Override
	public List<AppUser> getAllusers() {
		// TODO Auto-generated method stub
		return appUserRep.findAll();
	}
}