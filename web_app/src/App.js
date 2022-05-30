import react from 'react';
import router , { Link, Route } from 'react-router-dom';
import Header from './component/Header';

import logo from './logo.svg';
import './App.css';

const App = () => 
{
  return (
    <div className="App">
      <Header />
      <div>
        Test 
      </div>
      <Route path={'/'}>Main Page</Route>
      <Route path={'/cars'}>Cars</Route>
      <Route path={'/models'}>Model</Route>
      <Route path={'/marks'}>Mark</Route>
      <Route path={'/clients'}>Client</Route>
      <Route path={'/adminPanel'}>Admin</Route>
    </div>
  );
}

export default App;
