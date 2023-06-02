import axios from 'axios';
import React, { useEffect, useState } from 'react'

export default function ViewUser() {
    const [users, setUsers] = useState([]);


    useEffect(() => {
        loadUsers();
    }, []);

    const loadUsers = async () => {
        const result = await axios.get("http://localhost:8080/getallprofile");
        setUsers(result.data);
    }





    return (

        <div className='container'>
            <div className="py-4">
                <table class="table table-striped shadow table-hover table-primary border">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Phone</th>
                            <th scope="col">Email</th>
                            <th scope="col">Bio</th>
                            <th scope="col">City</th>
                            <th scope="col">Instagram Id</th>


                        </tr>
                    </thead>
                    <tbody>
                        {
                            users.map((item, index) => (
                                <tr>
                                    <th scope="row" key={index}>{index + 1}</th>
                                    <td>{item.fullname}</td>
                                    <td>{item.user.phno}</td>
                                    <td>{item.user.email}</td>
                                    <td>{item.bio}</td>
                                    <td>{item.city}</td>
                                    <td>{item.instaUserId}</td>

                                </tr>
                            ))
                        }


                    </tbody>
                </table>
            </div>
        </div>
    )
}
