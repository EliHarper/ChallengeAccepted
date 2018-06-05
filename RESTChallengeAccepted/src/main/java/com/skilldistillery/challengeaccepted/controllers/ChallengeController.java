package com.skilldistillery.challengeaccepted.controllers;

import java.util.List;
import java.util.Set;

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
import com.skilldistillery.challengeaccepted.entities.ChallengeDTO;
import com.skilldistillery.challengeaccepted.services.ChallengeService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4200" })
public class ChallengeController {
	@Autowired
	private ChallengeService chaServ;

	// view challenge by challenge id
	@RequestMapping(path = "challenges/{id}", method = RequestMethod.GET)
	public Challenge showChallenge(HttpServletRequest req, HttpServletResponse res, @PathVariable int id,
			String username) {
		if (chaServ.show(id) != null) {
			res.setStatus(200);
			return chaServ.show(id);
		}
		res.setStatus(404);
		return null;
	}

	// view all challenges
	@RequestMapping(path = "challenges", method = RequestMethod.GET)
	public List<Challenge> allChallenges(HttpServletRequest req, HttpServletResponse res) {
		if (chaServ.index() != null) {
			res.setStatus(200);
			return chaServ.index();
		}
		res.setStatus(404);
		return null;
	}

	// view list of challenges for one status by passing the status id
	@RequestMapping(path = "challenges/status/{sid}", method = RequestMethod.GET)
	public Set<Challenge> indexChallengesByStatus(HttpServletRequest req, HttpServletResponse res,
			@PathVariable int sid) {
		return chaServ.indexStatusChallenges(sid);
	}

	// view list of challenges for one user by status
	@RequestMapping(path = "challenges/user/{uid}/status/{sid}", method = RequestMethod.GET)
	public Set<Challenge> indexChallengeByUserAndStatus(HttpServletRequest req, HttpServletResponse res,
			@PathVariable int uid, @PathVariable int sid) {
		if (chaServ.indexStatusChallengesByUser(sid, uid) != null) {
			res.setStatus(200);
			return chaServ.indexStatusChallengesByUser(sid, uid);
		}
		res.setStatus(404);
		return null;
	}

	// create new challenge
	@RequestMapping(path = "challenges", method = RequestMethod.POST)
	public Challenge newChallenge(HttpServletRequest req, HttpServletResponse res, @RequestBody ChallengeDTO cDTO) {
		if (chaServ.create(cDTO) != null) {
			res.setStatus(200);
			return chaServ.create(cDTO);
		}
		res.setStatus(404);
		return null;
	}

	// update existing challenge by challenge id
	@RequestMapping(path = "challenges/{id}", method = RequestMethod.PATCH)
	public Challenge updateChallenge(HttpServletRequest req, HttpServletResponse res, @PathVariable int id,
			@RequestBody Challenge challenge) {
		if (chaServ.update(challenge, id) != null) {
			res.setStatus(200);
			return chaServ.update(challenge, id);
		}
		res.setStatus(404);
		return null;
	}

	// delete challenge by challenge id
	@RequestMapping(path = "challenges/{id}", method = RequestMethod.DELETE)
	public Boolean deleteChallenge(HttpServletRequest req, HttpServletResponse res, @PathVariable int id) {
		if (chaServ.delete(id) != null) {
			res.setStatus(200);
			return chaServ.delete(id);
		}
		res.setStatus(404);
		return null;
	}

}
