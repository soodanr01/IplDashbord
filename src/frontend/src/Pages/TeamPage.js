import { React , useEffect , useState} from 'react';
import {useParams, Link} from 'react-router-dom';
import { MatchDetailsCard } from '../Components/MatchDetailsCard';
import { MatchsmallCard } from '../Components/MatchsmallCard';
import { PieChart } from 'react-minimal-pie-chart';


import './TeamPage.scss';

export const  Teampage = () => {


    const[team , setTeam] = useState({matches: []});
    const { teamName } = useParams();    

    useEffect(
         () => {
             const fetchTeam = async () =>{
                const response = await fetch(`http://localhost:8080/team/${teamName}`);
                const data = await response.json();
                console.log(data);
                setTeam(data);
             }

             fetchTeam();
         },[teamName]

    );
     
    if(!team || !team.teamName){
      return <h1>Team Not FOund!</h1>
    }
  return (
    <div className="Teampage">
      <div className = "team-name-sec">
        <h1 className ="team-name">{team.teamName}</h1>
      </div>
      <div className = "winn-loss-sec">
        Wins Vs Losses
        <PieChart
          data={[
            { title: 'Wins', value: team.totalwins, color: '#4da375' },
            { title: 'Losses', value: team.totalMatchesplayed- team.totalwins, color: '#a34d5d' },
            
          ]}
/>
      </div>
      <div className ="matchdetail-sec">
      <h3> Latest Matches</h3>
        <MatchDetailsCard teamName={team.teamName} match = {team.matches[0]}/>
     </div>
        {team.matches.slice(1).map(match => <MatchsmallCard key={match.id} teamName={team.teamName} match = {match} />)}
        <div className ="more-link">
        <Link to = {`/teams/${teamName}/matches/${process.env.REACT_APP_DATA_END_YEAR}`}>More></Link> 
          
        </div>
    </div>
  );
}


