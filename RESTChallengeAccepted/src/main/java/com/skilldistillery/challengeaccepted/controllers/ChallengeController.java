package com.skilldistillery.challengeaccepted.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.challengeaccepted.entities.Challenge;
import com.skilldistillery.challengeaccepted.services.ChallengeService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class ChallengeController {
	@Autowired
	private ChallengeService chaServ;

	// view challenge by challenge id
	@RequestMapping(path="challenges/{id}", method=RequestMethod.GET)
	public Challenge showChallenge(@PathVariable int id, String username) {
		return chaServ.show(id);
	}
	
	// view all challenges
	@RequestMapping(path="challenges", method=RequestMethod.GET)
	public List<Challenge> allChallenges() {
		return chaServ.index();
	}
	
	// view list of challenges for one status by passing the status id
		@RequestMapping(path="challenges/status/{sid}", method=RequestMethod.GET)
		public Set<Challenge> indexChallengesByStatus(@PathVariable int sid) {
			return chaServ.indexStatusChallenges(sid);
		}
		
	// view list of challenges for one user by status
		@RequestMapping(path="challenges/user/{uid}/status/{sid}", method=RequestMethod.GET)
		public Set<Challenge> indexChallengeByUserAndStatus(@PathVariable int uid, @PathVariable int sid) {
			return chaServ.indexStatusChallengesByUser(sid, uid);
		}
	
	// create new challenge
	@RequestMapping(path="challenges", method=RequestMethod.POST) 
	public Challenge newChallenge(@RequestBody Challenge challenge) {
		return chaServ.create(challenge);
	}
	
	// update existing challenge by challenge id
	@RequestMapping(path="challenges/{id}", method=RequestMethod.PATCH)
	public Challenge updateChallenge(@PathVariable int id, @RequestBody Challenge challenge) {
		return chaServ.update(challenge);
	}
	
	// delete challenge by challenge id
	@RequestMapping(path="challenges/{id}", method=RequestMethod.DELETE)
	public Boolean deleteChallenge(@PathVariable int id) {
		return chaServ.delete(id);
	}
	
	
}
