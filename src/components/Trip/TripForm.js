import React, { useState } from 'react';
import { createTrip } from '../../services/tripService';



function TripForm() {
  const [trip, setTrip] = useState({
    customerId: '',
    taxiId: '',
    date: '',
    destination: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setTrip({ ...trip, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await createTrip(trip);
      alert('Trip created successfully!');
      setTrip({ customerId: '', taxiId: '', date: '', destination: '' });
    } catch (error) {
      alert('Failed to create trip');
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        name="customerId"
        placeholder="Customer ID"
        value={trip.customerId}
        onChange={handleChange}
      />
      <input
        type="text"
        name="taxiId"
        placeholder="Taxi ID"
        value={trip.taxiId}
        onChange={handleChange}
      />
      <input
        type="date"
        name="date"
        placeholder="Date"
        value={trip.date}
        onChange={handleChange}
      />
      <input
        type="text"
        name="destination"
        placeholder="Destination"
        value={trip.destination}
        onChange={handleChange}
      />
      <button type="submit">Create Trip</button>
    </form>
  );
}

export default TripForm;
