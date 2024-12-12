import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Navigation from "./components/Navigation"; // Import the Navigation component
import DriverList from "./components/Driver/DriverList";
import DriverForm from "./components/Driver/DriverForm";
import TaxiList from "./components/Taxi/TaxiList";
import TaxiForm from "./components/Taxi/TaxiForm";
import CustomerList from "./components/Customer/CustomerList";
import CustomerForm from "./components/Customer/CustomerForm";
import TripList from "./components/Trip/TripList";
import TripForm from "./components/Trip/TripForm";

function App() {
  return (
    <Router>
      {/* Add the Navigation bar here */}
      <Navigation />
      {/* Define your routes below */}
      <Routes>
        <Route path="/" element={<h1>Welcome to the Taxi Management System</h1>} />
        <Route path="/drivers" element={<DriverList />} />
        <Route path="/drivers/add" element={<DriverForm />} />
        <Route path="/taxis" element={<TaxiList />} />
        <Route path="/taxis/add" element={<TaxiForm />} />
        <Route path="/customers" element={<CustomerList />} />
        <Route path="/customers/add" element={<CustomerForm />} />
        <Route path="/trips" element={<TripList />} />
        <Route path="/trips/add" element={<TripForm />} />
      </Routes>
    </Router>
  );
}

export default App;
