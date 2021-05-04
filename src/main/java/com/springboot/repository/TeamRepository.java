package com.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Team;


public interface TeamRepository extends CrudRepository<Team, Long>{
	
	Team findByTeamName(String teamName);
		
}
