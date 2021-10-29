package com.registration.BankAccount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registration.BankAccount.Entity.FundTransfer;
import com.registration.BankAccount.Service.FundTransferService;

@RestController
@RequestMapping("/fundTransfer")
public class FundTransferController {
	

	@Autowired
	FundTransferService fundTransferService ;
	
	@PostMapping
	public FundTransfer transferFund(@RequestBody FundTransfer fundTransfer) {
		return fundTransferService.transferFund(fundTransfer);
	}
	
	@GetMapping("/getAccountIDfromPhone/{phoneNumber}")
	public Long getAccountIdFromPhoneNumber(@PathVariable String phoneNumber) {
		return fundTransferService.getAccountIdFromPhoneNumber(phoneNumber);
	}

}
