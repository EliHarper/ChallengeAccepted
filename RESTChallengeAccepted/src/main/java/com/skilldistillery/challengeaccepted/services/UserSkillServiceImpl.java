package com.skilldistillery.challengeaccepted.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.challengeaccepted.entities.UserSkill;
import com.skilldistillery.challengeaccepted.repositories.UserSkillRepository;

@Service
public class UserSkillServiceImpl implements UserSkillService {
	
	@Autowired
	private UserSkillRepository userSkillRepo; 
	
	public Set<UserSkill> getUserSkillsByUserId(int uid) {
		return userSkillRepo.findByUserId(uid); 
	}
}
