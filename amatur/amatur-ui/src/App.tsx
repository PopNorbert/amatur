import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Dashboard from "./pages/Dashboard";
import ProtectedRoute from "./components/ProtectedRoute";
import ContestDetailsPage from "./pages/ContestDetailsPage";
import UserDetailsPage from "./pages/UserDetailsPage";
import Layout from "./pages/Header";

const App: React.FC = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/contest/:id" element={<ContestDetailsPage />} />
          <Route path="/user/:id" element={<UserDetailsPage/>} />
          <Route path="/" element={<Dashboard />}/>
        </Route>
      </Routes>
    </Router>
  );
};

export default App;
