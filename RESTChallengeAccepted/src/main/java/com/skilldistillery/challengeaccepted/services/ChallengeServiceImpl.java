package com.skilldistillery.challengeaccepted.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.challengeaccepted.entities.Challenge;
import com.skilldistillery.challengeaccepted.entities.ChallengeDTO;
import com.skilldistillery.challengeaccepted.entities.Skill;
import com.skilldistillery.challengeaccepted.entities.Status;
import com.skilldistillery.challengeaccepted.entities.User;
import com.skilldistillery.challengeaccepted.entities.UserChallenge;
import com.skilldistillery.challengeaccepted.repositories.ChallengeRepository;
import com.skilldistillery.challengeaccepted.repositories.SkillRepository;
import com.skilldistillery.challengeaccepted.repositories.StatusRepository;
import com.skilldistillery.challengeaccepted.repositories.UserChallengeRepository;
import com.skilldistillery.challengeaccepted.repositories.UserRepository;

@Service
public class ChallengeServiceImpl implements ChallengeService {

	@Autowired
	private ChallengeRepository chaRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private SkillRepository skillzRepo;
	@Autowired
	private StatusRepository statusRepo;
	@Autowired
	private UserChallengeRepository userChallRepo;

	@Override
	public Challenge create(ChallengeDTO cDTO) {
		Challenge c = new Challenge();
		User user = userRepo.findById(cDTO.getCreatorId()).get();
		Skill skill = skillzRepo.findById(cDTO.getSkillId());
		Status status = statusRepo.findById(1).get();
		c.setLocation(cDTO.getLocation());
		c.setName(cDTO.getName());
		c.setDescription(cDTO.getDescription());
		c.setWager(cDTO.getWager());
		c.setMinNumberOfChallengers(cDTO.getMinNumberOfChallengers());
		c.setMaxNumberOfChallengers(cDTO.getMaxNumberOfChallengers());
		c.setTags(cDTO.getTags());
		c.setCreator(user);
		c.setSkill(skill);
		c.setStatus(status);
		chaRepo.saveAndFlush(c);
		
		UserChallenge userChall = new UserChallenge();
		userChall.setAccepted(true);
		userChall.setAcceptorWon(false);
		userChall.setUser(user);
		userChall.setChallenge(c);
		userChallRepo.saveAndFlush(userChall);
		
		return c;
	}

	@Override
	public Challenge update(Challenge c, int cid) {
		Challenge managedChallenge = chaRepo.findById(cid).get();
		if (c.getLocation() != null && !c.getLocation().equals("")) {
			managedChallenge.setLocation(c.getLocation());
		}
		if (c.getDescription() != null && !c.getDescription().equals("")) {
			managedChallenge.setDescription(c.getDescription());
		}
		if (c.getName() != null && !c.getName().equals("")) {
			managedChallenge.setName(c.getName());
		}
		if (c.getMinNumberOfChallengers() != 0) {
			managedChallenge.setMinNumberOfChallengers(c.getMinNumberOfChallengers());
		}
		if (c.getMaxNumberOfChallengers() != 0) {
			managedChallenge.setMaxNumberOfChallengers(c.getMaxNumberOfChallengers());
		}

		chaRepo.saveAndFlush(managedChallenge);
		return managedChallenge;
	}
	
	@Override
	public Challenge updateStatus(int cid, int sid) {
		Challenge managedChallenge = chaRepo.findById(cid).get();
		Status managedStatus = statusRepo.findById(sid).get();
		managedChallenge.setStatus(managedStatus);
		chaRepo.saveAndFlush(managedChallenge);
		return managedChallenge;
	}
	
	public List<Challenge> index() {
		return chaRepo.findAll();
	}

	public Challenge show(int id) {
		Challenge chall = chaRepo.findById(id).get();
		return chall;
	}

	@Override
	public Boolean delete(int id) {
		try {
			chaRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// view all challenges by status id
	public Set<Challenge> indexStatusChallenges(int sid) {
		Set<Challenge> challengeList = chaRepo.findByStatusId(sid);
		return challengeList;
	}

	// view all challenges for a user by status id
	public Set<Challenge> indexStatusChallengesByUser(String username, int sid) {
		User u = userRepo.findByUsername(username);
		return chaRepo.getChallengesByUserIdAndStatus(u.getId(), sid);
	}

}
