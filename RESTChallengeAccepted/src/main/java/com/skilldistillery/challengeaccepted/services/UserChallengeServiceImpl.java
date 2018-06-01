package com.skilldistillery.challengeaccepted.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.challengeaccepted.entities.Challenge;
import com.skilldistillery.challengeaccepted.entities.User;
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
		 userChallengeRepo.saveAndFlush(uc);
		 return uc;
	 }
	 
	 public UserChallenge update(UserChallenge uc, String username) {
		 userChallengeRepo.saveAndFlush(uc);
		 return uc;
	 }
	 
	 public Boolean delete(int id, String username) {
		 try {
			userChallengeRepo.deleteById(id);
			 return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	 }
	 
	 public List<UserChallenge> index() {
		 return userChallengeRepo.findAll();
	 }
	 
	 public UserChallenge show(int id, String username) {
		 try {
			UserChallenge userChallenge = userChallengeRepo.findById(id).get();
			return userChallenge;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	 }
	 
	 public List<UserChallenge> userChallengesOfAChallenge(Challenge challenge, String username) {
		 return userChallengeRepo.findByChallengeId(challenge.getId());
	 }
	 
	 public List<UserChallenge> userChallengesOfAUser(User user, String username) {
		 return userChallengeRepo.findByUserId(user.getId());
	 }
	 
}
