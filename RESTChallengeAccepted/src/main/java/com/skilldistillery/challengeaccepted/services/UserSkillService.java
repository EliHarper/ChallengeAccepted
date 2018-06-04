package com.skilldistillery.challengeaccepted.services;

import java.util.Set;

import com.skilldistillery.challengeaccepted.entities.UserSkill;

public interface UserSkillService {
	
	public Set<UserSkill> getUserSkillsByUserId(int uid);

}
