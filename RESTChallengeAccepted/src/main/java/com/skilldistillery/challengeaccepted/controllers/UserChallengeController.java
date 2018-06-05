package com.skilldistillery.challengeaccepted.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.challengeaccepted.entities.Challenge;
import com.skilldistillery.challengeaccepted.entities.UserChallenge;
import com.skilldistillery.challengeaccepted.entities.UserChallengeDTO;
import com.skilldistillery.challengeaccepted.entities.UserSkill;
import com.skilldistillery.challengeaccepted.services.UserChallengeService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4200" })
public class UserChallengeController {

	@Autowired
	private UserChallengeService userChallengeService;

	// users can view challenges they have accepted by challenge id
	@RequestMapping(path = "user/challenges/accept/{cid}", method = RequestMethod.GET)
	public UserChallenge viewUserChallenge(HttpServletRequest req, HttpServletResponse res, @PathVariable int cid,
			String username) {
		UserChallenge uc = userChallengeService.show(cid, username);
		if (uc != null) {
			res.setStatus(200);
			return uc;
		}
		res.setStatus(400);
		return null;
	}

	// check if a user has already accepted a challenge - return the object if user
	// has, else null
	@RequestMapping(path = "user/challenges/{cid}/user/{uid}/check", method = RequestMethod.GET)
	public UserChallenge checkIfUserHasAcceptedChallenge(HttpServletRequest req, HttpServletResponse res,
			@PathVariable int cid, @PathVariable int uid, String username) {
		UserChallenge uc = userChallengeService.checkIfUserHasAcceptedChallenge(uid, cid);
		if (uc != null) {
			res.setStatus(200);
			return uc;
		}
		res.setStatus(400);
		return null;
	}

	// returns all user_challenge records for one challenge
	@RequestMapping(path = "challenges/{cid}/accept/all", method = RequestMethod.GET)
	public List<UserChallenge> allAcceptsForChallenge(HttpServletRequest req, HttpServletResponse res,
			@PathVariable int cid, String username) {
		List<UserChallenge> luc = userChallengeService.getTheChallengeAcceptorsForAChallenge(cid, username);
		if (luc != null) {
			res.setStatus(200);
			return luc;
		}
		res.setStatus(400);
		return null;
	}
	
	// tally user skill points from challenge record
//	@RequestMapping(path="challenges/{cid}/userskills", method=RequestMethod.PATCH)
//	public List<UserSkill> tallyUserSkillPointsForChallenge(@RequestBody Challenge challenge, @PathVariable int cid) {
//		return userChallengeService.tallyUserSkillPointsForChallenge(challenge);
//	}

	// returns all challenges a user has accepted, active and inactive
	@RequestMapping(path = "user/{uid}/challenges/accept/all", method = RequestMethod.GET)
	public List<UserChallenge> allAcceptsForUser(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid,
			String username) {
		if (userChallengeService.challengesUserHasParticipatedIn(uid, username) != null) {
			res.setStatus(200);
			return userChallengeService.challengesUserHasParticipatedIn(uid, username);
		}
		res.setStatus(404);
		return null;
	}

	// creates a new user_challenge record when users accept a challenge by passing
	// a challenge id

	@RequestMapping(path = "challenges/{cid}/accept", method = RequestMethod.POST)
	public UserChallenge createUserChallenge(HttpServletRequest req, HttpServletResponse res,
			@RequestBody UserChallengeDTO ucDTO, String username, @PathVariable int cid) {
		UserChallenge uc = userChallengeService.create(ucDTO, username);
		if (uc != null) {
			res.setStatus(201);
			return uc;
		}
		res.setStatus(400);
		return null;
	}

	// update an accepted user_challenge record w/ user_challenge id

	@RequestMapping(path = "challenges/accept/{ucid}", method = RequestMethod.PATCH)
	public UserChallenge updateUserChallenge(@RequestBody UserChallenge userChallenge, String username, @PathVariable int ucid) {
		return userChallengeService.update(userChallenge, username);

	}
	
	// update a user_challenge record based on user id and challenge id
	@RequestMapping(path="challenges/{cid}/user/{uid}", method=RequestMethod.PATCH)
	public UserSkill updateUserChallengeRecord(HttpServletRequest req, HttpServletResponse res, @PathVariable int cid, @PathVariable int uid, @RequestBody Challenge challenge) {
		userChallengeService.updateUCRecord(cid, uid);
		return userChallengeService.tallyUserSkillPointsForChallenge(challenge, uid);
	}


	// delete a user challenge record w/ the challenge id and user challenge id
	@RequestMapping(path = "challenges/accept/{ucid}", method = RequestMethod.DELETE)
	public Boolean deleteUserChallenge(@PathVariable int cid, @PathVariable int ucid,
			String username) {
		
		return userChallengeService.delete(ucid, username);
	}
}