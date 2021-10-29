package com.registration.BankAccount.Service;

import java.util.List;

import javax.validation.Valid;

import com.registration.BankAccount.Entity.User;
import com.registration.BankAccount.dto.UserDetailsDto;
import com.registration.BankAccount.dto.UserRequestDto;
import com.registration.BankAccount.dto.UserResponseDto;

public interface UserService {
	
	public UserResponseDto addUser(@Valid UserRequestDto userRequestDto);

	public User addUser(User user);


	 public List<UserDetailsDto> getAllUser();

	//public List<UserDetailsDto> getAllUsers();

	

	

	//public UserResponseDto addUser(@Valid UserRequestDto userRequestDto);

}
