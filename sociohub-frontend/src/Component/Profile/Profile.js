import React, { useState } from 'react'
import "./Profile.css"
import profileimg from "../../images/profileimg.jpg"
import axios from 'axios';
import { useEffect } from 'react';

export default function Profile() {

    const [profile, setProfile] = useState({
        bio: "",
        avatar: "",
        fullname: ""
    })

    useEffect(() => {
        loadProfile()

    }, [])

    const loadProfile = async () => {
        const result = await axios.get("http://localhost:8080/getprofilebyid/4");
        setProfile(result.data);
    }






    return (
        <div className="container">
            <div className="profile-container">
                <img src="" alt="" />
                <img src={profileimg} alt="Profile Picture" className="profile-image" />
                <h1 className="profile-name">{profile.fullname}</h1>
                <p className="profile-title">{profile.bio}</p>

                <div className="profile-info">
                    <h4>About Me</h4>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis viverra ex vitae nisi tristique, eu
                        gravida tellus porttitor. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere
                        cubilia curae; Proin ac congue elit, sit amet porttitor mauris.
                    </p>
                </div>


                <div className="profile-info">
                    <h4>Contact Information</h4>
                    <p>Email: </p>
                    <p>Phone: +91 9629124694</p>
                    <p>Location: Salem, Tamilnadu</p>
                </div>

                <div className="profile-social-links">
                    <a href="#" target="_blank" rel="noopener noreferrer"><i className="fab fa-twitter"></i></a>
                    <a href="#" target="_blank" rel="noopener noreferrer"><i className="fab fa-facebook-f"></i></a>
                    <a href="#" target="_blank" rel="noopener noreferrer"><i className="fab fa-instagram"></i></a>
                    <a href="#" target="_blank" rel="noopener noreferrer"><i className="fab fa-linkedin-in"></i></a>
                </div>
            </div>
        </div>
    )
}
