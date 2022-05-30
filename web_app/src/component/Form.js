import React, { useMemo } from "react";


const CustomForm = (props) =>
{
    /*
    fields:[
        {

        },
    ]
    */
    const fields = useMemo(() => props.fiels, []);
    return (
        <form onSubmit={props.onSubmit}>
            { Array.isArray(fields) &&
                fields.forEach(f => <label>
                    {f.label}
                    <input type={f.type} name={f.name}/>
                </label>)

            }
            <input type="submit" value="Accept"/>
        </form>
    )
}