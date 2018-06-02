package com.skilldistillery.challengeaccepted.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.challengeaccepted.entities.User;
import com.skilldistillery.challengeaccepted.repositories.ChallengeRepository;
import com.skilldistillery.challengeaccepted.repositories.MessageRepository;
import com.skilldistillery.challengeaccepted.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private MessageRepository mesRepo;
	
	@Autowired 
	private ChallengeRepository chaRepo;

	public User create(User u) {
		userRepo.saveAndFlush(u);
		return u;
	}

	public User update(User u) {
		userRepo.saveAndFlush(u);
		return u;
	}
	
	public List <User> index() {
		return userRepo.findAll();
	}
	
	public User show(int id) {
		return userRepo.findById(id).get();
	}
	
	public Boolean delete(int id) {
		try {
			userRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
