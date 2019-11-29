package com.bankapp.model.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bankapp.model.entities.AppUser;
import com.bankapp.model.exceptions.UserNotFoundException;
@Service
public class DetailService implements UserDetailsService {
	@Autowired
	private AppUserservice appUserService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		AppUser appUser=appUserService.findByEmail(email);
		if(appUser==null)
		{
			throw new UserNotFoundException("user not found");
		}
			else
				
		return new User(appUser.getEmail(),appUser.getPasword(),
				AuthorityUtils.createAuthorityList(appUser.getRoles()));
	}

}
