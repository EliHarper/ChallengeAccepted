package com.skilldistillery.challengeaccepted.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

<<<<<<< HEAD
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
=======
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
>>>>>>> eeb769fae8bfc0648c7fede834c7e1d9d70ae0ca

import com.skilldistillery.challengeaccepted.entities.UserChallenge;

public class UserChallengeTest {
<<<<<<< HEAD
=======

>>>>>>> eeb769fae8bfc0648c7fede834c7e1d9d70ae0ca
	private EntityManagerFactory emf;
	private EntityManager em;
	private UserChallenge uc;
	
<<<<<<< HEAD
	@BeforeEach
	void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("ChallengeAccepted");
		em = emf.createEntityManager();
		uc = em.find(UserChallenge.class, 1);
	}
	
	@AfterEach
	void tearDown() throws Exception {
=======
	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("ChallengeAccepted");
		em = emf.createEntityManager();
		uc = new UserChallenge();
	}
	
	@After
	public void tearDown() throws Exception {
>>>>>>> eeb769fae8bfc0648c7fede834c7e1d9d70ae0ca
		em.close();
		emf.close();
	}
	
	@Test
<<<<<<< HEAD
	void test_message_associations() {
		assertEquals(1, uc.getUser().getId());
	}
=======
	public void basic_user_challenge_mapping() {
		uc = em.find(UserChallenge.class, 1);
		assertEquals("", uc.getUser().getUsername());
	}
	
>>>>>>> eeb769fae8bfc0648c7fede834c7e1d9d70ae0ca
}
