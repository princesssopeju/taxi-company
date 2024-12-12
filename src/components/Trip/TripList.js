import React, { useEffect, useState } from 'react';
import { fetchTrips } from '../../services/tripService';


function TripList() {
  const [trips, setTrips] = useState([]);

  useEffect(() => {
    fetchTrips()
      .then((data) => setTrips(data))
      .catch((error) => console.error('Error:', error));
  }, []);

  return (
    <div>
      <h2>Trip List</h2>
      <ul>
        {trips.map((trip) => (
          <li key={trip.id}>
            {trip.customer.name} - {trip.taxi.licensePlate} - {trip.date}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default TripList;
