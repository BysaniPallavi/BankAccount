package com.registration.BankAccount.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.registration.BankAccount.Entity.FundTransfer;


public interface FundTransferService {
	
	@Autowired
	public FundTransfer transferFund(FundTransfer fundTransfer);
	
	public Long getAccountIdFromPhoneNumber(String phoneNumber);
}


