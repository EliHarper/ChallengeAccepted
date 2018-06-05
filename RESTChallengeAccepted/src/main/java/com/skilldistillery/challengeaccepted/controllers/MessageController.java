package com.skilldistillery.challengeaccepted.controllers;

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

import com.skilldistillery.challengeaccepted.entities.Message;
import com.skilldistillery.challengeaccepted.services.MessageService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class MessageController {
	
	@Autowired
	private MessageService messageServ;
	
	@RequestMapping(path="ping", method=RequestMethod.GET)
	public String ping() {
		return "pong";
	}
	
	//show single message
	@RequestMapping(path="messages/{mid}", method=RequestMethod.GET)
	public Message show(HttpServletRequest req, HttpServletResponse res, @PathVariable int mid, Integer uid) {
	uid = 1;
	if(messageServ.show(mid, uid) != null) {
		res.setStatus(200);
		return messageServ.show(mid, uid);
		}
	res.setStatus(404);
	return null;
	}
	
	// show all messages in a single thread
	@RequestMapping(path="messages/threads/{tid}", method=RequestMethod.GET)
	public Set<Message> indexThreadMessages(HttpServletRequest req, HttpServletResponse res, @PathVariable int tid) {
		if(messageServ.indexThreadMessages(tid) != null) {
			res.setStatus(200);
			return messageServ.indexThreadMessages(tid);
		}
		res.setStatus(404);
		return null;
	}
	
	// show the first message of every thread for a user
	@RequestMapping(path="messages/heads/{uid}", method=RequestMethod.GET)
	public Set<Message> indexThreads(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid) {
		if(messageServ.indexThreads(uid) != null) {
			res.setStatus(200);
			return messageServ.indexThreads(uid);
		}
		res.setStatus(404);
		return null;
	}
	
	// create a new message
	@RequestMapping(path="messages", method=RequestMethod.POST)
	public Message create(HttpServletRequest req, HttpServletResponse res, @RequestBody Message message) {
		Message newMessage = messageServ.create(message);
		if (newMessage != null) {
			res.setStatus(201);
			return newMessage;
		}
		res.setStatus(404);
		return null;
	}
	
	// delete a message
	@RequestMapping(path="messages/{mid}", method=RequestMethod.DELETE)
	public Boolean destroy(HttpServletRequest req, HttpServletResponse res, @PathVariable int mid) {
		String username = "AlexTheDestroyer";
		return messageServ.destroy(username, mid);
	}
}

