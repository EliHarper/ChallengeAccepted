package com.skilldistillery.challengeaccepted.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.challengeaccepted.repositories.ChallengeRepository;
import com.skilldistillery.challengeaccepted.repositories.TagRepository;
import com.skilldistillery.challengeaccepted.repositories.UserRepository;

@Service
public class TagServiceImpl implements TagService {
	
	@Autowired
	private TagRepository tagRepo; 
	
	@Autowired 
	private ChallengeRepository chaRepo;
	
	@Autowired
	private UserRepository userRepo;


}
