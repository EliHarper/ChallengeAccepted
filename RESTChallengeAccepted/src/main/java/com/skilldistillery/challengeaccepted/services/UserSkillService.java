package com.skilldistillery.challengeaccepted.services;

import java.util.Set;

import com.skilldistillery.challengeaccepted.entities.UserSkill;

public interface UserSkillService {
	
	public Set<UserSkill> getUserSkillsByUserId(int uid);
	
	public UserSkill create(UserSkill us);
	
	public UserSkill update(UserSkill us, int newPoints);
	
	public void destory(int usid);

}
