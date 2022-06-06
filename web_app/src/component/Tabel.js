import React, {useMemo} from "react";
import { Link } from 'react-router-dom';

const Tabel = (params) => {
    const headers = useMemo(() => Array.isArray(params.headers) ? params.headers : [] , []);
    const data = useMemo(() => params.data , []);


    console.log(data);

    if(Array.isArray(headers))
    {
        console.log(headers);
        return (
            <div className="">
                {headers.map(v => '"' + v + '" ')}
                {Array.isArray(data) && data.map(r => headers.map(v => '"' + r[v] + '" '))}
            </div>
        );
    }else{
        return (
            <div>
                Error
            </div>
        );
    }

    
}

export default Tabel;