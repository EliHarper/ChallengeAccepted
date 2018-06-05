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
	@RequestMapping(path="userskills/{uid}", method=RequestMethod.GET)
	public Set<UserSkill> getUserSkillsByUserId(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid) {
		Set<UserSkill> userSkills = userSkillSvc.getUserSkillsByUserId(uid);
		if (userSkills != null) {
			res.setStatus(200);
			return userSkills;
		}
		res.setStatus(404);
		return null;
	}
	
	// create a new UserSkill record
	@RequestMapping(path="userskills", method=RequestMethod.POST)
	public UserSkill create(HttpServletRequest req, HttpServletResponse res, @RequestBody UserSkill us) {
		UserSkill newUS = userSkillSvc.create(us); 
		if (newUS != null) {
			res.setStatus(201);
			return newUS;
		}
		res.setStatus(404);
		return null;
	}
	
	// update points on an existing UserSkill record (usid = userskill id)
	@RequestMapping(path="userskills/{usid}/{newPoints}", method=RequestMethod.PATCH)
	public UserSkill update(HttpServletRequest req, HttpServletResponse res, @RequestBody UserSkill us, @PathVariable int usid, @PathVariable int newPoints) {
		return userSkillSvc.update(us, newPoints); 
	}
	
	// delete a userskill record by userskill id
	@RequestMapping(path="userskills/{usid}", method=RequestMethod.DELETE)
	public Boolean destory(HttpServletRequest req, HttpServletResponse res, @PathVariable int usid) {
		return userSkillSvc.destroy(usid);
	}
}
