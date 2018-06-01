package com.skilldistillery.challengeaccepted.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.challengeaccepted.entities.Challenge;

public interface ChallengeRepository extends JpaRepository<Challenge, Integer> {

}
