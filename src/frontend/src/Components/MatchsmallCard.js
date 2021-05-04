import { React } from 'react';

export const  MatchsmallCard = ({match}) => {
  return (
    <div className="MatchsmallCard">
     <p> {match.team1} vs {match.team2}</p>
     
    </div>
  );
}


