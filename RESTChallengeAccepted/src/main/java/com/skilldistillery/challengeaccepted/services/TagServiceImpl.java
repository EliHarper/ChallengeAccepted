package com.skilldistillery.challengeaccepted.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.challengeaccepted.entities.Tag;
import com.skilldistillery.challengeaccepted.repositories.TagRepository;

@Service
public class TagServiceImpl implements TagService {
	
	@Autowired
	private TagRepository tagRepo; 
	
	
	public List<Tag> index() {
		return tagRepo.findAll();
	}

}
