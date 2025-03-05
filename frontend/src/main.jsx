import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import './css/Login.css'; // Đảm bảo đường dẫn chính xác
import Login from './pages/Login'; // Import component Login

createRoot(document.getElementById('root')).render(
  <StrictMode>
    
    <Login />
  </StrictMode>
);