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
	public User viewUserProfile(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid) {
		User user = userServ.show(uid);
		if ( user != null) {
			res.setStatus(200);
			return user;
		}
		res.setStatus(404);
		return null;
	}
	
	// create new user
	@RequestMapping(path="users", method=RequestMethod.POST)
	public User createUser(HttpServletRequest req, HttpServletResponse res, @RequestBody User user) {
		User newUser = userServ.create(user);
		if (newUser != null) {
			res.setStatus(201);
			return newUser;
		}
		res.setStatus(404);
		return null;
	}
	
	// update existing user w/ user id
	@RequestMapping(path="users/{uid}", method=RequestMethod.PATCH)
	public User updateUser(@RequestBody User user) {
		return userServ.update(user);
	}
	
	// delete user by user id
	@RequestMapping(path="/users/{id}", method=RequestMethod.DELETE)
	public Boolean deleteUser(@PathVariable int id) {
		return userServ.delete(id);
	}
	
}
