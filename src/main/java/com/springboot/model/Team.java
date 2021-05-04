package com.springboot.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String teamName;
	private long totalMatchesplayed;
	private long totalwins;
	
	
	@Transient
	private List<Match> Matches;
	
	
	public Team() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public long getTotalMatchesplayed() {
		return totalMatchesplayed;
	}
	public void setTotalMatchesplayed(long totalMatchesplayed) {
		this.totalMatchesplayed = totalMatchesplayed;
	}
	public long getTotalwins() {
		return totalwins;
	}
	public void setTotalwins(long totalwins) {
		this.totalwins = totalwins;
	}
	public Team(String teamName, long totalMatchesplayed) {
		super();
		this.teamName = teamName;
		this.totalMatchesplayed = totalMatchesplayed;
	}
	@Override
	public String toString() {
		return "Team [teamName=" + teamName + ", totalMatchesplayed=" + totalMatchesplayed + ", totalwins=" + totalwins
				+ "]";
	}
	public List<Match> getMatches() {
		return Matches;
	}
	public void setMatches(List<Match> matches) {
		Matches = matches;
	}
	
	
}
