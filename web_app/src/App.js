import react from 'react';
import router , { Routes, Route } from 'react-router-dom';
import Header from './component/Header';

import logo from './logo.svg';
import './App.css';
import React from 'react';

const App = () => 
{
  return (
    <div className="App">
      <Header />
      <div>
        Test 
      </div>
      <Routes>
        <Route path={'/'} element={<div>main Page</div>} />
        <Route path={'/cars'} element={<div>cars</div>} />
        <Route path={'/models'} element={<div>models</div>} />
        <Route path={'/marks'} element={<div>marks</div>} />
        <Route path={'/clients'} element={<div>clients</div>} />
        <Route path={'/adminPanel'} element={<div>adminPanel</div>} />
      </Routes>
    </div>
  );
}

export default App;
