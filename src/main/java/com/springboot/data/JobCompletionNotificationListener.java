package com.springboot.data;



import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.springboot.model.Team;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

  private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);


  
  private final EntityManager em;
  

  @Autowired
  public JobCompletionNotificationListener(EntityManager em) {
    this.em = em;
  }

  @Override
  @Transactional
  public void afterJob(JobExecution jobExecution) {
    if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
      log.info("!!! JOB FINISHED! Time to verify the results");

     /* jdbcTemplate.query("SELECT team1, team2 FROM Match",
        (rs, row) -> "Team1 " + rs.getString(1) + "Team2" + rs.getString(2)
         
      ).forEach(str -> System.out.println(str));*/
      //select distinct team1 from match m union select distinct team2 from match m
      
      Map<String , Team> Teamdata = new HashMap<>();
      
      em.createQuery("select m.team1, count(*) from Match m group by m.team1", Object[].class)
      	.getResultList()
      	.stream()
      	.map(e -> new Team((String) e[0],(long)e[1]))
      	.forEach(team -> Teamdata.put(team.getTeamName(), team));
      	
      	
      	em.createQuery("select m.team2, count(*) from Match m group by m.team2", Object[].class)
      		.getResultList()
      		.stream()
      		.forEach(e -> {
    			Team team = Teamdata.get((String)e[0]);
    			team.setTotalMatchesplayed(team.getTotalMatchesplayed()+ (long)e[1]);
    					
    			});
      	
      	em.createQuery("select m.matchWinner, count(*) from Match m group by m.matchWinner", Object[].class)
  		.getResultList()
  		.stream()
  		.forEach(e -> {
			Team team = Teamdata.get((String)e[0]);
			if(team != null) team.setTotalwins((long)e[1]);
					
			});
      	
      Teamdata.values().forEach(team -> em.persist(team));
      Teamdata.values().forEach(team -> System.out.println(team));
     
    }
  }
}