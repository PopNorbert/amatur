import React from "react";
import { Link, useNavigate } from "react-router-dom";
import {RootState} from "../store"; // Import RootState for type safety
import api from "../api/axios"; // Axios instance with baseURL configured
import { useDispatch, useSelector } from "react-redux";
import { logout } from "../store";

const Header: React.FC = () => {
    const isLoggedIn = useSelector((state: RootState) => state.auth.isLoggedIn);

  const navigate = useNavigate();
  const dispatch = useDispatch();

  const handleLogout = async () => {
    try {
      await api.post("/auth/logout");
      localStorage.removeItem("token");
      dispatch(logout())
      navigate("/");
    } catch (error) {
      console.error("Error during logout:", error);
    }
  };

  return (
    <header style={styles.header}>
      <nav style={styles.nav}>
        <Link to="/" style={styles.link}>Home</Link>
        {!isLoggedIn ? (
          <>
            <Link to="/register" style={styles.link}>Register</Link>
            <Link to="/login" style={styles.link}>Login</Link>
          </>
        ) : (
          <button onClick={handleLogout} style={styles.button}>Logout</button>
        )}
      </nav>
    </header>
  );
};

const styles = {
  header: {
    padding: "10px 20px",
    backgroundColor: "#333",
    color: "#fff",
    display: "flex",
    justifyContent: "space-between",
    alignItems: "center",
  },
  nav: {
    display: "flex",
    gap: "15px",
  },
  link: {
    color: "#fff",
    textDecoration: "none",
    fontSize: "16px",
  },
  button: {
    background: "#ff5c5c",
    color: "#fff",
    border: "none",
    padding: "8px 12px",
    cursor: "pointer",
    borderRadius: "4px",
  },
};

export default Header;
