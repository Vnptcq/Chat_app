import Header from "./components/Header";
import Footer from "./components/Footer";
import Login from "./pages/Login";
import { BrowserRouter as Router, Routes, Route, useLocation } from "react-router-dom";
import LayoutGuest from "./components/Layout/LayoutGuest";


function App() {
    return (
        <>
        <Routes>
            <Route path="/" element={<LayoutGuest/>}>
                <Route path="login" element={<Login/>}/>
            </Route>
        </Routes>            
        </>
    );
}

export default App;
