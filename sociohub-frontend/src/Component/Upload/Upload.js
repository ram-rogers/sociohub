import React, { useState } from 'react'
import "../Upload/Upload.css"
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';


export default function Upload() {
    let navigate = useNavigate();
    const [owner, setOwner] = useState("")
    const [description, setDescription] = useState('');



    function refreshPage() {
        window.location.reload(false);
    }

    const handleDescriptionChange = (event) => {
        const value = event.target.value;
        setDescription(value);
    };



    const handleSubmit = async (event) => {
        event.preventDefault();

        const formData = new FormData();
        formData.append('owner', localStorage.getItem("username"));
        formData.append('desc', description);


        try {
            const response = await axios.post('http://localhost:8080/uploadpost', formData);
            console.log('Upload success:', response.data);
            toast.success("The Post has been Successfully posted")
            refreshPage();


            // Handle any additional logic after successful upload
        } catch (error) {
            console.error('Upload error:', error);
            // Handle any error during upload
        }
    };

    return (
        <div className='upload-box'>
            <div className='post-box '>
                <h3>Hello, {localStorage.getItem("username")}</h3>
                <form onSubmit={handleSubmit} className="upload-form">
                    <div className="form-group">
                        <textarea onChange={handleDescriptionChange} className="description rounded p-3" name="post_text" id="" cols="90" rows="5" placeholder="Whats on your mind?"></textarea>
                    </div>
                    <button type="submit" className='btn btn-primary m-3'>Post</button>
                </form>
            </div>
        </div>
    );
};