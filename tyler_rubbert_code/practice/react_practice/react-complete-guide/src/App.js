import React, { Component } from 'react';
import './App.css';
import Person from './Person/Person';

class App extends Component {
  state = {
    persons: [
      { name: 'Tyler', age: 26 },
      { name: 'Zach', age: 25 },
      { name: 'Taylor', age: 24}
    ]
  }

  switchNameHandler = () => {
   // console.log('Was clicked!')
   this.setState({
     persons: [
      { name: 'Tyler', age: 26 },
      { name: 'Zach', age: 25 },
      { name: 'Taylor', age: 25}
     ]
   })
  }

  render() {
    return (
      <div className="App">     
        <h1>Hi, I'm a React App</h1>
        <p>This is really working!</p>
        <button onClick={this.switchNameHandler}>Switch Name</button>
        <Person name={this.state.persons[0].name} age={this.state.persons[0].age} />
        <Person  name={this.state.persons[1].name} age={this.state.persons[1].age}>My Hobbies: Playing Guitar</Person>
        <Person  name={this.state.persons[2].name} age={this.state.persons[2].age}/>
      </div>
    );
   // return React.createElement('div', {className: 'App'}, React.createElement('h1', null, 'Does this work now?'));
  }
}

export default App;
