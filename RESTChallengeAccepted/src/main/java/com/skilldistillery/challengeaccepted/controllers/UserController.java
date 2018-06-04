package com.skilldistillery.challengeaccepted.controllers;

import java.util.List;

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
import com.skilldistillery.challengeaccepted.services.ChallengeService;
import com.skilldistillery.challengeaccepted.services.SkillService;
import com.skilldistillery.challengeaccepted.services.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private ChallengeService chaServ;
	
	@Autowired
	private SkillService skillzServ;
	
	@RequestMapping(path="/user", method=RequestMethod.POST)
	public User createUser(HttpServletRequest req, HttpServletResponse res, @RequestBody User user) {
		return userServ.create(user);
	}

	@RequestMapping(path="/users", method=RequestMethod.GET)
	public List<User> allUsers() {
		return userServ.index();
	}
	
	@RequestMapping(path="/user/{id}", method=RequestMethod.GET)
	public User viewUserProfile(@PathVariable int id, String username) {
		return userServ.show(id);
	}
	
	@RequestMapping(path="/user/edit", method=RequestMethod.PATCH)
	public User updateUser(@RequestBody User user) {
		return userServ.update(user);
	}

	@RequestMapping(path="/user/{id}/deactivate", method=RequestMethod.DELETE)
	public Boolean deleteUser(@PathVariable int id, String username) {
		return userServ.delete(id);
	}
	
}
