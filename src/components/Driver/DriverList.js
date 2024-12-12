import React, { useState, useEffect } from "react";
import { fetchDrivers } from '../../services/driverService';


const DriverList = () => {
  const [drivers, setDrivers] = useState([]);

 useEffect(() => {
   const fetchData = async () => {
     const data = await fetchDrivers(); // Replace getDrivers with fetchDrivers
     setDrivers(data);
   };
   fetchData();
 }, []);

  return (
    <div>
      <h2>Drivers</h2>
      <ul>
        {drivers.map((driver) => (
          <li key={driver.driverId}>
            {driver.name} - {driver.email}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default DriverList;
