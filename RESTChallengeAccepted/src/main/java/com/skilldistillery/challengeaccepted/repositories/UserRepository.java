package com.skilldistillery.challengeaccepted.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.challengeaccepted.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByIdAndUsername(int uid, String username);

	public User findByUsername(String username);

}
