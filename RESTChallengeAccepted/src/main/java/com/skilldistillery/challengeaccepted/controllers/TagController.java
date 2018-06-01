package com.skilldistillery.challengeaccepted.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.challengeaccepted.repositories.ChallengeRepository;
import com.skilldistillery.challengeaccepted.repositories.TagRepository;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class TagController {
	
	@Autowired
	private TagRepository tagRepo; 
	
	@Autowired 
	private ChallengeRepository chaRepo;

}
