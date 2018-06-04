package com.skilldistillery.challengeaccepted.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.challengeaccepted.entities.UserChallenge;
import com.skilldistillery.challengeaccepted.entities.UserChallengeDTO;
import com.skilldistillery.challengeaccepted.services.UserChallengeService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class UserChallengeController {

	@Autowired
	private UserChallengeService userChallengeService;
	

	// users can view challenges they have accepted
	@RequestMapping(path="/user/challenges/accept/{id}", method=RequestMethod.GET)
	public UserChallenge viewUserChallenge(@PathVariable int id, String username) {
		return userChallengeService.show(id, username);
	}
	
	// returns all user_challenge records for one challenge
	@RequestMapping(path="/challenges/{cid}/accept/all", method=RequestMethod.GET)
	public List<UserChallenge> allAcceptsForChallenge(@PathVariable int cid, String username){
		return userChallengeService.getTheChallengeAcceptorsForAChallenge(cid, username);
	}
	
	// returns all challenges a user has accepted, active and inactive
	@RequestMapping(path="/user/{uid}/challenges/accept/all", method=RequestMethod.GET)
	public List<UserChallenge> allAcceptsForUser(@PathVariable int uid, String username){
		return userChallengeService.challengesUserHasParticipatedIn(uid, username);
	}
	

	// creates a new user_challenge record when users accept a challenge by passing a challenge id

	@RequestMapping(path="/challenges/{id}/accept", method=RequestMethod.POST)
	public UserChallenge createUserChallenge(@RequestBody UserChallengeDTO ucDTO, String username) {
		return userChallengeService.create(ucDTO, username);
	}
	
	// update an accepted user_challenge record w/ user_challenge id

	@RequestMapping(path="/challenges/accept/{id}", method=RequestMethod.PATCH)
	public UserChallenge updateUserChallenge(@RequestBody UserChallenge userChallenge, String username) {
		return userChallengeService.update(userChallenge, username);
	}
	
	// delete a user challenge record w/ the challenge id and user id
	@RequestMapping(path="/challenges/{cid}/accept/{id}", method=RequestMethod.DELETE)
	public Boolean deleteUserChallenge(@PathVariable int id, String username) {
		return userChallengeService.delete(id, username);
	}
		
}