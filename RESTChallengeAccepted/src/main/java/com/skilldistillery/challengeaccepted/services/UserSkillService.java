package com.skilldistillery.challengeaccepted.services;

import java.util.Set;

import com.skilldistillery.challengeaccepted.entities.UserSkill;

public interface UserSkillService {
	
	public UserSkill create(UserSkill us);
	
	public UserSkill update(UserSkill us, int newPoints);
	
	public Boolean destroy(int usid);

	public Set<UserSkill> getUserSkillsByUsername(String username);
	
	public UserSkill getOneUserSkill(int sid, int uid);

}
