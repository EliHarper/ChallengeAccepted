package com.skilldistillery.challengeaccepted.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.challengeaccepted.entities.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {

}
