package com.skilldistillery.challengeaccepted.entities;

import java.sql.Date;
import java.util.List;

public class ChallengeDTO {
	
	private String location;
	private String name;
	private String description;
	private Integer wager;
	private int minNumberOfChallengers;
	private int maxNumberOfChallengers;
	private List<Tag> tags;
	private int creatorId;
	private int skillId;
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getWager() {
		return wager;
	}
	public void setWager(Integer wager) {
		this.wager = wager;
	}
	public int getMinNumberOfChallengers() {
		return minNumberOfChallengers;
	}
	public void setMinNumberOfChallengers(int minNumberOfChallengers) {
		this.minNumberOfChallengers = minNumberOfChallengers;
	}
	public int getMaxNumberOfChallengers() {
		return maxNumberOfChallengers;
	}
	public void setMaxNumberOfChallengers(int maxNumberOfChallengers) {
		this.maxNumberOfChallengers = maxNumberOfChallengers;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public int getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	
	
}
