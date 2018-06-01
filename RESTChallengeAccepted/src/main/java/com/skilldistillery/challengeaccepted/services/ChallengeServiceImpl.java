package com.skilldistillery.challengeaccepted.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.challengeaccepted.entities.Challenge;
import com.skilldistillery.challengeaccepted.repositories.ChallengeRepository;
import com.skilldistillery.challengeaccepted.repositories.SkillRepository;
import com.skilldistillery.challengeaccepted.repositories.TagRepository;
import com.skilldistillery.challengeaccepted.repositories.UserRepository;

@Service
public class ChallengeServiceImpl implements ChallengeService {

	@Autowired
	private ChallengeRepository chaRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private SkillRepository skillRepo;
	
	@Autowired
	private TagRepository tagRepo;
	
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
		return chaRepo.findById(id).get();
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
}
