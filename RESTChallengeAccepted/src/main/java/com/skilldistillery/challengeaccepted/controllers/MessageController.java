package com.skilldistillery.challengeaccepted.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.challengeaccepted.repositories.MessageRepository;
import com.skilldistillery.challengeaccepted.repositories.UserRepository;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class MessageController {
	
	@Autowired
	private MessageRepository messageRepo;
	
	@Autowired
	private UserRepository userRepo;

}
