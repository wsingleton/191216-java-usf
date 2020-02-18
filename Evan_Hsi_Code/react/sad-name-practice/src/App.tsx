import React from 'react'
import './App.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import PokemonComponent from './containers/pokemon-component/PokemonContainer'
import { Provider } from 'react-redux'
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import { store } from './Store'


const App: React.FC = () => {
  return (
    <div className="App">
      <Provider store={store}>
        <Router>
          <Switch>
            <Route path='/pokemon' component={PokemonComponent}/>
          
        
          </Switch>
        </Router>
      </Provider>
    </div>
  )
}

export default App;
