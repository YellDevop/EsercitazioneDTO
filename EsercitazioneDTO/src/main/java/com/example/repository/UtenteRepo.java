package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dto.UtenteDto;
import com.example.model.Utente;

public interface UtenteRepo extends JpaRepository<Utente, Integer>{

	UtenteDto save(UtenteDto u);
	
	UtenteDto findByUsername(String username);
}
