package com.registration.BankAccount.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.registration.BankAccount.Entity.User;
import com.registration.BankAccount.Service.UserService;
import com.registration.BankAccount.dto.UserDetailsDto;
import com.registration.BankAccount.dto.UserRequestDto;
import com.registration.BankAccount.dto.UserResponseDto;

@RestController
@RequestMapping("/users")

public class UserController {
	
	@Autowired 
	UserService userService;
	
@PostMapping("/createUsers")
	
	public User addUser(@RequestBody User user) {
		
		return userService.addUser(user);
		
}
	
	@PostMapping()
	public UserResponseDto addUser(@Valid @RequestBody  UserRequestDto userRequestDto) {
		return userService.addUser(userRequestDto);
		
	}
	
	@GetMapping
	public List<UserDetailsDto> getAllCustomer(@RequestParam LocalDate dob){
		return userService.getAllUser();
	}
	
	/*public User addUser(@RequestBody User user) {
        return userService .addUser(user);
}

	
	@GetMapping
	public List <User> getAllUsers (){
		return userService.getAllUsers();
	}*/
}

	
