package com.assignment.Exception;

import java.time.LocalDateTime;


public class Error {
	
	private LocalDateTime timestamp;
	
	private String message;
	
	private String detils;
	
	public Error() {
		
	}

	public Error(LocalDateTime timestamp, String message, String detils) {
		this.timestamp = timestamp;
		this.message = message;
		this.detils = detils;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetils() {
		return detils;
	}

	public void setDetils(String detils) {
		this.detils = detils;
	}
	
	
	
	
}
