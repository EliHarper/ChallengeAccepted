package com.skilldistillery.challengeaccepted.services;

import java.util.List;
import java.util.Set;

import com.skilldistillery.challengeaccepted.entities.Challenge;
import com.skilldistillery.challengeaccepted.entities.ChallengeDTO;

public interface ChallengeService {

	public Challenge create(ChallengeDTO cDTO); 
	
	public Challenge update(Challenge c, int cid);
	
	public List <Challenge> index();
	
	public Challenge show(int id);
	
	public Boolean delete(int id);
	
	public Set<Challenge> indexStatusChallenges( int sid);
	
	public Set<Challenge> indexStatusChallengesByUser(String username, int sid);
	
	public Challenge updateStatus(int cid, int sid);

}
