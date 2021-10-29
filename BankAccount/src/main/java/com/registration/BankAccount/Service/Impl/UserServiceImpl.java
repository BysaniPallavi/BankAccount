package com.registration.BankAccount.Service.Impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.registration.BankAccount.Entity.User;
import com.registration.BankAccount.Service.UserService;
import com.registration.BankAccount.dto.UserDetailsDto;
import com.registration.BankAccount.dto.UserRequestDto;
import com.registration.BankAccount.dto.UserResponseDto;
import com.registration.BankAccount.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
public User addUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public List<UserDetailsDto> getAllUser() {
		
		return null;//customerRepository.findAll();
	}

	@Override
	public UserResponseDto addUser(@Valid UserRequestDto userRequestDto)throws NullPointerException {
		
		User user = new User();
		BeanUtils.copyProperties(userRequestDto, user);
		user.setCreationdate(LocalDateTime.now());
		User dbUser = userRepository.save(user);
		UserResponseDto userResponseDto = new UserResponseDto();
		BeanUtils.copyProperties(dbUser,userResponseDto);
		return userResponseDto ;
	}

	

	

	

}
