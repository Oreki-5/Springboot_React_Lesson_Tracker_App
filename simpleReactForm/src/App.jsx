import "./App.css";
import Navbar from "./Components/Navbar";
import { Route, Routes } from "react-router-dom";
import { RegisterPage } from "./CommonPages/RegisterPage";
import { LoginPage } from "./CommonPages/LoginPage";
import DashboardPage from "./CommonPages/DashboardPage";
import UserListPage from "./AdminPages/UserListPage/UserListPage";

function App() {
  return (
    <>
      <Navbar />
      <Routes>
        <Route path="/" element={<LoginPage />} />
        <Route path="/register" element={<RegisterPage />} />
        <Route path="/dashboard" element={<DashboardPage />} />
        <Route path="/list" element={<UserListPage />} />
      </Routes>
    </>
  );
}

export default App;
