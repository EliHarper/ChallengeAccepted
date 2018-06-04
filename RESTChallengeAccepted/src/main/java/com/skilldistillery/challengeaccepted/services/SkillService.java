package com.skilldistillery.challengeaccepted.services;

import java.util.List;

import com.skilldistillery.challengeaccepted.entities.Skill;

public interface SkillService {

	public List <Skill> index();
	public Skill oneSkill(int id);

}
