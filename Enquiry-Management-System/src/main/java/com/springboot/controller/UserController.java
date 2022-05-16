package com.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.User;
import com.springboot.exception.UserErrorResponse;
import com.springboot.exception.UserNotFoundException;
import com.springboot.service.UserService;

@Controller
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	//Handler Method to handle list of users and return mode and view
	
	@GetMapping("/users")
	public String listUsers(Model model)
	{
		model.addAttribute("users", userService.getAllUsers());
		return "users";
	}
	
	//
	
	public User getUser(@PathVariable int userId)
	{
		List<User> theUser = new ArrayList();
		if(userId < 0 || userId > theUser.size())
		{
			String errorMessage = "User Id Not Found:" +userId;
			throw new UserNotFoundException(errorMessage);
		}
		return theUser.get(userId);
	}
	// Exception Handler
	@ExceptionHandler
	 public ResponseEntity<UserErrorResponse> handleException(UserNotFoundException une)

	 {
		UserErrorResponse error = new UserErrorResponse();
		 error.setStatus(HttpStatus.NOT_FOUND.value());
		 error.setMessage(une.getMessage());
		 error.setTimeStamp(System.currentTimeMillis());
		
		 return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		 
	 }
	
	//Handler method to handle new User
	
	@GetMapping("/users/new")
	public String createUserForm(Model model)
	{
		//create  user object to hold user form data
		User user = new User();
		model.addAttribute("user", user);
		return "create-user";
	}
	
	@PostMapping("/users")
	public  String saveUser(@ModelAttribute("user") User user)
	{
		userService.saveUser(user);
		return "redirect:/users";
	}
	
	@GetMapping("/users/edit/{id}")
	public String editUserForm(@PathVariable Long id, Model model)
	{
		model.addAttribute("user", userService.getUserById(id));
		return "edit-user";
	}
	

	@PostMapping("/users/{id}")
	public String updateUser(@PathVariable Long id,
			@ModelAttribute("user") User user,
			Model model)
	{
		//get user from database by id
		User existingUser = userService.getUserById(id);
		existingUser.setId(id);
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		
		//save updated user object
		userService.updateUser(existingUser);
		return "redirect:/users";
		
		
	}
	
	//Handler Method to delete user
	@GetMapping("/users/{id}")
	public String deleteUser(@PathVariable Long id)
	{
		userService.deleteUserById(id);
		return "redirect:/users";
	}

}
