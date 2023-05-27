import Navbar from './Component/Navbar/Navbar';
import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import Layout from './Component/MainPage/Layout';
import Upload from './Component/Upload/Upload';
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';


function App() {
	return (
		<div className="App">



			<Navbar />
			<Upload />
			<Layout />
		</div>
	);
}

export default App;
