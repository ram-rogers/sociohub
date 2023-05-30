import React from 'react'
import "./Login.css"
import photogram from "../../images/photogram.png"

export default function Login() {
    return (
        <div>
            <main className="form-signin w-100 m-auto">
                <form>
                    <img className="mb-4" src={photogram} alt="logo" />
                    <h1 className="h3 mb-3 fw-normal">Please Log in</h1>

                    <div className="form-floating">
                        <input type="text" className="form-control" id="username" placeholder="username" />
                        <label for="username">Username</label>
                    </div>
                    <div className="form-floating">
                        <input type="password" className="form-control" id="floatingPassword" placeholder="Password" />
                        <label for="floatingPassword">Password</label>
                    </div>


                    <button className="w-100 btn btn-lg btn-primary" type="submit">Login</button>
                </form>
            </main>


        </div>
    )
}
