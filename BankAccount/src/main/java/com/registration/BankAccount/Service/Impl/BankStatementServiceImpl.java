package com.registration.BankAccount.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.BankAccount.Entity.FundTransfer;
import com.registration.BankAccount.Service.BankStatementService;
import com.registration.BankAccount.repository.FundTransferRepository;

@Service
public class BankStatementServiceImpl implements BankStatementService{
	
	@Autowired
	FundTransferRepository fundTransferRepository;

	@Override
	public List<FundTransfer> getBankStatementFromId(Long accountID) {
		
		return fundTransferRepository.findByFromAccountID(accountID); 
	}


}
