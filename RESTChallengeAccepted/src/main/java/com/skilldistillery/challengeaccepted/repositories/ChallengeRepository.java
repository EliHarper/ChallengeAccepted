package com.skilldistillery.challengeaccepted.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.challengeaccepted.entities.Challenge;

public interface ChallengeRepository extends JpaRepository<Challenge, Integer> {
	
	// find all challenges by status, passing status id
	public Set<Challenge> findByStatus(int sid);
	
	// find all challenges by status for a single user, passing status id and username
	public Set<Challenge> findByStatusAndUserUsername(int sid, String username);

}
