import React, { useMemo, useState } from "react";
import { useParams } from 'react-router-dom'; 


const Form = (props) =>
{

    let { id } = useParams();

    const getData = () => {
        if(   Array.isArray(props.list) )
        {
            let tmp = {};
            props.list.forEach((v , i) => {
                if(v['id'] == id) tmp = v;
            });
            return tmp;
        }
        return {};
    }

    const [state, setState] = useState(
        {
            inputs: props.inputs,
            list: props.list,
            data: getData(),
            url: props.url,
            loading: true,
        }
    );

    //console.log(state.inputs);

    const onSubmitPost = (event) => {
        event.preventDefault();

        let body = {};

        Object.keys(state.data).forEach(v => 
        {
            if(v !== 'id')
            {
                body[v] = state.data[v];
            }
        })

        const json = fetch(state.url, {
                method: 'POST',
                body: JSON.stringify(body),
                headers: {
                    'Content-Type': 'application/json'
                }
            })
            .then(v => v.json())
            .catch(er => console.log(er));
        //console.log(json);
    }

    const onSubmitPut = (event) => {
        event.preventDefault();

        let body = {};

        Object.keys(state.data).forEach(v => 
        {
            if(v !== 'id')
            {
                body[v] = state.data[v];
            }
        })

        const json = fetch(`${state.url}/${state.data['id']}`, {
                method: 'PUT',
                body: JSON.stringify(body),
                headers: {
                    'Content-Type': 'application/json'
                }
            })
            .then(v => v.json())
            .catch(er => console.log(er));
        //console.log(json);
    }
    
    
    return (
        <form onSubmit={props.editMode ? onSubmitPut : onSubmitPost}>
            { Array.isArray(state.inputs) &&
                state.inputs.map( (v) => 
                (
                <label>
                    {v.label}
                    <input className="input is-info" type={v.type} value={state.data[v.label]} 
                    onChange={(e) => 
                        { 
                            let data = state.data;
                            data[v.label] = e.target.value;
                            setState(
                                {
                                    inputs: state.inputs,
                                    data: data,
                                    url: state.url,
                                    loading: false,
                                }
                            )
                        }
                    } 
                    placeholder="v"></input>
                </label>
                ))
            }
            <input type="submit" value="Accept"/>
        </form>
    )
}

export default Form;