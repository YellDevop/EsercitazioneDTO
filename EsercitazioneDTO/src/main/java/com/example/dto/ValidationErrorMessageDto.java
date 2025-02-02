package com.example.dto;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.Data;

@Data
public class ValidationErrorMessageDto {

	private LocalDateTime timeStamp = LocalDateTime.now();
	private int statusCode;
	private String statusString;
	private String targetUrl;
	private Map<String, String> fieldErrors;
}
