import { React , useEffect , useState} from 'react';



import './Homepage.scss';
import  {TeamTile}  from '../Components/TeamTile';

export const  Homepage = () => {


    const[teams , setTeams] = useState([]);
  

    useEffect(
         () => {
             const fetchAllTeams = async () =>{
                const response = await fetch(`http://localhost:8080/team`);
                const data = await response.json();
              
                setTeams(data);
             }

             fetchAllTeams();
         },[]

    );
     
    
  return (
    <div className="Homepage">
      <div className = "header-sec">
        <h1 className ="app-name">IPL DASHBOARD</h1>
      </div>
        <div className ="team-grid">
            { teams && teams.map(team => <TeamTile key = {team.id} teamName = {team.teamName} />)}
        </div>
     </div>
  );
}


