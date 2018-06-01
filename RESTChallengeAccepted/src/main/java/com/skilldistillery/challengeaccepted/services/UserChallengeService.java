package com.skilldistillery.challengeaccepted.services;

import java.util.List;

import com.skilldistillery.challengeaccepted.entities.Challenge;
import com.skilldistillery.challengeaccepted.entities.User;
import com.skilldistillery.challengeaccepted.entities.UserChallenge;

public interface UserChallengeService {

	public UserChallenge create(UserChallenge uc, String username);
	public UserChallenge update(UserChallenge uc, String username);
	public Boolean delete(int id, String username);
	public List<UserChallenge> index();
	public UserChallenge show(int id, String username);
	public List<UserChallenge> userChallengesOfAChallenge(Challenge challenge, String username);
	public List<UserChallenge> userChallengesOfAUser(User user, String username);
}
