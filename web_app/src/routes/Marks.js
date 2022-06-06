import react, { useMemo, useState } from 'react';
import { Routes, Route, Link } from 'react-router-dom'; 

import List from '../component/List';
import Form from '../component/Form';

const Marks = () => 
{
  const [state, setState] = useState(
    {
      list: [],
      loading: true,
    }
  );

  const [r, sr] = useState(false);

  const refreshSite = () => { sr(!r); }

  const url = 'http://localhost:8080/mark';
  const headers = ['id', 'name', 'logoSrc'];
  const inputs = [
    {
      label: 'id',
      type: 'text',
    },
    {
      label: 'name',
      type: 'text',
    },
    {
      label: 'logoSrc',
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
                <List label={'Marks'} 
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
              <Link className="button" to='add'>Add Mark</Link>
          </div>
      </div>
    );
  }
}

export default Marks;