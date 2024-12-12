import React, { useEffect, useState } from 'react';
import { fetchTaxis } from '../../services/taxiService';


function TaxiList() {
  const [taxis, setTaxis] = useState([]);

  useEffect(() => {
    fetchTaxis()
      .then((data) => setTaxis(data))
      .catch((error) => console.error('Error:', error));
  }, []);

  return (
    <div>
      <h2>Taxi List</h2>
      <ul>
        {taxis.map((taxi) => (
          <li key={taxi.id}>
            {taxi.licensePlate} - {taxi.model} - {taxi.status}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default TaxiList;
