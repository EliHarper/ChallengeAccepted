package com.skilldistillery.challengeaccepted.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skilldistillery.challengeaccepted.entities.UserSkill;

public interface UserSkillRepository extends JpaRepository<UserSkill, Integer> {
	
	public Set<UserSkill> findByUserIdOrderByPointsDesc(int uid); 
	
	public UserSkill findById(int id);
	
	public UserSkill findBySkillIdAndUserId(int sid, int uid);
	
	@Query("SELECT us FROM UserSkill us ORDER BY us.points DESC")
	public List<UserSkill> getUserSkillsByPoints();
	
}
