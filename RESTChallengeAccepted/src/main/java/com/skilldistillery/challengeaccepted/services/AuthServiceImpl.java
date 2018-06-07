package com.skilldistillery.challengeaccepted.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skilldistillery.challengeaccepted.entities.Skill;
import com.skilldistillery.challengeaccepted.entities.User;
import com.skilldistillery.challengeaccepted.entities.UserSkill;
import com.skilldistillery.challengeaccepted.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired 
	UserRepository userRepo;
	
	@Autowired
	UserSkillService userSkillServ;

	@Override
	public User register(String json) {
		ObjectMapper om = new ObjectMapper();
		User user = null;
		
		try {
			user = om.readValue(json, User.class);
			
			String encodedPW = encoder.encode(user.getPassword());
			user.setPassword(encodedPW);
			user.setEnabled(true);
			user.setRole("standard");
			userRepo.saveAndFlush(user);
			
			for (int i = 1; i < 21; i++) {
				UserSkill uc = new UserSkill();
				Skill skill = new Skill();
				skill.setId(i);
				uc.setPoints(0);
				uc.setSkill(skill);
				uc.setUser(user);
				userSkillServ.create(uc);
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return user;
	}

}
