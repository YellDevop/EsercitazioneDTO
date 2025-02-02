package com.example.implementation;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dto.UtenteDto;
import com.example.mapper.UtenteMapper;
import com.example.model.Utente;
import com.example.repository.UtenteRepo;
import com.example.service.UtenteService;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UtenteImpl implements UserDetailsService, UtenteService{
	
	private final UtenteRepo repository;
	
	private final UtenteMapper mapper;

	@Override
	public UtenteDto save(UtenteDto u) {
		//Converto il Dto "u" in Model sfruttando il toModel del mapper.
		Utente utente = mapper.toModel(u);
		//salvo l'entità nel database
		utente = repository.save(utente);
		//Converto il Model salvato in un Dto e lo restituisce.
		return mapper.toDto(utente);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		return repository.findByUsername(username).orElseThrow(
				() -> new UserNameNotFoundException("Utene non trovato con username: " + username)
				);
	}

	@Override
	public UtenteDto findByUsername(String username) throws UsernameNotFoundException {
		return repository.findByUsername(username);
	}

	
	
	

}
