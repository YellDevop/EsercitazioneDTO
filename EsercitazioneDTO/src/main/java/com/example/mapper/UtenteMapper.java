package com.example.mapper;

import org.springframework.stereotype.Component;

import com.example.dto.UtenteDto;
import com.example.model.Utente;

@Component
public class UtenteMapper {

	public UtenteDto toDto(Utente u) {
		UtenteDto utenteDto = new UtenteDto();
		utenteDto.setUsername(u.getUsername());
		utenteDto.setEmail(u.getEmail());
		return utenteDto;
	}
	
	public Utente toModel(UtenteDto u) {
		Utente utente = new Utente();
		utente.setEmail(u.getEmail());
		utente.setUsername(u.getUsername());
		return utente;
	}
}
