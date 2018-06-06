package com.skilldistillery.challengeaccepted.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skilldistillery.challengeaccepted.entities.User;
import com.skilldistillery.challengeaccepted.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired 
	UserRepository userRepo;

	@Override
	public User register(String json) {
		ObjectMapper om = new ObjectMapper();
		User user = null;
		
		try {
			user = om.readValue(json, User.class);
			
			String encodedPW = encoder.encode(user.getPassword());
			user.setPassword(encodedPW);
			user.setEnabled(true);
			user.setRole("standard");
			
			userRepo.saveAndFlush(user);
		} catch (Exception e) {
			System.out.println(e);
		}
		return user;
	}

}
