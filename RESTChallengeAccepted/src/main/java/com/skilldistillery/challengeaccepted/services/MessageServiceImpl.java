package com.skilldistillery.challengeaccepted.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.challengeaccepted.entities.Message;
import com.skilldistillery.challengeaccepted.entities.User;
import com.skilldistillery.challengeaccepted.repositories.MessageRepository;
import com.skilldistillery.challengeaccepted.repositories.UserRepository;
@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	private MessageRepository messageRepo;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public Set<Message> indexThreads(int id) {
		
		return messageRepo.getMessageThreadByUserId(id);
	}

	@Override
	public Set<Message> indexThreadMessages(int tid) {
		
		return messageRepo.findByThreadId(tid);
	}
	
	@Override
	public Message show(int mid, int uid) {
		
		return messageRepo.getMessageByIdAndUserId(mid, uid);
	}

	@Override
	public Message create(Message message) {
		User managedSender = userRepo.findByUsername(message.getSender().getUsername());
		message.setSender(managedSender);
		User managedReceiver = userRepo.findByUsername(message.getReceiver().getUsername());
		message.setReceiver(managedReceiver);
		return messageRepo.saveAndFlush(message);
	}

	@Override
	public void destroy(String username, int mid) {
		Message managedMessage = messageRepo.findById(mid).get();
		if(managedMessage.getSender().getUsername() == username || managedMessage.getReceiver().getUsername() == username) {
			try {
				messageRepo.deleteById(mid);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	
	
}