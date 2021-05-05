import { React } from 'react';
import {Link} from 'react-router-dom';
export const  MatchsmallCard = ({teamName, match}) => {
  const otherteam = match.team1 === teamName ? match.team2 : match.team1;
  const otherteamroute = `/teams/${otherteam}`;
  return (
    <div className="MatchsmallCard">
     <h3>  vs  <Link to= {otherteamroute}> {otherteam}</Link></h3>
     <p>{match.matchWinner} won by {match.resultMargin} {match.result}</p>
     
    </div>
  );
}


