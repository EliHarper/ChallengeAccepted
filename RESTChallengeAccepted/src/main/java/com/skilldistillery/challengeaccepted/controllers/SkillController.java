package com.skilldistillery.challengeaccepted.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.challengeaccepted.entities.Skill;
import com.skilldistillery.challengeaccepted.services.SkillService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class SkillController {
	
	@Autowired
	private SkillService skillzServ;
	
	@RequestMapping(path="skills", method = RequestMethod.GET)
	public List<Skill> allSkills(){
		return skillzServ.index();
	}
	

	
	
}
