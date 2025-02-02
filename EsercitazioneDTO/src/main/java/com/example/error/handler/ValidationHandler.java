package com.example.error.handler;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.dto.ValidationErrorMessageDto;

@RestControllerAdvice
public class ValidationHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationErrorMessageDto> handleValidation(MethodArgumentNotValidException ex,
			WebRequest request) {
		ValidationErrorMessageDto errormsg = new ValidationErrorMessageDto();
		errormsg.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errormsg.setStatusString(HttpStatus.BAD_REQUEST.name());
		errormsg.setTargetUrl(request.getDescription(false));
		errormsg.setFieldErrors(ex.getFieldErrors().stream()
				.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage))

		);
		return ResponseEntity.badRequest().body(errormsg);
	}
}
