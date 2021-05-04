import { React , useEffect , useState} from 'react';
import { MatchDetailsCard } from '../Components/MatchDetailsCard';
import { MatchsmallCard } from '../Components/MatchsmallCard';

export const  Teampage = () => {


    const[team , setTeam] = useState({matches: []});
    

    useEffect(
         () => {
             const fetchMatches = async () =>{
                const response = await fetch('http://localhost:8080/team/Mumbai%20Indians');
                const data = await response.json();
                console.log(data);
                setTeam(data);
             }

             fetchMatches();
         },[]

    );
     
  return (
    <div className="Teampage">
      <h1>{team.teamName}</h1>
     <MatchDetailsCard match = {team.matches[0]}/>
     {team.matches.slice(1).map(match => <MatchsmallCard match = {match} />)}

    </div>
  );
}


