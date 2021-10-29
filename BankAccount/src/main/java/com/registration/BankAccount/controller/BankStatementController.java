package com.registration.BankAccount.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registration.BankAccount.Entity.FundTransfer;
import com.registration.BankAccount.Service.BankStatementService;



@RestController
@RequestMapping("/bankStatement")
public class BankStatementController {
	

	@Autowired
	BankStatementService bankStatementService;
	
	@GetMapping("/{accountID}")
	public List<FundTransfer> getBankStatementFromId(@PathVariable Long accountID){
		return bankStatementService.getBankStatementFromId(accountID);
	}
	
	

}
