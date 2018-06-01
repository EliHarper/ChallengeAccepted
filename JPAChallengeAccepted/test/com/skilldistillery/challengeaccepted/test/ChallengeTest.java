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
}
