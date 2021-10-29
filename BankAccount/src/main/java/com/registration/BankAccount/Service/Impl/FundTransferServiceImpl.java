package com.registration.BankAccount.Service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.BankAccount.Entity.FundTransfer;
import com.registration.BankAccount.Entity.User;
import com.registration.BankAccount.Service.FundTransferService;
import com.registration.BankAccount.repository.FundTransferRepository;
import com.registration.BankAccount.repository.UserRepository;



@Service
public class FundTransferServiceImpl implements FundTransferService {
	@Autowired
	FundTransferRepository fundTransferRepository;
	
	@Autowired
	UserRepository userRepository;
	

	public FundTransfer transferFund(FundTransfer fundTransfer) {
		validateAndMakeTransaction(fundTransfer);
		return fundTransferRepository.save(fundTransfer);
	}

	private void validateAndMakeTransaction(FundTransfer fundTransfer) throws IllegalArgumentException {
		// first check if from and to accountids exists
		// Check if balance is available
		// change balance in both the account -> add/remove
		long fromAccountID = fundTransfer.getFromAccountID();
		long toAccountID = fundTransfer.getToAccountID();
		long amountToTransfer = fundTransfer.getAmountToTransfer();

		User fromUser = userRepository.findByAccountIDEquals(fromAccountID);
		User toUser = userRepository.findByAccountIDEquals(toAccountID);
		if (fromUser == null && toUser == null) {
			throw new IllegalArgumentException("Both Sender account and Receipient account doesn't exists,Please double check");
		} else if (fromUser == null) {
			throw new IllegalArgumentException("Sender account doesn't exists,Please double check fromAccountID");
		} else if (toUser == null) {
			throw new IllegalArgumentException("Recepient account doesn't exists, Please double check toAccountID");
		} else if (fromUser.getInitialAmount() < amountToTransfer) {
			throw new IllegalArgumentException("Funds are not sufficient to make this trnasaction,Please load funds");
		}else if (amountToTransfer == 0) {
			throw new IllegalArgumentException("Please add amount to transfer");
		}
		
	long finalAmountOfSender = fromUser.getInitialAmount() - amountToTransfer;
		userRepository.updateUser(fromAccountID,(int) finalAmountOfSender );
		System.out.println(fromUser.getInitialAmount());
		
		long finalAmountOfRecepient = toUser.getInitialAmount() + amountToTransfer;
		userRepository.updateUser(toAccountID,(int) finalAmountOfRecepient);
		
	//	int finalAmountOfSender = fromUser.getInitialAmount() - amountToTransfer;
	//	fromUser.setInitialAmount(finalAmountOfSender);
	//	userRepository.save(fromUser);
		
	//int finalAmountOfRecepient = toUser.getInitialAmount() + amountToTransfer;
	//toUser.setInitialAmount(finalAmountOfRecepient);
		//userRepository.save(toUser);
		
	}

	@Override
	public Long getAccountIdFromPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		return userRepository.getAccountIdFromPhoneNumber(phoneNumber);
	}
	
}