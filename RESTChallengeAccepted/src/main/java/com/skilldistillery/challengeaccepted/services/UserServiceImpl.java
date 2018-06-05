package com.skilldistillery.challengeaccepted.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.challengeaccepted.entities.User;
import com.skilldistillery.challengeaccepted.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	

	public User create(User u) {
		userRepo.saveAndFlush(u);
		return u;
	}

	public User update(User u) {
		User managedUser = userRepo.findByUsername(u.getUsername());
		if(u.getChallenges() != null) {
			managedUser.setChallenges(u.getChallenges());
		}
		if(u.getEmail() != null && !u.getEmail().equals("")) {
			managedUser.setEmail(u.getEmail());
		}
		if(u.getLocation() != null && !u.getLocation().equals("")) {
			managedUser.setLocation(u.getLocation());
		}
		if(u.getSkills() != null) {
			managedUser.setSkills(u.getSkills());
		}
		if(u.getUserChallenges() != null) {
			managedUser.setUserChallenges(u.getUserChallenges());
		}
		if(u.getUserSkills() != null) {
			managedUser.setUserSkills(u.getUserSkills());
		}
		userRepo.saveAndFlush(managedUser);
		return managedUser;
	}
	
	public User show(int uid) {
		return userRepo.findById(uid).get();
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
