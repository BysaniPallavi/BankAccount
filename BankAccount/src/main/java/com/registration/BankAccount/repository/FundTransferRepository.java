package com.registration.BankAccount.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.registration.BankAccount.Entity.FundTransfer;

@Repository
public interface FundTransferRepository extends JpaRepository<FundTransfer, Long>{

	
	public List<FundTransfer> findByFromAccountIDEquals(Long accountID);

	//@Transactional
	//@Modifying(clearAutomatically = true)
	@Query("select c from FundTransfer c  WHERE c.fromAccountID = :accountID or c.toAccountID = :accountID ")
	public List<FundTransfer> findByFromAccountID(@Param("accountID") long accountID);
}