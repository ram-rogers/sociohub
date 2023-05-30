import React, { Component } from 'react'
import './Navbar.css';
import photogram from "../../images/photogram.png"
import { Avatar } from '@mui/material';
import { Link } from 'react-router-dom';


class Navbar extends Component {


    render() {
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
                            <Link to="/" class="fa fa-house fa-lg icons" />

                        </div>

                        <div className="nav-tabs ">
                            <Link class="fa-solid fa-magnifying-glass fa-lg icons" />
                        </div>

                        <div className="nav-tabs">
                            <Link to="/profile" class="fa fa-user-circle icons fa-lg" aria-hidden="true" />
                        </div>

                        <div className="nav-tabs">
                            <Link class="fa-solid fa-circle-info icons fa-lg" />
                        </div>



                    </div>
                    <div className="col-3 nav-right ">
                        <div className="nav-righttab d-flex justify-content-between align-items-center pt-2">
                            <div className="d-flex justify-content-between align-items-center">
                                <div className="">
                                    <Avatar className='' src='https://filmfare.wwmindia.com/content/2021/jun/vijay41624255649.jpg' />
                                </div>
                                <div className="profilename px-3">
                                    Ram
                                </div>
                            </div>
                            <div className="nav-tabs"><i class="fa-solid fa-plus fa-lg"></i></div>
                            <div className=""><i class="fa-brands fa-rocketchat fa-lg"></i></div>

                            <div className="logout">
                                <button className='btn btn-danger logo'>Logout</button>
                            </div>



                        </div>
                    </div>
                </div>
            </div >);
    }
}

export default Navbar;