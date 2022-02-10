import React, { Component } from "react";
import "./App.css";
import "./components/Ninjas.css";


import { Route, Switch, Link } from "react-router-dom";
import EditNinja from "./components/EditNinja";
import AddNinja from "./components/AddNinja";
import Ninjas from './components/Ninjas'
import Card from "./components/Card";
import Home from './components/Home';
import PinkNinja from './images/PinkNinja.png';

class App extends Component {
  render() {
    return (
      <div>
     
     <nav className="navbar navbar-expand-sm navbar-dark bg-dark">
        <a className='navbar-brand' href='/card'>
           <img src={PinkNinja} alt="Logo" style={{width: '55px'}}>
          </img> 
          </a>
          <a className='navbar-brand' href='/'>
         <div className="btn btn-sm a animated-button sandy-three "><strong>Ninja  <span className="TableHead">Portal.</span></strong></div>
         </a>
          <ul className="navbar-nav">
            <li className="nav-item">
              <Link className="nav-link" to="/addNinja">
                Add Ninja
              </Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to="/card">
                View Ninjas
              </Link>
            </li>
          </ul>
          <ul className="ml-auto mb-3 pr-4">
              <div className="body">
                <Home  />
             </div> 
          </ul>
        </nav>
        <Switch>
          <Route exact path="/" component={Ninjas} />
          <Route path="/home" component={Home} />
          <Route path="/card" component={Card} />
          <Route path="/addNinja" component={AddNinja} />
          <Route path="/edit/:ninjaId" component={EditNinja} />
        </Switch>
      </div>
    );
  }
}

export default App;
