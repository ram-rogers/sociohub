import React, { useState } from 'react'
import "../Upload/Upload.css"
import axios from 'axios';
import { useNavigate } from 'react-router-dom';



export default function Upload() {
    // let navigate = useNavigate();
    const [selectedFile, setSelectedFile] = useState(null);

    const handleFileChange = (event) => {
        setSelectedFile(event.target.files[0]);
    };

    const handleSubmit = async (event) => {
        event.preventDefault();

        const formData = new FormData();
        formData.append('file', selectedFile);
        formData.append('title', 'My Image');

        try {
            const response = await axios.post('http://localhost:8080/upload', formData);
            console.log('Upload success:', response.data);
            // navigate("/")
            alert("Image uploaded")
            // Handle any additional logic after successful upload
        } catch (error) {
            console.error('Upload error:', error);
            // Handle any error during upload
        }
    };

    return (
        <div className='upload-box'>
            <div className='post-box'>
                <h3>Hello, Ram</h3>
                <form onSubmit={handleSubmit} className="upload-form">
                    <div className="form-group">
                        <textarea class="description rounded p-3" name="post_text" id="" cols="90" rows="5" placeholder="Whats on your mind?"></textarea>
                        <input type="file" id="image-upload" onChange={handleFileChange} className='bg-secondary form-control post-input' />
                    </div>
                    <button type="submit" className='btn btn-primary m-3'>Post</button>
                </form>
            </div>
        </div>
    );
};