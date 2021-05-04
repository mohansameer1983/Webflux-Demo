package com.sameer.webflux.exception;

import org.springframework.http.HttpStatus;

public class WebfluxException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public HttpStatus status;
	
	public String faultReason;

	public WebfluxException(HttpStatus status, String message){
        super(message);
        this.status = status;
    }
	
	public WebfluxException(String message, String faultReason) {
		super(message);
		this.faultReason = faultReason;
	}

    public String getFaultReason() {
		return faultReason;
	}

	public void setFaultReason(String faultReason) {
		this.faultReason = faultReason;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
