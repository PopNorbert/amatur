import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import ContestList from "./components/ContestList";  // A new component for listing contests
import ContestDetails from "./components/ContestDetails";  // A new component for contest details
import PlayerDetails from "./components/PlayerDetails";  // A new component for player details

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<ContestList />} />
        <Route path="/contest/:id" element={<ContestDetails />} />
        <Route path="/player/:id" element={<PlayerDetails />} />
      </Routes>
    </Router>
  );
}

export default App;
