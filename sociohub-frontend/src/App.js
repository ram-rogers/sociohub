import Navbar from './Component/Navbar/Navbar';
import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import Upload from './Component/Upload/Upload';
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import Layout from './Component/MainPage/Layout';
import Profile from './Component/Profile/Profile';
import Login from './Component/Login/Login';
import Signup from './Component/Signup/Signup';
import 'react-toastify/dist/ReactToastify.css';
import { ToastContainer, toast } from 'react-toastify';


function App() {
	return (
		<div className="App">
			<Router>

				<ToastContainer />

				<Routes>
					<Route exact path="/login" element={<Login />} />
					<Route exact path="/signup" element={<Signup />} />
					<Route exact path="/" element={<><Navbar /><Upload /><Layout /></>} />
					<Route exact path="/upload" element={<Upload />} />
					<Route exact path="/profile" element={<Profile />} />
					{/* <Route path="/" element={((<Upload />), (<Layout />))} /> */}
				</Routes>




			</Router>



		</div >
	);
}

export default App;
