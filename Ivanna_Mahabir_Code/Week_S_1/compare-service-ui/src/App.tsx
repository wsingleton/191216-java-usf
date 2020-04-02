import React from 'react';
import HomeComponent from './components/home-component/HomeContainer';
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

import './App.css';

function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route path ='/img/:idA/:idB' component={ImageComponent}/>
          <Route path = '/' component={HomeComponent}/>
        </Switch>
      </Router>
      
    </div>
  );
}

export default App;
