import React, { useState } from 'react'
import "./Profile.css"
import defaultavatar from "../../images/defaultavatar.png"
import axios from 'axios';
import { useEffect } from 'react';
import { Link } from 'react-router-dom';

export default function Profile() {

    const luname = localStorage.getItem("username")
    const [profile, setProfile] = useState([])

    const userId = localStorage.getItem("userId");

    const insta = "https://www.instagram.com/"

    useEffect(() => {
        const fetchData = async () => {
            const data = await axios.get(`http://localhost:8080/getprofilebyuserid/${userId}`);
            setProfile(data.data);
            console.log(data.data);
        }
        fetchData();

    }, [])




    return (
        <div className="container">
            <div className="profile-container">
                <div className='d-flex justify-content-end'>
                    <Link to="/editprofile" className='btn btn-info '>Edit</Link>


                </div>



                <img src={defaultavatar} alt="Profile Picture" className="profile-image" />
                <h1 className="profile-name">{profile.map(prof => (prof.fullname))
                }</h1>
                <p className="profile-title">{profile.map(prof => (prof.bio))}</p>

                <div className="profile-info">
                    <h4>About Me</h4>
                    <p>
                        {profile.map(prof => (prof.about))}
                    </p>
                </div>


                <div className="profile-info">
                    <h4>Contact Information</h4>
                    <p>Email: {profile.map(prof => (prof.user.email))}</p>
                    <p>Phone: +91 {profile.map(prof => (prof.user.phno))}</p>
                    <p>City: {profile.map(prof => (prof.city))}</p>
                    {profile.map(prof => (prof.insta_user_id))}
                </div>

                <div className="profile-social-links">
                    <a target="_blank" href={insta + profile.map(prof => (prof.instaUserId))}><i className="fab fa-instagram"></i></a>
                    <a href="#" target="_blank" rel="noopener noreferrer"><i className="fab fa-facebook-f"></i></a>
                    <a href="#" target="_blank" rel="noopener noreferrer"><i className=" fab fa-twitter"></i></a>
                    <a href="#" target="_blank" rel="noopener noreferrer"><i className="fab fa-linkedin-in"></i></a>
                </div>
            </div>
        </div >
    )
}
