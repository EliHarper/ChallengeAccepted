package com.skilldistillery.challengeaccepted.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.challengeaccepted.entities.Challenge;
import com.skilldistillery.challengeaccepted.repositories.ChallengeRepository;
import com.skilldistillery.challengeaccepted.repositories.TagRepository;
import com.skilldistillery.challengeaccepted.repositories.UserRepository;

public interface ChallengeService {

	public Challenge create(Challenge c); 
	
	public Challenge update(Challenge c);
	
	public List <Challenge> index();
	
	public Challenge show(int id);
	
	public Boolean delete(int id);
	
	public Set<Challenge> indexStatusChallenges( int sid);
	
	public Set<Challenge> indexStatusChallengesByUser(int sid, int uid);

}
