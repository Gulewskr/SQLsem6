import react, { useMemo, useState } from 'react';
import router , { Routes, Route } from 'react-router-dom';
import Header from './component/Header';
import Admin from './routes/Admin';
import Cars from './routes/Cars';
import Clients from './routes/Clients';
import Equipement from './routes/Equipement';
import Hire from './routes/Hire';
import Main from './routes/Main';
import Marks from './routes/Marks';
import Models from './routes/Models';
import Login from './routes/Login';

import logo from './logo.svg';
import './App.css';
import React from 'react';

const App = () => 
{
  const [state, setState] = useState(
    {
      login: 'Admin',
      type: 2
    }
  )

  return (
    <div className="App">
      <Header state={state} setState={setState} />
      <Routes>
        <Route path={'/'} element={<Main />} />
        <Route path={'/login'} element={<Login  state={state} setState={setState} />} />
        {
          state.type !== 0 &&
          <>
            <Route path={'/cars/*'} element={<Cars />} />
            <Route path={'/models/*'} element={<Models />} />
            <Route path={'/marks/*'} element={<Marks />} />
            <Route path={'/Equipement/*'} element={<Equipement />} />
            <Route path={'/clients/*'} element={<Clients />} />
            <Route path={'/Hire/*'} element={<Hire />} />
            <Route path={'/AdminPanel/*'} element={<Admin />} />
          </>
        }
      </Routes>
    </div>
  );
}

export default App;
