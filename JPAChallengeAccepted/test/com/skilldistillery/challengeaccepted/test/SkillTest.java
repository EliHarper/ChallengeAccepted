package com.skilldistillery.challengeaccepted.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.challengeaccepted.entities.Skill;

public class SkillTest {
	private EntityManagerFactory emf;
	private EntityManager em;
	private Skill s;
	
	@BeforeEach
	void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("ChallengeAccepted");
		em = emf.createEntityManager();
		s = em.find(Skill.class, 1);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		em.close();
		emf.close();
	}
	
	@Test
	void test_skill_associations() {
		assertEquals("Drinker Driver", s.getName());
	}
}
