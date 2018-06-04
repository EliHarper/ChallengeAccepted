package com.skilldistillery.challengeaccepted.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user_challenge")
public class UserChallenge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private boolean accepted;

	@ManyToOne
	@JoinColumn(name="challenge_id")
	@JsonIgnore
	private Challenge challenge;
	
	@ManyToOne
	@JoinColumn(name="invited_user_id")
	private User user;
	
	@Column(name="acceptor_won")
	private boolean acceptorWon;
	
	@CreationTimestamp
	@Column(name="accept_time")
	private Date acceptedTime;

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public boolean isAcceptorWon() {
		return acceptorWon;
	}

	public void setAcceptorWon(boolean acceptorWon) {
		this.acceptorWon = acceptorWon;
	}

	public Date getAcceptedTime() {
		return acceptedTime;
	}

	public void setAcceptedTime(Date acceptedTime) {
		this.acceptedTime = acceptedTime;
	}

	public Challenge getChallenge() {
		return challenge;
	}

	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserChallenge [id=");
		builder.append(id);
		builder.append(", accepted=");
		builder.append(accepted);
		builder.append(", acceptorWon=");
		builder.append(acceptorWon);
		builder.append(", acceptedTime=");
		builder.append(acceptedTime);
		builder.append("]");
		return builder.toString();
	}
	
}
