package com.skilldistillery.challengeaccepted.controllers;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.challengeaccepted.entities.UserSkill;
import com.skilldistillery.challengeaccepted.services.UserSkillService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class UserSkillController {
	
	@Autowired
	private UserSkillService userSkillSvc;
	
	// returns list of all user_skill records based on user id
	@RequestMapping(path="userskillz/{uid}", method=RequestMethod.GET)
	public Set<UserSkill> getUserSkillsByUserId(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid) {
		if (userSkillSvc.getUserSkillsByUserId(uid) != null) {
			res.setStatus(200);
			return userSkillSvc.getUserSkillsByUserId(uid);
		}
		res.setStatus(404);
		return null;
	}
	
	// create a new UserSkill record
	@RequestMapping(path="userskillz", method=RequestMethod.POST)
	public UserSkill create(HttpServletRequest req, HttpServletResponse res, @RequestBody UserSkill us) {
		return userSkillSvc.create(us); 
	}
	
	// update points on an existing UserSkill record
	@RequestMapping(path="userskillz/{id}/{newPoints}", method=RequestMethod.PATCH)
	public UserSkill update(HttpServletRequest req, HttpServletResponse res, @RequestBody UserSkill us, @PathVariable int newPoints) {
		return userSkillSvc.update(us, newPoints); 
	}
}
