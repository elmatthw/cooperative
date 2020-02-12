import React from 'react';
import {Router, Route} from 'react-router';
import createBrowserHistory from './helpers/history';
import './App.css';
import {Requisites} from "./components/requisites/Requisities";

function App() {
  return (
      <Router history={createBrowserHistory}>
          <Route path='/requisites' component={Requisites}/>
      </Router>
  );
}

export default App;
