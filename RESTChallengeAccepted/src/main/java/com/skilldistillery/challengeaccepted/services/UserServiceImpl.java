package com.skilldistillery.challengeaccepted.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.challengeaccepted.repositories.ChallengeRepository;
import com.skilldistillery.challengeaccepted.repositories.MessageRepository;
import com.skilldistillery.challengeaccepted.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private MessageRepository mesRepo;
	
	@Autowired 
	private ChallengeRepository chaRepo;

}
