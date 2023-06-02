import React, { useEffect, useState } from 'react'
import './Navbar.css';
import defaultavatar from "../../images/defaultavatar.png"
import photogram from "../../images/photogram.png"

import { Avatar } from '@mui/material';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';
import { toast } from 'react-toastify';


export default function Navbar() {

    const luname = localStorage.getItem("username");

    let navigate = useNavigate();


    const [user, setUser] = useState({

        id: "",
        username: "",
        email: "",
        phno: ""
    })



    useEffect(() => {
        loadUser()
    }, [])


    const loadUser = async () => {
        const result = await axios.get(`http://localhost:8080/getuserbyusername/${luname}`)
        setUser(result.data)
    }

    console.log(user.id)
    const userId = Number(user.id)
    localStorage.setItem("userId", userId);


    function logout() {
        localStorage.removeItem("username");
        localStorage.removeItem("userId")
        navigate("/login")
        toast.success("User has successfully logged out")
    }




    return (
        <div className='full-nav'>
            <div className="row nav-main ">
                <div className="col-2">
                    <div className="nav-left">
                        <img className="nav-logo" src={photogram} width="35px" alt="" />
                        {/* <p></p> */}
                        {/* <input className='nav-search ' type="text" placeholder='Search...' /> */}

                    </div>
                </div>

                <div className="col-7 nav-icons">
                    <div className="nav-tabs">
                        <Link to="/" className="fa fa-house fa-lg icons" />

                    </div>

                    <div className="nav-tabs ">
                        <Link to="/viewusers" className="fa-solid fa-users fa-lg icons" />
                    </div>

                    <div className="nav-tabs">
                        <Link to="/profile" className="fa fa-user-circle icons fa-lg" aria-hidden="true" />
                    </div>

                    <div className="nav-tabs">
                        <Link className="fa-solid fa-circle-info icons fa-lg" />
                    </div>



                </div>
                <div className="col-3 nav-right ">
                    <div className="nav-righttab d-flex justify-content-between align-items-center pt-2">
                        <div className="d-flex justify-content-between align-items-center">
                            <div className="">
                                <Avatar className='' src={defaultavatar} />
                            </div>
                            <div className="profilename px-3 text-light">
                                {user.username}

                            </div>
                        </div>

                        <div className="logout">
                            <button onClick={logout} className='btn btn-danger logo'>Logout</button>
                        </div>



                    </div>
                </div>
            </div>
        </div >);
}
