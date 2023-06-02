import React, { useEffect, useRef, useState } from 'react'
import "./Login.css"
import photogram from "../../images/photogram.png"
import { Link, useNavigate } from 'react-router-dom'
import { login } from '../../services/loginService'
import { toast } from 'react-toastify'


export default function Login() {

    let navigate = useNavigate();

    const [user, setuser] = useState({
        username: "",
        password: ""

    })

    const { username, password } = user;


    const onInputChange = (e) => {
        setuser({ ...user, [e.target.name]: e.target.value });

    }

    const onSubmit = (e) => {
        e.preventDefault();
        console.log(user);

        login(user).then((resp) => {
            console.log(resp);
            if (resp == "Login successful!") {
                console.log("Success log");
                toast.success("User Logged in  Successfully ")
                setuser({
                    username: "",
                    password: ""

                })
                navigate("/")
            }
            else {

                console.log("error log");
                toast.error("Login failed")
            }

        })



    }



    const data = useRef();
    const handleClick = () => {

        console.log(data.current.value);

        localStorage.setItem("username", data.current.value);
    }

    let luname = localStorage.getItem("username")
    console.log(luname);



    return (
        <div>
            <main className="form-signin w-100 m-auto">
                <form onSubmit={(e) => onSubmit(e)}>
                    <img className="mb-4" src={photogram} alt="logo" />
                    <h1 className="h3 mb-3 fw-normal">Please Log in</h1>

                    <div className="form-floating">
                        <input type="text" name='username' className="form-control" value={username} onChange={(e) => onInputChange(e)} placeholder="username" ref={data} />
                        <label htmlFor="username">Username</label>
                    </div>
                    <div className="form-floating">
                        <input type="password" name='password' value={password} onChange={(e) => onInputChange(e)} className="form-control" placeholder="Password" />
                        <label htmlFor="floatingPassword">Password</label>
                    </div>


                    <button onClick={handleClick} className="w-100 btn btn-lg btn-primary mb-4" type="submit">Login</button>

                    <Link to="/signup" className='mt-3'>Not have an acount click here</Link>
                </form>
            </main>


        </div>
    )
}
