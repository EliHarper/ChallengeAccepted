package com.skilldistillery.challengeaccepted.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.challengeaccepted.entities.Skill;
import com.skilldistillery.challengeaccepted.repositories.ChallengeRepository;
import com.skilldistillery.challengeaccepted.repositories.SkillRepository;
import com.skilldistillery.challengeaccepted.repositories.UserRepository;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillRepository skillzRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ChallengeRepository chaRepo;
	
	public Skill create(Skill s) {
		skillzRepo.saveAndFlush(s);
		return s;
	}
	
	public Skill update(Skill s) {
		skillzRepo.saveAndFlush(s);
		return s;
	}
	
	public List<Skill> index() {
		return skillzRepo.findAll();
	}
	
	public Skill show(int id) {
		return skillzRepo.findById(id).get();
	}
	
	public Boolean delete(int id) {
		try {
			skillzRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	// Need query to return list of skills for a user, need to order by points descending (most-to-least)
}
