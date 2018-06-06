package com.skilldistillery.challengeaccepted.services;

import java.util.Set;

import com.skilldistillery.challengeaccepted.entities.Message;

public interface MessageService {
	
	public Set<Message> indexThreads(String username);
	
	public Message create(Message message);
	
	public Boolean destroy (String username, int mid);
	
	public Set<Message> indexThreadMessages(int tid);

	Message show(int mid, String username);
}
