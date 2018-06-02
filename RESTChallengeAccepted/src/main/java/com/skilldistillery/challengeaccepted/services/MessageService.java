package com.skilldistillery.challengeaccepted.services;

import java.util.Set;

import com.skilldistillery.challengeaccepted.entities.Message;

public interface MessageService {
	
	public Set<Message> indexThreads(int uid);
	public Message show(int mid, int uid);
	public Message create(Message message);
	public void destroy (String username, int mid);
//
	public Set<Message> indexThreadMessages(int tid);
}
