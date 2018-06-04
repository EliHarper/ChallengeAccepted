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
import com.skilldistillery.challengeaccepted.services.ChallengeService;
import com.skilldistillery.challengeaccepted.services.SkillService;
import com.skilldistillery.challengeaccepted.services.TagService;
import com.skilldistillery.challengeaccepted.services.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class ChallengeController {
	@Autowired
	private ChallengeService chaServ;

	@Autowired
	private UserService userServ;
	
	@Autowired
	private TagService tagServ;
	
	@Autowired
	private SkillService skillzServ;
	
	@RequestMapping(path="/challenge/{id}", method=RequestMethod.GET)
	public Challenge showChallenge(@PathVariable int id, String username) {
		return chaServ.show(id);
	}
	
	@RequestMapping(path="/challenge/all", method=RequestMethod.GET)
	public List<Challenge> allChallenges() {
		return chaServ.index();
	}
	
	@RequestMapping(path="/challenge/new", method=RequestMethod.POST) 
	public Challenge newMarketplaceChallenge(@RequestBody Challenge challenge) {
		return chaServ.create(challenge);
	}
	
	@RequestMapping(path="/challenge/update/{id}", method=RequestMethod.PATCH)
	public Challenge updateChallenge(@PathVariable int id, @RequestBody Challenge challenge) {
		return chaServ.update(challenge);
	}
	
	@RequestMapping(path="/challenge/delete/{id}", method=RequestMethod.DELETE)
	public Boolean deleteChallenge(@PathVariable int id) {
		return chaServ.delete(id);
	}

}
