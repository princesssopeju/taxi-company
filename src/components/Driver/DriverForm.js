import React, { useState } from "react";
import { createDriver } from "../../services/driverService";

const DriverForm = () => {
  const [formData, setFormData] = useState({
    name: "",
    licenseNumber: "",
    phoneNumber: "",
    email: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await createDriver(formData);
      alert("Driver added successfully!");
    } catch (err) {
      console.error("Error creating driver:", err);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        name="name"
        placeholder="Name"
        value={formData.name}
        onChange={handleChange}
        required
      />
      <input
        type="text"
        name="licenseNumber"
        placeholder="License Number"
        value={formData.licenseNumber}
        onChange={handleChange}
        required
      />
      <input
        type="text"
        name="phoneNumber"
        placeholder="Phone Number"
        value={formData.phoneNumber}
        onChange={handleChange}
        required
      />
      <input
        type="email"
        name="email"
        placeholder="Email"
        value={formData.email}
        onChange={handleChange}
        required
      />
      <button type="submit">Add Driver</button>
    </form>
  );
};

export default DriverForm;
