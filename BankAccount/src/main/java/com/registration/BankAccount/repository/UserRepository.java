package com.registration.BankAccount.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.registration.BankAccount.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

	public User findByAccountIDEquals(Long accountId);

	
	
	//@Transactional
	//@Modifying(clearAutomatically = true)
	//@Query("UPDATE User c  SET c.initialAmount = :initialAmount WHERE c.accountID = : accountID")
	// public User updateUser(@Param("initialAmount") int initialAmount, @Param("accountID") long accountID);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE User c SET c.initialAmount = :initialAmount WHERE c.accountID = :accountID")
	public void updateUser(@Param("accountID") long accountID,@Param("initialAmount")int initialAmount);
	
	@Query("SELECT u.accountID from User u where u.phone=:phoneNumber")
	public Long getAccountIdFromPhoneNumber(@Param("phoneNumber") String phoneNumber);
	

}
