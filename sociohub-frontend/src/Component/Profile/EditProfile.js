import axios from 'axios';
import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'


export default function EditProfile() {


    let navigate = useNavigate();
    const [data, setData] = useState({
        about: "",
        bio: "",
        city: "",
        instaUserId: "",
        fullname: "",
        userId: ""

    })

    const { about, bio, city, instaUserId, fullname, userId } = data;


    const onInputChange = (e) => {
        setData({ ...data, [e.target.name]: e.target.value });

    }

    const onSubmit = async (e) => {
        e.preventDefault();
        await axios.post("http://localhost:8080/addprofile", data)
        navigate("/")


    }



    return (
        <div className='container mt-5'>
            <div className="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className='text-center m-1 mb-4'> Add Profile</h2>
                    <form onSubmit={(e) => onSubmit(e)}>

                        <div className="mb-3">
                            <label htmlFor="fullname" className='form-label'>Fullname</label>
                            <input type={"text"} name="fullname" value={fullname} onChange={(e) => onInputChange(e)} className='form-control' placeholder='Enter Fullname' />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="bio" className='form-label'>Bio</label>
                            <input type={"text"} value={bio} name="bio" onChange={(e) => onInputChange(e)} className='form-control' placeholder='Enter Bio' />
                        </div>

                        <div className="mb-3">
                            <label htmlFor="city" className='form-label'>City</label>
                            <input type={"text"} name="city" value={city} onChange={(e) => onInputChange(e)} className='form-control' placeholder='Enter City' />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="insta" className='form-label'>Insta Id</label>
                            <input type={"text"} name="instaUserId" value={instaUserId} onChange={(e) => onInputChange(e)} className='form-control' placeholder='Enter Insta Id' />
                        </div>


                        <div className="mb-3">
                            <input type={"text"} name='userId' onChange={(e) => onInputChange(e)} className='form-control' value={userId} />
                        </div>
                        {/* localStorage.getItem("userId") */}

                        <div className="mb-3">
                            <label htmlFor="abt" className='form-label'>About</label>
                            <textarea type={"text"} name="about" value={about} onChange={(e) => onInputChange(e)} className='form-control' placeholder='Something About you' />
                        </div>

                        <button className='btn btn-success' type='submit'>Submit</button>
                        <Link className='mx-4 btn btn-danger' to="/profile">Cancel</Link>
                        {/* <Link className='btn btn-danger mx-2' to="/">Cancel</Link> */}
                    </form>
                </div>
            </div>
        </div>
    )
}
