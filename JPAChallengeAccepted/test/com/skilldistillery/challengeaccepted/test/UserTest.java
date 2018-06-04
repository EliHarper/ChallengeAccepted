package com.skilldistillery.challengeaccepted.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.challengeaccepted.entities.User;

public class UserTest {
	private EntityManagerFactory emf;
	private EntityManager em;
	private User u;
	
	@BeforeEach
	void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("ChallengeAccepted");
		em = emf.createEntityManager();
		u = em.find(User.class, 1);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		em.close();
		emf.close();
	}
	
	@Test
	void test_user_associations() {
		assertEquals("AlexTheDestroyer", u.getUsername());
	}
	
	@Test
	void test_user_has_list_challenges() {
		assertEquals(2, u.getChallenges().get(0).getId());
	}
	
	@Test
	void test_user_has_list_skills() {
		assertEquals("drinking", u.getSkills().get(0).getName());
	}
	
	@Test
	void test_user_has_list_userChallenges() {
		assertEquals(2, u.getUserChallenges().get(0).getChallenge().getId());
	}
	
	@Test
	void test_user_has_list_userSkills() {
		assertEquals("drinking", u.getUserSkills().get(0).getSkill().getName());
	}
}
