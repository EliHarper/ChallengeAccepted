package com.skilldistillery.challengeaccepted.controllers;

import java.security.Principal;
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
			String username, Principal principal) {
		Challenge cha = chaServ.show(id);
		if (cha != null) {
			res.setStatus(200);
			return cha;
		}
		res.setStatus(404);
		return null;
	}

	// view all challenges
	@RequestMapping(path = "challenges", method = RequestMethod.GET)
	public List<Challenge> allChallenges(HttpServletRequest req, HttpServletResponse res, Principal principal) {
		List<Challenge> lc = chaServ.index();
		if (lc != null) {
			res.setStatus(200);
			return lc;
		}
		res.setStatus(404);
		return null;
	}

	// view list of challenges for one status by passing the status id
	@RequestMapping(path = "challenges/status/{sid}", method = RequestMethod.GET)
	public Set<Challenge> indexChallengesByStatus(HttpServletRequest req, HttpServletResponse res,
			@PathVariable int sid, Principal principal) {
		Set<Challenge> sc = chaServ.indexStatusChallenges(sid);
		if (sc != null) {
			res.setStatus(200);
			return sc;
		}
		res.setStatus(404);
		return null;
	}

	// update the status of a challenge, using challenge id and status id
	@RequestMapping(path = "challenges/{cid}/status/{sid}", method = RequestMethod.PATCH)
	public Challenge updateChallengeStatus(HttpServletRequest req, HttpServletResponse res, @PathVariable int cid,
			@PathVariable int sid, Principal principal) {
		Challenge cha = chaServ.updateStatus(cid, sid);
		if (cha != null) {
			res.setStatus(201);
			return cha;
		}
		res.setStatus(404);
		return null;
	}

	// view list of challenges for one user by status
	@RequestMapping(path = "challenges/user/{username}/status/{sid}", method = RequestMethod.GET)
	public Set<Challenge> indexChallengeByUserAndStatus(HttpServletRequest req, HttpServletResponse res,
			@PathVariable String username, @PathVariable int sid, Principal principal) {
		Set<Challenge> sc = chaServ.indexStatusChallengesByUser(username, sid);
		if (sc != null) {
			res.setStatus(200);
			return sc;
		}
		res.setStatus(404);
		return null;
	}

	// create new challenge
	@RequestMapping(path = "challenges", method = RequestMethod.POST)
	public Challenge newChallenge(HttpServletRequest req, HttpServletResponse res, @RequestBody ChallengeDTO cDTO, Principal principal) {
		Challenge cha = chaServ.create(cDTO);
		if (cha != null) {
			res.setStatus(200);
			return cha;
		}
		res.setStatus(404);
		return null;
	}

	// update existing challenge by challenge id
	@RequestMapping(path = "challenges/{id}", method = RequestMethod.PATCH)
	public Challenge updateChallenge(HttpServletRequest req, HttpServletResponse res, @PathVariable int id, @RequestBody Challenge challenge, Principal principal) {
		Challenge cha = chaServ.update(challenge, id);
		if (cha != null) {
			res.setStatus(200);
			return cha;
		}
		res.setStatus(404);
		return null;
	}

	// delete challenge by challenge id
//	Doesn't work because of foreign keys - would need a cascading delete, not necessary for MVP
	@RequestMapping(path = "challenges/{id}", method = RequestMethod.DELETE)
	public Boolean deleteChallenge(HttpServletRequest req, HttpServletResponse res, @PathVariable int id, Principal principal) {
		if (chaServ.delete(id) != null) {
			res.setStatus(200);
			return chaServ.delete(id);
		}
		res.setStatus(404);
		return null;
	}

}
