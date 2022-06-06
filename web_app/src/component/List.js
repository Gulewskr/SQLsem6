import React, {useMemo} from "react";
import { Link } from 'react-router-dom';

import Tabel from './Tabel';

const List = (params) => {
    const label = useMemo(() => params.label , []);
    const data = useMemo(() => params.data ? params.data : [] , []);
    const headers = useMemo(() => data[0] ? Object.keys(data[0]) : [], []);

    //console.log(data);

    const deleteHandler = (i) =>
    {
        fetch(`${params.urlDelete}${i}`, {
            method: 'DELETE'
        })
        .then(v => v.json())
        //.then(() => params.callback())
        .catch(er => console.log(er));
    }

    return(
        <div>
            <div>{label}</div> 
            <div className="container is-widescreen">
                <table className="container table">
                    <thead>
                        <tr>
                        {headers.map(v => <th key={v}>{v}</th>)}
                        <th key={'edit'}></th>
                        <th key={'delete'}></th>
                        </tr>
                    </thead>
                    <tbody>
                        {data && data.map((r, i) => 
                        <tr key={`row-${i}`}>
                            {headers.map(v => <td  key={v}>{r[v]}</td>)}
                            <td key={'edit'}><Link className="button" to={`edit/${r['id']}`}>Edit</Link></td>
                            <td key={'delete'}><button className="button" onClick={() => deleteHandler(r['id'])}>DELETE</button></td>
                        </tr>)}
                    </tbody>
                </table>
            </div>
        </div>
    )    
}

export default List;