import React from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Provider } from 'react-redux';
import { store } from './Store';
import { BrowserRouter as Router, Switch } from 'react-router-dom';
import { NavbarComponent } from './components/navbar-component/NavbarComponent';


const App: React.FC = () => {
  return (
    <div className="App">
      <Provider store={store}>
        <Router>
          <NavbarComponent/>
          <Switch>
            
          </Switch>
          
        </Router>
      </Provider>
     
    </div>
  );
}

export default App;
