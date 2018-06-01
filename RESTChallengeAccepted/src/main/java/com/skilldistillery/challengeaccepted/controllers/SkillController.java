package com.skilldistillery.challengeaccepted.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.challengeaccepted.services.ChallengeService;
import com.skilldistillery.challengeaccepted.services.SkillService;
import com.skilldistillery.challengeaccepted.services.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class SkillController {
	
	@Autowired
	private SkillService skillzServ;
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private ChallengeService chaServ;

}
