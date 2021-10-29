package com.registration.BankAccount.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.registration.BankAccount.Entity.FundTransfer;


public interface BankStatementService {
	
@Autowired
	public List<FundTransfer> getBankStatementFromId(Long accountID);

}
