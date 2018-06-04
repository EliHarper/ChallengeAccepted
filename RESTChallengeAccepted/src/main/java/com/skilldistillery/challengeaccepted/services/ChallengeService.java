package com.skilldistillery.challengeaccepted.services;

import java.util.List;

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

}
