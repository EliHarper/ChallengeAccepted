package com.skilldistillery.challengeaccepted.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.challengeaccepted.entities.Skill;
import com.skilldistillery.challengeaccepted.entities.User;
import com.skilldistillery.challengeaccepted.entities.UserSkill;
import com.skilldistillery.challengeaccepted.repositories.SkillRepository;
import com.skilldistillery.challengeaccepted.repositories.UserRepository;
import com.skilldistillery.challengeaccepted.repositories.UserSkillRepository;

@Service
public class UserSkillServiceImpl implements UserSkillService {
	
	@Autowired
	private UserSkillRepository userSkillRepo; 
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private SkillRepository skillzRepo;
	
	public Set<UserSkill> getUserSkillsByUsername(String username) {
		
		User u = userRepo.findByUsername(username);
		
		return userSkillRepo.findByUserIdOrderByPointsDesc(u.getId()); 
	}
	
	public UserSkill create(UserSkill us) {
		User managedUser = userRepo.findByUsername(us.getUser().getUsername());
		us.setUser(managedUser);
		Skill managedSkill = skillzRepo.findById(us.getSkill().getId()); 
		us.setSkill(managedSkill);
		
		return userSkillRepo.saveAndFlush(us); 
	}
	
	public UserSkill update(UserSkill us, int newPoints) {
			User managedUser = userRepo.findByUsername(us.getUser().getUsername());
			us.setUser(managedUser);
			Skill managedSkill = skillzRepo.findById(us.getSkill().getId()); 
			us.setSkill(managedSkill);
			
			UserSkill managedUserSkill = userSkillRepo.findById(us.getId()); 
			int totalPoints = managedUserSkill.getPoints();
				if(totalPoints == 0) {
					totalPoints = 10;
				}
			totalPoints += newPoints;
			us.setPoints(totalPoints);
			userSkillRepo.saveAndFlush(us);
			return us;
		
	}
	
	public Boolean destroy(int usid) {
		try {
			userSkillRepo.deleteById(usid);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
