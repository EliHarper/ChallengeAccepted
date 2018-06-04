package com.skilldistillery.challengeaccepted.controllers;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.challengeaccepted.entities.UserSkill;
import com.skilldistillery.challengeaccepted.repositories.UserSkillRepository;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class UserSkillController {
	
	@Autowired
	private UserSkillRepository userSkillRepo;
	
	// returns list of all user_skill records based on user id
	@RequestMapping(path="users/{uid}/skills", method=RequestMethod.GET)
	public Set<UserSkill> getUserSkillsByUserId(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid) {
		if (userSkillRepo.findByUserId(uid) != null) {
			res.setStatus(200);
			return userSkillRepo.findByUserId(uid);
		}
		res.setStatus(404);
		return null;
	}
}
