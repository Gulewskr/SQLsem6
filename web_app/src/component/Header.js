import React from "react";
import { Link } from 'react-router-dom';

const Header = (props) => {
    //state={state} setState={setState}

    const logout = () => {
        props.setState({
            login: '',
            type: 0,
        })
    }

    return (
        <div>
            <nav className="navbar" role="navigation">
                <div className="navbar-start">
                    <Link className="navbar-item" to='/'>CarRent</Link>
                    { props.state.type === 0 ||
                        <>
                            <Link className="navbar-item" to='/Cars'>Cars</Link>
                            <Link className="navbar-item" to='/Marks'>Marks</Link>
                            <Link className="navbar-item" to='/Models'>Models</Link>
                            <Link className="navbar-item" to='/Equipement'>Equipement</Link>
                            <Link className="navbar-item" to='/Clients'>Clients</Link>
                            <Link className="navbar-item" to='/Hire'>Hire</Link>
                        </>
                    }
                    {props.state.type === 2 && <Link className="navbar-item" to='/AdminPanel'>Admin</Link>}
                    {props.state.type === 0 && <Link className="navbar-item" to='/Login'>Login</Link> }
                    {props.state.type === 0 || 
                    <>
                        <div className="navbar-item">Account: {props.state.login}</div>
                        <div className="navbar-item" onClick={logout}>Logout</div>
                    </> }
                </div>
            </nav>
        </div>
    );
}

export default Header;