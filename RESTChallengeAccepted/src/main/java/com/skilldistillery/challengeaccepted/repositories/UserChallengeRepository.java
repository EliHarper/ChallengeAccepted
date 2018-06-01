package com.skilldistillery.challengeaccepted.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.challengeaccepted.entities.UserChallenge;

public interface UserChallengeRepository extends JpaRepository<UserChallenge, Integer> {

}
