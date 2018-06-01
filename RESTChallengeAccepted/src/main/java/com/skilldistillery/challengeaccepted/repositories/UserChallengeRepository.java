package com.skilldistillery.challengeaccepted.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.challengeaccepted.entities.UserChallenge;

public interface UserChallengeRepository extends JpaRepository<UserChallenge, Integer> {

	public List<UserChallenge> findByChallengeId(int userId);
	public List<UserChallenge> findByUserId(int userId);
}
