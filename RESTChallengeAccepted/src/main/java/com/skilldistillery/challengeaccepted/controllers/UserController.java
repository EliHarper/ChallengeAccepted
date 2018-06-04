package com.skilldistillery.challengeaccepted.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.challengeaccepted.entities.User;
import com.skilldistillery.challengeaccepted.services.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	
	
	// finds user by user id
	@RequestMapping(path="users/{uid}", method=RequestMethod.GET)
	public User viewUserProfile(@PathVariable int uid) {
		return userServ.show(uid);
	}
	
	// create new user
	@RequestMapping(path="users", method=RequestMethod.POST)
	public User createUser(HttpServletRequest req, HttpServletResponse res, @RequestBody User user) {
		return userServ.create(user);
	}
	
	// update existing user w/ user id
	@RequestMapping(path="users/{uid}", method=RequestMethod.PATCH)
	public User updateUser(@RequestBody User user) {
		return userServ.update(user);
	}
	
	// delete user by user id
	@RequestMapping(path="/users/{id}", method=RequestMethod.DELETE)
	public Boolean deleteUser(@PathVariable int id, String username) {
		return userServ.delete(id);
	}
	
}
