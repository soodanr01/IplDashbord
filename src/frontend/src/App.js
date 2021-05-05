import './App.css';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import {Teampage} from './Pages/TeamPage';

function App() {
  return (
    <div className="App">
      <Router>
        <Route path="/teams/:teamName">
         <Teampage />
        </Route>
      </Router>
    </div>
  );
}

export default App;
