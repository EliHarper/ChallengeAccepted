package com.skilldistillery.challengeaccepted.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Challenge {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private boolean active;
	private String location;
	private String name;
	private int wager;
	
	@ManyToMany(mappedBy="challenges")
	private List <User> users;
	
	@ManyToMany
	@JoinTable(name="challenge_tag",
	joinColumns = @JoinColumn(name="challenge_id"),
	inverseJoinColumns= @JoinColumn(name="tag_id"))
	private List<Tag> tags;
	
	@ManyToOne
	@JoinColumn(name="invited_user_id")
	private User challengeAcceptor;
	
	@ManyToOne
	@JoinColumn(name="skill_id")
	private Skill skill;

	@Column(name= "challenger_won")
	private boolean challengerWon;

	@OneToMany(mappedBy="challenge")
	private List <UserChallenge> userChallenges;
	
	@CreationTimestamp
	@Column(name= "time_created")
	private Date timeCreated;
	
	public Challenge() {
	}

	public Skill getSkill() {
		return skill;
	}
	
	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

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

	public int getWager() {
		return wager;
	}

	public void setWager(int wager) {
		this.wager = wager;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUser(List<User> users) {
		this.users = users;
	}

	public boolean isChallengerWon() {
		return challengerWon;
	}

	public void setChallengerWon(boolean challengerWon) {
		this.challengerWon = challengerWon;
	}

	public Date getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Date timeCreated) {
		this.timeCreated = timeCreated;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Challenge [id=");
		builder.append(id);
		builder.append(", active=");
		builder.append(active);
		builder.append(", location=");
		builder.append(location);
		builder.append(", name=");
		builder.append(name);
		builder.append(", wager=");
		builder.append(wager);
		builder.append(", users=");
		builder.append(users);
		builder.append(", challengerWon=");
		builder.append(challengerWon);
		builder.append(", timeCreated=");
		builder.append(timeCreated);
		builder.append("]");
		return builder.toString();
	}
	
	
}
