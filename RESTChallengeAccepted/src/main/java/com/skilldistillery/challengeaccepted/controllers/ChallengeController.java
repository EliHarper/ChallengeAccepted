package com.skilldistillery.challengeaccepted.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.challengeaccepted.repositories.ChallengeRepository;
import com.skilldistillery.challengeaccepted.repositories.TagRepository;
import com.skilldistillery.challengeaccepted.repositories.UserRepository;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class ChallengeController {
	@Autowired
	private ChallengeRepository chaRepo;

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TagRepository tagRepo;
}
