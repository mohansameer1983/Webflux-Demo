package com.sameer.webflux.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.sameer.webflux.exception.WebfluxException;
import com.sameer.webflux.model.Account;
import com.sameer.webflux.model.Payment;

import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class PaymentDetailController {


	@GetMapping(path = "paymentAccountDetails")
	public Mono<Tuple2<Account, Payment>> getPaymentAccountDetailsByPaymentId(String paymentId, String accoundId){
		WebClient client = WebClient.builder()
				.baseUrl("http://localhost:8080")
				.build();

		// Call 1st Rest Service to get account details
		Mono<Account> accountDetails = client.get()
				.uri(uriBuilder -> uriBuilder
						.path("/accountById")
						.queryParam("accountId", accoundId)
						.build())
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError,
						clientResponse -> Mono.error(new WebfluxException("Error retrieving Account", "400 error")))
				.bodyToMono(Account.class);

		// Call 2nd Rest Service to get payment details
		Mono<Payment> payment = client.get()
				.uri(uriBuilder -> uriBuilder
						.path("/paymentDataById")
						.queryParam("paymentId", paymentId)
						.build())
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError,
						clientResponse -> Mono.error(new WebfluxException("Error retrieving Payment", "400 error")))
				.bodyToMono(Payment.class);

		// Combine the results in a single Mono, that completes when both calls have returned.
		// If an error occurs in one of the Monos, execution stops immediately.
		// If we want to delay errors and execute all Monos, then we can use zipDelayError instead
		return Mono.zip(accountDetails, payment);
	}
}
