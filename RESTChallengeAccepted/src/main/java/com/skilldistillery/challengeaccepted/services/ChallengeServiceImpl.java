package com.skilldistillery.challengeaccepted.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.challengeaccepted.entities.Challenge;
import com.skilldistillery.challengeaccepted.repositories.ChallengeRepository;

@Service
public class ChallengeServiceImpl implements ChallengeService {

	@Autowired
	private ChallengeRepository chaRepo;

	
	public Challenge create(Challenge c) {
		chaRepo.saveAndFlush(c);
		return c;
	}

	public Challenge update(Challenge c) {
		chaRepo.saveAndFlush(c);
		return c;
	}
	
	public List <Challenge> index() {
		return chaRepo.findAll();
	}
	
	public Challenge show(int id) {
		Challenge chall = chaRepo.findById(id).get();
		return chall;
	}
	
	public Boolean delete(int id) {
		try {
			chaRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// view all challenges by status id
	public Set<Challenge> indexStatusChallenges (int sid) {
		return chaRepo.findByStatus(sid);
	}
	
	//view all challenges for a user by status id
	public Set<Challenge> indexStatusChallengesByUser(int uid, int sid) {
		return chaRepo.getChallengesByUserIdAndStatus(uid, sid);
	}
}
