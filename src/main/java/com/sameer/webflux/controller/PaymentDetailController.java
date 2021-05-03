package com.sameer.webflux.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentDetailController {

	
	@GetMapping(path = "paymentAccountDetails")
	public ResponseEntity<String> getPaymentAccountDetailsByPaymentId(String paymentId){
		String paymentDet="";
		
		return new ResponseEntity<>(paymentDet, HttpStatus.OK); 
	}
}
