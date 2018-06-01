package com.skilldistillery.challengeaccepted.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.challengeaccepted.entities.UserChallenge;
import com.skilldistillery.challengeaccepted.repositories.ChallengeRepository;
import com.skilldistillery.challengeaccepted.repositories.UserChallengeRepository;
import com.skilldistillery.challengeaccepted.repositories.UserRepository;

public class UserChallengeServiceImpl implements UserChallengeService{

	 @Autowired
	 private UserChallengeRepository userChallengeRepo;
	 @Autowired
	 private UserRepository userRepo;
	 @Autowired
	 private ChallengeRepository challengeRepository;
	 
	 public UserChallenge create(UserChallenge uc, String username) {
		 return null;
	 }
	 
	 public UserChallenge update(UserChallenge uc, String username) {
		 return null;
	 }
	 
	 public Boolean delete(int id, String username) {
		 return null;
	 }
	 
	 public List<UserChallenge> index() {
		 return null;
	 }
	 
	 public UserChallenge show(int id, String username) {
		 return null;
	 }
	 
}
