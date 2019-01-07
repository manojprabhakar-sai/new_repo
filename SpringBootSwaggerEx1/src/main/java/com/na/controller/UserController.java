package com.na.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.na.entity.User;
import com.na.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	private  UserRepository  repo;
	
	@GetMapping(value="/users",produces="application/json")
	public  ResponseEntity<List<User>>  getAllUsers()
	{
		List<User>  usersList = repo.findAll();
		return  new  ResponseEntity<List<User>>(usersList, HttpStatus.OK);
	}
	
	@GetMapping(value="/users/{userid}", produces="application/json") 
	public  User  getUserById(@PathVariable("userid") Integer userId) {
		Optional<User>  opt = repo.findById(userId);
		User  user=opt.get();
		return user;
	}
	
	@PostMapping(value="/users/create",consumes="application/json",produces="text/html")
	public  String  createNewUser(@RequestBody User  user) {
		repo.saveAndFlush(user);
		return  "<h2> New User is added to Database </h2>"; 
	}
	
	@PutMapping(value="/users/update",consumes="application/json",produces="text/html")
	public  String  updateUser(@RequestBody User  user) {
		repo.saveAndFlush(user);
		return  "<h2> User is updated to Database </h2>"; 
	}
	
	@DeleteMapping(value="/users/delete/{userid}")
	public  String  deleteUser(@PathVariable("userid") Integer  userId) {
		repo.deleteById(userId);
		return  "<h2> User is deleted from Database</h2>";
	}
}
