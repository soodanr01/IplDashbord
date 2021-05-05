import { React , useEffect , useState} from 'react';
import {useParams} from 'react-router-dom';
import { MatchDetailsCard } from '../Components/MatchDetailsCard';
import { MatchsmallCard } from '../Components/MatchsmallCard';

export const  Teampage = () => {


    const[team , setTeam] = useState({matches: []});
    const { teamName } = useParams();    

    useEffect(
         () => {
             const fetchMatches = async () =>{
                const response = await fetch(`http://localhost:8080/team/${teamName}`);
                const data = await response.json();
                console.log(data);
                setTeam(data);
             }

             fetchMatches();
         },[teamName]

    );
     
    if(!team || !team.teamName){
      return <h1>Team Not FOund!</h1>
    }
  return (
    <div className="Teampage">
      <h1>{team.teamName}</h1>
     <MatchDetailsCard teamName={team.teamName} match = {team.matches[0]}/>
     {team.matches.slice(1).map(match => <MatchsmallCard teamName={team.teamName} match = {match} />)}

    </div>
  );
}


