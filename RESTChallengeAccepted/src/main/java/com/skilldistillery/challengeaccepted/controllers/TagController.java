package com.skilldistillery.challengeaccepted.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.challengeaccepted.entities.Tag;
import com.skilldistillery.challengeaccepted.services.TagService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class TagController {
	
	@Autowired
	private TagService tagServ; 
	
	@RequestMapping(path="tags", method=RequestMethod.GET)
	public List<Tag> index(HttpServletRequest req, HttpServletResponse res){
		if (tagServ.index() != null) {
			res.setStatus(200);
			return tagServ.index();
		}
		res.setStatus(404);
		return null;
	}

}
