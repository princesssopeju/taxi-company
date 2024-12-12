import React, { useState } from 'react';
import { createTaxi } from '../../services/taxiService';


function TaxiForm() {
  const [taxi, setTaxi] = useState({
    licensePlate: '',
    model: '',
    capacity: '',
    status: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setTaxi({ ...taxi, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await createTaxi(taxi);
      alert('Taxi created successfully!');
      setTaxi({ licensePlate: '', model: '', capacity: '', status: '' });
    } catch (error) {
      alert('Failed to create taxi');
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        name="licensePlate"
        placeholder="License Plate"
        value={taxi.licensePlate}
        onChange={handleChange}
      />
      <input
        type="text"
        name="model"
        placeholder="Model"
        value={taxi.model}
        onChange={handleChange}
      />
      <input
        type="number"
        name="capacity"
        placeholder="Capacity"
        value={taxi.capacity}
        onChange={handleChange}
      />
      <select name="status" value={taxi.status} onChange={handleChange}>
        <option value="">Select Status</option>
        <option value="AVAILABLE">Available</option>
        <option value="UNAVAILABLE">Unavailable</option>
      </select>
      <button type="submit">Create Taxi</button>
    </form>
  );
}

export default TaxiForm;
