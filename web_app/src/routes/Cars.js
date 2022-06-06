import react, { useMemo, useState } from 'react';
import { Routes, Route, Link } from 'react-router-dom'; 

import List from '../component/List';
import Form from '../component/Form';

const Cars = () => 
{
  const [state, setState] = useState(
    {
      list: [],
      loading: true,
    }
  );

  const [r, sr] = useState(false);

  const refreshSite = () => { sr(!r); }

  const url = 'http://localhost:8080/car';
  const headers = ['id', 'equipementList', 'yearCar', 'plate', 'color', 'basicPrice', 'model'];
  const inputs = [
    {
      label: 'id',
      type: 'text',
    },
    {
      label: 'equipementList',
      type: 'text',
    },
    {
      label: 'yearCar',
      type: 'text',
    },
    {
      label: 'plate',
      type: 'text',
    },
    {
      label: 'color',
      type: 'text',
    },
    {
      label: 'basicPrice',
      type: 'text',
    },
    {
      label: 'model',
      type: 'text',
    }
  ]

  useMemo(() => {
    fetch(url, {
        method: 'GET'
      })
      .then(v => v.json())
      .then(v => {
        if(v.error === 0 && v.status === 200)
        {
          setState({
            list: v.response,
            loading: false,
          });
        }
      })
      .catch(er => console.log(er));
  }, []);

  
  if(state.loading)
  {
    return (
      <div>
        Loading...
      </div>
    )
  }else{
    return (
      <div>
          <Routes>
            <Route path={``} element={
                <List label={'Cars'} 
                      headers={headers} 
                      data={state.list} 
                      urlEdit={`${url}/`} 
                      urlDelete={`${url}/`} 
                      callback={refreshSite}
                    />} />
            <Route path={`/add`} element={<Form inputs={inputs} list={state.list} url={url} />} />
            <Route path={`/edit/:id`} element={<Form inputs={inputs} list={state.list} editMode={true} url={url} />} />
          </Routes>
          <div>
              <Link className="button" to='add'>Add Car</Link>
          </div>
      </div>
    );
  }
}

export default Cars;