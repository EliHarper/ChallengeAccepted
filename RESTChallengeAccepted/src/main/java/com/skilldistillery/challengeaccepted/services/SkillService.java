package com.skilldistillery.challengeaccepted.services;

import java.util.List;

import com.skilldistillery.challengeaccepted.entities.Skill;

public interface SkillService {

	public Skill create(Skill s);
	public Skill update(Skill s);
	public List <Skill> index();
	public Skill show(int id);
	public Boolean delete(int id);
}
