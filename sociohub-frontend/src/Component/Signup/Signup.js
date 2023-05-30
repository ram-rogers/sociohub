import React, { useState } from 'react'
import photogram from "../../images/photogram.png"
import { signup } from '../../services/UserService';
import { toast } from 'react-toastify';
import { useNavigate } from 'react-router-dom';

export default function Signup() {

    let navigate = useNavigate();

    const [data, setData] = useState({
        username: "",
        email: "",
        phno: "",
        password: ""

    })

    const { username, email, phno, password } = data;


    const onInputChange = (e) => {
        setData({ ...data, [e.target.name]: e.target.value });

    }

    const onSubmit = (e) => {
        e.preventDefault();
        console.log(data);

        signup(data).then((resp) => {
            console.log(resp);
            console.log("Success log");
            toast.success("User is Registered Successfully " + resp.id)
            setData({
                username: "",
                email: "",
                phno: "",
                password: ""

            })
            navigate("/login")
        }).catch((error) => {
            console.log(error);
            console.log("error log");
        })



    }



    return (
        <div>


            <main className="form-signin w-100 m-auto">
                <form onSubmit={(e) => onSubmit(e)}>
                    <img className="mb-4" src={photogram} alt="logo" />
                    <h1 className="h3 mb-3 fw-normal">Please Sign in</h1>

                    <div className="form-floating">
                        <input type="text" name='username' className="form-control" id="username" placeholder="username" value={username} onChange={(e) => onInputChange(e)} />
                        <label for="username">Username</label>
                    </div>

                    <div className="form-floating">
                        <input type="tel" className="form-control" name='phno' id="phno" placeholder="Phone" onChange={(e) => onInputChange(e)} value={phno} />
                        <label for="phone">Phone</label>
                    </div>

                    <div className="form-floating">
                        <input type="email" className="form-control" name='email' id="email" placeholder="Email" onChange={(e) => onInputChange(e)} value={email} />
                        <label for="email">Email</label>
                    </div>

                    <div className="form-floating">
                        <input type="password" className="form-control" name='password' id="floatingPassword" placeholder="Password" onChange={(e) => onInputChange(e)} value={password} />
                        <label for="floatingPassword">Password</label>
                    </div>


                    <button className="w-100 btn btn-lg btn-primary" type="submit">Sign up</button>
                </form>
            </main>
        </div>
    )
}
