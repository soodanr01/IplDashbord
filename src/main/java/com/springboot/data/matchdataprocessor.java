package com.springboot.data;

import java.time.LocalDate;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.springboot.model.Match;

public class matchdataprocessor implements ItemProcessor<MatchInput, Match> {
	
	 private static final Logger log = LoggerFactory.getLogger(matchdataprocessor.class);

	  @Override
	  public Match process(final MatchInput matchinput) throws Exception {
	    Match match = new Match();
	    match.setId(Long.parseLong(matchinput.getId()));
	    match.setCity(matchinput.getCity());
	    
	    match.setDate(LocalDate.parse(matchinput.getDate()));
	    
	    match.setPlayerofmatch(matchinput.getPlayer_of_match());
	    match.setVenue(matchinput.getVenue());
	    
	  
	   		
	    
	    String frstinnteam, secinnteam;
	    
	    if("bat".equals(matchinput.getToss_decision()))
	    {
	    	frstinnteam= matchinput.getToss_winner();
	    	secinnteam = matchinput.getToss_winner().equals(matchinput.getTeam1())? 
	    			matchinput.getTeam2() : matchinput.getTeam1();
	    	
	    			
	    }else {
	    	secinnteam= matchinput.getToss_winner();
	    	frstinnteam = matchinput.getToss_winner().equals(matchinput.getTeam1())? 
	    			matchinput.getTeam2() : matchinput.getTeam1();
	    }
	    match.setTeam1(frstinnteam);
	    match.setTeam2(secinnteam); 
	    
	    match.setTossDecision(matchinput.getToss_decision());
	    match.setTossWinner(matchinput.getToss_winner());
	    match.setMatchWinner(matchinput.getWinner());
	    match.setResult(matchinput.getResult());
	    match.setResultMargin(matchinput.getResult_margin());
	    match.setUmpire1(matchinput.getUmpire1());
	    match.setUmpire2(matchinput.getUmpire2());
	    
	    return match;
	  }

}




