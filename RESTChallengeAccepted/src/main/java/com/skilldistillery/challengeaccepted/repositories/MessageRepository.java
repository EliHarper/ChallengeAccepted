package com.skilldistillery.challengeaccepted.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.challengeaccepted.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
