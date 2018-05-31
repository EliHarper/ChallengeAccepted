package com.skilldistillery.challengeaccepted.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.challengeaccepted.entities.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

}
