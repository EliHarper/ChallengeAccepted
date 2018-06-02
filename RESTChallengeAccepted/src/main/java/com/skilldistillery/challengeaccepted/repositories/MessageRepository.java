package com.skilldistillery.challengeaccepted.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.challengeaccepted.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

	public Set<Message> findBySenderUsername(String username);
	public Set<Message> findByReceiverUsername(String username);
	public Message findByIdAndUserUsername(int id, String username);
	
	@Query("SELECT * FROM message m JOIN user s ON s.id = m.sender_id JOIN user r ON r.id = m.receiver_id WHERE m.id = m.thread_id AND (s.id = :id || r.id = :id)")
	public Set<Message> getMessageThreadByUserId(@Param("id") int id);
	
	public Set<Message> findByThreadId(int tid);
	
}
