package com.skilldistillery.challengeaccepted.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.challengeaccepted.entities.UserSkill;

public interface UserSkillRepository extends JpaRepository<UserSkill, Integer> {
	
	public Set<UserSkill> findByUserId(int uid); 
	
	public UserSkill findById(int id); 
}
