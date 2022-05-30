import React from "react";
import { Link } from 'react-router-dom';

const LinkButton = (props) => {
    //link - link
    //label - text na przycisku

    return (
        <div>
            <Link to={props.link}>{props.label}</Link>
        </div>
    );
}