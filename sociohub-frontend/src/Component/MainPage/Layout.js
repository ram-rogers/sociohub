import React, { Component, useEffect, useState } from 'react'
import "./MainPage.css";
import "../Navbar/Navbar.css"
import axios from 'axios';


export default function Layout() {


    const [posts, setPost] = useState([]);



    useEffect(() => {
        loadPosts();
    }, []);

    const loadPosts = async () => {
        const result = await axios.get("http://localhost:8080/getpost");
        setPost(result.data);
    }
    console.log(posts.data);

    return (

        <div className='mp-container p-4'>

            <div className="post-items mx-5 mb-5">
                <div className="row">

                    {
                        posts.map((post, index) => (

                            < div className="col-6 mb-3" >
                                <div className="card card-size shadow-sm bg-dark text-light">

                                    <div className="card-body">
                                        <p className="card-text my-5">{post.description}</p>
                                        <div className="d-flex justify-content-between align-items-center">
                                            <div className="">
                                                <button type="button" className="btn btn-sm btn-primary mx-2">  Like</button>
                                                <button type="button" className="btn btn-sm btn-danger">  Dislike</button>

                                            </div>
                                            <small className="text-body-secondary">posted on {post.dateTime.slice(0, 10)} by {post.owner}</small>

                                        </div>
                                    </div>
                                </div>
                            </div>


                        ))
                    }








                </div>




            </div>
        </div >




    );

}

