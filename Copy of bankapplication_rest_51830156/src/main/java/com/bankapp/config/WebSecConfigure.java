package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableWebSecurity
public class WebSecConfigure extends WebSecurityConfigurerAdapter {
@Autowired
	private UserDetailsService detailservices;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		auth.userDetailsService(detailservices);
		
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	/*httpcsrf().disable()
	.authorizeRequests().anyRequest().authenticated()
	.antMatchers("/admin/**").hasAnyRole("ADMIN")
	.antMatchers("/mgr/**").hasAnyRole("ADMIN","MGR")
	.antMatchers("/clr/**").hasAnyRole("CLERK","ADMIN","MGR").and()
	.httpBasic().and()
	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);	*/	
		
		http.csrf().disable()
		.authorizeRequests()
			.antMatchers("/api/accounts/**").hasAnyRole("ADMIN")
			.antMatchers("/api/transactions/**").hasAnyRole("CLERK","MGR")
			.antMatchers("/api/forms/**").hasAnyRole("ADMIN","MGR","CLERK")
			.and().sessionManagement()
			.and().formLogin().and()         // for jsp point
		.httpBasic();
		
	}
	
}




