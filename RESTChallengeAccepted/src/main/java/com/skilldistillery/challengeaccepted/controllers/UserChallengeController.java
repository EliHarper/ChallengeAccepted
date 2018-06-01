package com.skilldistillery.challengeaccepted.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.challengeaccepted.entities.UserChallenge;
import com.skilldistillery.challengeaccepted.services.UserChallengeService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class UserChallengeController {

	@Autowired
	private UserChallengeService userChallengeService;
	
	@RequestMapping(path="/something", method=RequestMethod.POST)
	public UserChallenge createUserChallenge(UserChallenge userChallenge) {
		return userChallengeService.create(userChallenge, "something");
	}
}
