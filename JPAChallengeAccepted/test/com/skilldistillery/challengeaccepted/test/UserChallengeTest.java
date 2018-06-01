package com.skilldistillery.challengeaccepted.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.challengeaccepted.entities.UserChallenge;

public class UserChallengeTest {

	private EntityManagerFactory emf;
	private EntityManager em;
	private UserChallenge uc;
	
	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("ChallengeAccepted");
		em = emf.createEntityManager();
		uc = new UserChallenge();
	}
	
	@After
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}
	
	@Test
	public void basic_user_challenge_mapping() {
		uc = em.find(UserChallenge.class, 1);
		assertEquals("", uc.getUser().getUsername());
	}
	
}
