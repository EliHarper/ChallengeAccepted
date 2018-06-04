package com.skilldistillery.challengeaccepted.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.challengeaccepted.entities.Challenge;

public class ChallengeTest {

	private EntityManagerFactory emf;
	private EntityManager em;
	private Challenge c;
	
	@BeforeEach
	void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("ChallengeAccepted");
		em = emf.createEntityManager();
		c = em.find(Challenge.class, 1);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		em.close();
		emf.close();
	}
	
	@Test
	void test_challenge_associations() {
		assertEquals("Drinking Challenge", c.getName());
	}
	
	@Test
	void test_challenge_has_a_status() {
		assertEquals("active", c.getStatus().getName()); 
	}
	
	@Test
	void test_challenge_has_list_users() {
		assertEquals("AlexTheDestroyer", c.getUsers().get(0).getUsername());
	}
	
	@Test
	void test_challenge_can_have_tags() {
		assertEquals("bar games", c.getTags().get(0).getName());
	}
	
	@Test
	void test_challenge_has_creator() {
		assertEquals("AlexTheDestroyer", c.getCreator().getUsername());
	}
	
	@Test
	void test_challenge_has_a_skill() {
		assertEquals("drinking", c.getSkill().getName());
	}
	
	@Test
	void test_challenge_has_user_challenges() {
		assertEquals(1, c.getUserChallenges().get(0).getId());
	}
}
