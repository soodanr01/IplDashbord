import './App.scss';
import {BrowserRouter as Router, Route , Switch} from 'react-router-dom';
import {Teampage} from './Pages/TeamPage';
import {MatchPage} from './Pages/MatchPage';
import {Homepage} from './Pages/Homepage';

function App() {
  return (
    <div className="App"> 
      <Router>
        <Switch>
        <Route path="/teams/:teamName/matches/:year">
         <MatchPage />
        </Route>
        <Route path="/teams/:teamName">
         <Teampage />
        </Route>
        <Route path="/">
         <Homepage />
        </Route>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
