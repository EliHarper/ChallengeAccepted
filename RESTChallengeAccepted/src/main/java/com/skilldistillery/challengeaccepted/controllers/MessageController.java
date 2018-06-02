package com.skilldistillery.challengeaccepted.controllers;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.challengeaccepted.entities.Message;
import com.skilldistillery.challengeaccepted.services.MessageService;
import com.skilldistillery.challengeaccepted.services.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class MessageController {
	
	@Autowired
	private MessageService messageServ;
	
	@Autowired
	private UserService userServ;
	
	@RequestMapping(path="ping", method=RequestMethod.GET)
	public String ping() {
		return "pong";
	}
	
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
	
	@RequestMapping(path="messages/threads/{tid}", method=RequestMethod.GET)
	public Set<Message> indexThreadMessages(HttpServletRequest req, HttpServletResponse res, @PathVariable int tid) {
		if(messageServ.indexThreadMessages(tid) != null) {
			res.setStatus(200);
			return messageServ.indexThreadMessages(tid);
		}
		res.setStatus(404);
		return null;
	}
	
	@RequestMapping(path="messages/heads/{uid}", method=RequestMethod.GET)
	public Set<Message> indexThreads(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid) {
		if(messageServ.indexThreads(uid) != null) {
			res.setStatus(200);
			return messageServ.indexThreads(uid);
		}
		res.setStatus(404);
		return null;
	}
}

