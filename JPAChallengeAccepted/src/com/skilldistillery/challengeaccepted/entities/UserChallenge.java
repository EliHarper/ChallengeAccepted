package com.skilldistillery.challengeaccepted.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="user_challenge")
public class UserChallenge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private boolean accepted;
	private boolean completed;
	
	@Column(name="acceptor_won")
	private boolean acceptorWon;
	
	@CreationTimestamp
	@Column(name="accepted_time")
	private Date acceptedTime;
}
