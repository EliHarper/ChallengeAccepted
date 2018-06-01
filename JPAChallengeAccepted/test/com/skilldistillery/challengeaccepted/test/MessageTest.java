package com.skilldistillery.challengeaccepted.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.challengeaccepted.entities.Message;

public class MessageTest {
	private EntityManagerFactory emf;
	private EntityManager em;
	private Message m;

	@BeforeEach
	void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("ChallengeAccepted");
		em = emf.createEntityManager();
		m = em.find(Message.class, 1);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		em.close();
		emf.close();
	}
	
	@Test
	void test_message_associations() {
		assertEquals("AlexTheDestroyer", m.getSender().getUsername());
	}
	@Test
	void test_message_associations_receiver() {
		assertEquals("DoraTheExplora", m.getReceiver().getUsername());
	}
}
