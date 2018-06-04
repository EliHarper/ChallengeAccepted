package com.skilldistillery.challengeaccepted.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.challengeaccepted.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

	@Query("SELECT m FROM Message m JOIN User s ON s.id = m.sender.id JOIN User r ON r.id = m.receiver.id WHERE m.id = :mid AND (r.id = :uid OR s.id = :uid)")
	public Message getMessageByIdAndUserId(@Param("mid") int mid, @Param("uid") int uid); 

	
	@Query("SELECT m FROM Message m JOIN User s ON s.id = m.sender.id JOIN User r ON r.id = m.receiver.id WHERE m.id = m.threadId AND (s.id = :uid OR r.id = :uid)")
	public Set<Message> getMessageThreadByUserId(@Param("uid") int uid);
	
	public Set<Message> findByThreadId(int tid);
	
}
