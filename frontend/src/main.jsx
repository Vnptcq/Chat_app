import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import './css/Login.css'; // Đảm bảo đường dẫn chính xác
import'./css/ProfileCard.css'
import Login from './pages/Login'; // Import component Login
import ProfileCard from'./pages/ProfileCard';


createRoot(document.getElementById('root')).render(
  <StrictMode>
    
    {/* <Login /> */}
    <ProfileCard/>

  </StrictMode>
);