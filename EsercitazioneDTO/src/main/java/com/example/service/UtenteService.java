package com.example.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.dto.UtenteDto;

public interface UtenteService {

	UtenteDto save(UtenteDto u);
	
	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	
	UtenteDto findByUsername(String username) throws UsernameNotFoundException; 
}
