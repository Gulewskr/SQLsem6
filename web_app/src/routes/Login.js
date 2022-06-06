import react, { useState } from 'react';

const Login = (props) => 
{

    const [login, setLogin] = useState('');

    const loginfunc = () => {
        const type = login === 'Admin' ? 2 : 1;
        props.setState({
            login: login,
            type: type
        })  
    }

  return (
      <div>
        <div>
            Login Page 
        </div>
        <div>
            <form onSubmit={loginfunc}>
                <label>
                    Login
                    <input className="input is-info" type='text' value={login} onChange={e => setLogin(e.target.value)} />
                 </label>
                 <label>
                    Password
                    <input className="input is-info" type='text' />
                 </label>
                <input type="submit" value="Accept"/>
            </form>
        </div>
      </div>
  );
}

export default Login;