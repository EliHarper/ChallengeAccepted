package com.skilldistillery.challengeaccepted.repositories;

import java.util.Set;

import javax.persistence.OrderBy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.challengeaccepted.entities.UserSkill;

public interface UserSkillRepository extends JpaRepository<UserSkill, Integer> {
	
	@OrderBy("points DESC")
	public Set<UserSkill> findByUserId(int uid); 
	
	public UserSkill findById(int id);
}
