package com.sameer.webflux.model;

public class Account {

	private int AccountId;
	
	private String AccountName;
	
	private String AccountOpenDate;

	public int getAccountId() {
		return AccountId;
	}

	public void setAccountId(int accountId) {
		AccountId = accountId;
	}

	public String getAccountName() {
		return AccountName;
	}

	public void setAccountName(String accountName) {
		AccountName = accountName;
	}

	public String getAccountOpenDate() {
		return AccountOpenDate;
	}

	public void setAccountOpenDate(String accountOpenDate) {
		AccountOpenDate = accountOpenDate;
	}
}
