package com.skilldistillery.challengeaccepted.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.challengeaccepted.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

	public Set<Message> findByUserUsername(String username);
	public Message findByIdAndUserUsername(int id, String username);
}
