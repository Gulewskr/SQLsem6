import React from "react";
import { Link } from 'react-router-dom';

const Header = () => {
    return (
        <div>
            Car Rent App
            <nav>
                <Link to='/AdminPanel'></Link>
                <Link to='/Cars'></Link>
                <Link to='/Marks'></Link>
                <Link to='/Models'></Link>
                <Link to='/Equipement'></Link>
                <Link to='/Clients'></Link>
                <Link to='/Hire'></Link>
            </nav>
        </div>
    );
}

export default Header;