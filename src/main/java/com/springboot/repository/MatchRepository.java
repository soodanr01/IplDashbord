package com.springboot.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springboot.model.Match;

public interface MatchRepository  extends CrudRepository<Match,Long >{

	
	List<Match> findByTeam1OrTeam2OrderByDateDesc(String team1, String team2,Pageable pageable);
    
	@Query("select m from Match m where (m.team1 = :teamName or m.team2 = :teamName) and m.date between :Datestart and :Dateend order by date desc")
	List<Match> getMatchesByteamBetweenDates(
		 @Param("teamName")String teamName,@Param("Datestart") LocalDate Datestart, @Param("Dateend") LocalDate Dateend);


	//List<Match> findByTeam1OrTeam2AndDateBetweenOrderByDateDesc(String team1, String team2, LocalDate date1, LocalDate date2);
	
	default List<Match> findLatestMatchesbyTeam(String teamName, int count)
	{
		return findByTeam1OrTeam2OrderByDateDesc(teamName,teamName,PageRequest.of(0, count));
	}
}
