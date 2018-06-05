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

import com.skilldistillery.challengeaccepted.entities.UserChallenge;
import com.skilldistillery.challengeaccepted.entities.UserChallengeDTO;
import com.skilldistillery.challengeaccepted.services.UserChallengeService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4200" })
public class UserChallengeController {

	@Autowired
	private UserChallengeService userChallengeService;

	// users can view challenges they have accepted
	@RequestMapping(path = "/user/challenges/accept/{cid}", method = RequestMethod.GET)
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
	@RequestMapping(path = "/user/challenges/{cid}/user/{uid}/check", method = RequestMethod.GET)
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
	@RequestMapping(path = "/challenges/{cid}/accept/all", method = RequestMethod.GET)
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

	// returns all challenges a user has accepted, active and inactive
	@RequestMapping(path = "/user/{uid}/challenges/accept/all", method = RequestMethod.GET)
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

	@RequestMapping(path = "/challenges/{id}/accept", method = RequestMethod.POST)
	public UserChallenge createUserChallenge(HttpServletRequest req, HttpServletResponse res,
			@RequestBody UserChallengeDTO ucDTO, String username) {
		UserChallenge uc = userChallengeService.create(ucDTO, username);
		if (uc != null) {
			res.setStatus(201);
			return uc;
		}
		res.setStatus(400);
		return null;
	}

	// update an accepted user_challenge record w/ user_challenge id

	@RequestMapping(path = "/challenges/accept/{id}", method = RequestMethod.PATCH)
	public UserChallenge updateUserChallenge(HttpServletRequest req, HttpServletResponse res,
			@RequestBody UserChallenge userChallenge, String username) {
		return userChallengeService.update(userChallenge, username);

	}

	// delete a user challenge record w/ the challenge id and user id
	@RequestMapping(path = "/challenges/{cid}/accept/{id}", method = RequestMethod.DELETE)
	public Boolean deleteUserChallenge(@PathVariable int id, String username) {

		return userChallengeService.delete(id, username);

	}
}