import { React } from 'react';
import {Link} from 'react-router-dom';

import './Matchsmallcard.scss';

export const  MatchsmallCard = ({teamName, match}) => {
  const otherteam = match.team1 === teamName ? match.team2 : match.team1;
  const otherteamroute = `/teams/${otherteam}`;

  const ismatchwon = teamName === match.matchWinner;
  return (
    <div className={ismatchwon ? 'MatchsmallCard won-card' : 'MatchsmallCard lost-card'}>
    
      <span className ="vs">vs</span>
      <h1> <Link to= {otherteamroute}> {otherteam}</Link></h1>
     <p className ="match-result">{match.matchWinner} won by {match.resultMargin} {match.result}</p>
     <p>{match.date}</p>
    </div>
  );
}


