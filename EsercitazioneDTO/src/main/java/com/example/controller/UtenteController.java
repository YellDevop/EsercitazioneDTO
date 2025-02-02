package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UtenteDto;
import com.example.service.UtenteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
public class UtenteController {

	private final UtenteService service;
	
	@PostMapping("all/utente/inserimento")
	public ResponseEntity<UtenteDto> inserimento(@Valid @RequestBody UtenteDto u){
		UtenteDto utente = service.save(u);
		return ResponseEntity.ok(utente);
	}
	
}
