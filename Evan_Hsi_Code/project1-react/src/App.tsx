import React from 'react';
//import logo from './logo.svg';
import './App.css';
//import './main.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import { LoginComponent } from './components/login-component/LoginComponent';
import { NavbarComponent } from './components/navbar-component/NavbarComponent';
import { DashEmpComponent } from './components/dashemp-component/DashEmpComponent';
import { DashManComponent } from './components/dashman-component/DashManComponent';
import { ManageComponent } from './components/manage-component/ManageComponent';
import { RegisterComponent } from './components/register-component/RegisterComponent';


const App: React.FC = () => {
  return (
    <div className="App">
        <Router>
          <NavbarComponent/>  
          <Switch>
            
            <Route path='/login' component={LoginComponent}/>
            <Route path='/dashemp' component={DashEmpComponent}/>
            <Route path='/dashman' component={DashManComponent}/>
            <Route path='/manage' component={ManageComponent}/>
            <Route path='/register' component={RegisterComponent}/>
          </Switch>
        </Router>
    </div>
  );
}

export default App;

/*
<header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
*/