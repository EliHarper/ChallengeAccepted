package com.skilldistillery.challengeaccepted.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.challengeaccepted.entities.Challenge;
import com.skilldistillery.challengeaccepted.entities.User;
import com.skilldistillery.challengeaccepted.entities.UserChallenge;
import com.skilldistillery.challengeaccepted.entities.UserChallengeDTO;
import com.skilldistillery.challengeaccepted.repositories.ChallengeRepository;
import com.skilldistillery.challengeaccepted.repositories.UserChallengeRepository;
import com.skilldistillery.challengeaccepted.repositories.UserRepository;

@Service
public class UserChallengeServiceImpl implements UserChallengeService{

	 @Autowired
	 private UserChallengeRepository userChallengeRepo;
	 @Autowired
	 private UserRepository userRepo;
	 @Autowired
	 private ChallengeRepository challengeRepository;
	 
	 public UserChallenge create(UserChallengeDTO ucDTO, String username) {
		 UserChallenge uc = new UserChallenge();
		 User user = userRepo.findById(ucDTO.getAcceptorId()).get();
		 Challenge challenge = challengeRepository.findById(ucDTO.getChallengeId()).get();
		 uc.setAccepted(true);
		 uc.setAcceptorWon(false);
		 uc.setChallenge(challenge);
		 uc.setUser(user);
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
	 
	 public List<UserChallenge> getTheChallengeAcceptorsForAChallenge(int cid, String username) {
		 return userChallengeRepo.findByChallengeId(cid);
	 }
	 
	 public List<UserChallenge> challengesUserHasParticipatedIn(int uid, String username) {
		 return userChallengeRepo.findByUserId(uid);
	 }

	@Override
	public UserChallenge checkIfUserHasAcceptedChallenge(int uid, int cid) {
			UserChallenge uc = userChallengeRepo.findByUserIdAndChallengeId(uid, cid);
			System.out.println(uc);
			return uc;
	}
	 
}
