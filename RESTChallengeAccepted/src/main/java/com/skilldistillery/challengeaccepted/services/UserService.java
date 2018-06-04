package com.skilldistillery.challengeaccepted.services;

import com.skilldistillery.challengeaccepted.entities.User;

public interface UserService {
	
	public User create(User u);
	
	public User update(User u);
	
	public User show(int id);
	
	public Boolean delete(int id);
	
}
