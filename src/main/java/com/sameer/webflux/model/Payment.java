package com.sameer.webflux.model;

public class Payment {

	String paymentId;
	
	String Currency;
	
	double PaymentAmt;


	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public double getPaymentAmt() {
		return PaymentAmt;
	}

	public void setPaymentAmt(double paymentAmt) {
		PaymentAmt = paymentAmt;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}
}
