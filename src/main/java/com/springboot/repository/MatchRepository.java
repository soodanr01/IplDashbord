package com.springboot.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.springboot.model.Match;

public interface MatchRepository  extends CrudRepository<Match,Long >{

	
	List<Match> getByteam1OrderByDateDesc(String team1, Pageable pageable);
	
	default List<Match> findLatestMatchesbyTeam(String teamName, int count)
	{
		return getByteam1OrderByDateDesc(teamName,PageRequest.of(0, count));
	}
}
