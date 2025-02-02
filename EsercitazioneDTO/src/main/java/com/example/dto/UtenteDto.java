package com.example.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UtenteDto {

	@NotBlank(message = "Il nome deve essere inserito.")
	private String username;
	@Email(message = "Non hai inserito il pattern corretto per una email.")
	private String email;
}
