package com.skilldistillery.challengeaccepted.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.challengeaccepted.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

	public Set<Message> findBySenderUsername(String username);
	public Set<Message> findByReceiverUsername(String username);
//	public Message findByIdAndUserUsername(int id, String username);
	
//	@Query("SELECT m FROM Message m JOIN User s ON s.id = m.sender.id JOIN User r ON r.id = m.receiver.id WHERE m.id = m.threadId AND (s.id = :id OR r.id = :id)")
//	public Set<Message> getMessageThreadByUserId(@Param("id") int id);
//	
//	public Set<Message> findByThreadId(int tid);
	
}
