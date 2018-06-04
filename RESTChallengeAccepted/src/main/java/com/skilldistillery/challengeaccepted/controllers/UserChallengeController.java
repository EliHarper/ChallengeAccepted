package com.skilldistillery.challengeaccepted.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.challengeaccepted.entities.Challenge;
import com.skilldistillery.challengeaccepted.entities.User;
import com.skilldistillery.challengeaccepted.entities.UserChallenge;
import com.skilldistillery.challengeaccepted.services.UserChallengeService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class UserChallengeController {

	@Autowired
	private UserChallengeService userChallengeService;
	
	// creates a new user_challenge record when users accept a challenge
	@RequestMapping(path="/challenges/{id}/accept", method=RequestMethod.POST)
	public UserChallenge createUserChallenge(@RequestBody UserChallenge userChallenge, String username) {
		System.out.println("******************" + userChallenge + "****************************");
		return userChallengeService.create(userChallenge, username);
	}
	
	// users can view challenges they have accepted
	@RequestMapping(path="/user/challenges/accept/{id}", method=RequestMethod.GET)
	public UserChallenge viewUserChallenge(@PathVariable int id, String username) {
		return userChallengeService.show(id, username);
	}
	
	// update an accepted challenge
	@RequestMapping(path="/challenges/accept/{id}", method=RequestMethod.PATCH)
	public UserChallenge updateUserChallenge(@RequestBody UserChallenge userChallenge, String username) {
		return userChallengeService.create(userChallenge, username);
	}
	
	// delete a user challenge record
	@RequestMapping(path="/challenges/{cid}/accept/{id}", method=RequestMethod.DELETE)
	public Boolean deleteUserChallenge(@PathVariable int id, String username) {
		return userChallengeService.delete(id, username);
	}
	
	// returns all user_challenge records for one challenge
	@RequestMapping(path="/challenges/{cid}/accept/all", method=RequestMethod.GET)
	public List<UserChallenge> allAcceptsForChallenge(@RequestBody Challenge challenge, String username){
		return userChallengeService.getTheChallengeAcceptorsForAChallenge(challenge, username);
	}
	
	// returns all challenges a user has accepted, active and inactive
	@RequestMapping(path="/user/challenges/{cid}/accept/all", method=RequestMethod.GET)
	public List<UserChallenge> allAcceptsForUser(@RequestBody User user, String username){
		return userChallengeService.challengesUserHasParticipatedIn(user, username);
	}
}