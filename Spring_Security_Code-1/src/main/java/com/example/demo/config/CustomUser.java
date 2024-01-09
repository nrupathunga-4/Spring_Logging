package com.example.demo.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.Employee;

public class CustomUser implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Employee employee;
	
	public CustomUser(Employee employee) {
		super();
		this.employee = employee;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority=new SimpleGrantedAuthority(employee.getRole());
		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
	
		return employee.getPassword();
	}

	@Override
	public String getUsername() {
		
		return employee.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
