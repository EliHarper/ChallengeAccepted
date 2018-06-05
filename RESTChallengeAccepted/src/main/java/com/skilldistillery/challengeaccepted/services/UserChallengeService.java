package com.skilldistillery.challengeaccepted.services;

import java.util.List;

import com.skilldistillery.challengeaccepted.entities.Challenge;
import com.skilldistillery.challengeaccepted.entities.UserChallenge;
import com.skilldistillery.challengeaccepted.entities.UserChallengeDTO;
import com.skilldistillery.challengeaccepted.entities.UserSkill;

public interface UserChallengeService {

	public UserChallenge create(UserChallengeDTO ucDTO, String username);
	
	public UserChallenge update(UserChallenge uc, String username);
	
	public Boolean delete(int id, String username);
	
	public List<UserChallenge> index();
	
	public UserChallenge show(int id, String username);
	
	public List<UserChallenge> getTheChallengeAcceptorsForAChallenge(int cid, String username);
	
	public List<UserChallenge> challengesUserHasParticipatedIn(int uid, String username);
	
	public UserChallenge checkIfUserHasAcceptedChallenge(int cid, int uid);
	
	public UserChallenge updateUCRecord(int cid, int uid);
	
	public UserSkill tallyUserSkillPointsForChallenge(Challenge challenge, int uid);
}
