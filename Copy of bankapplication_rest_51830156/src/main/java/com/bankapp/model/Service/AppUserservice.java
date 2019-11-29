package com.bankapp.model.Service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.model.entities.AppUser;

public interface AppUserservice{
	public AppUser findByEmail(String email);
	public void addUser(AppUser appUser);
	public List<AppUser> getAllusers();
}
