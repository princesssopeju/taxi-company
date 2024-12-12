import React, { useEffect, useState } from 'react';
import { fetchCustomers, deleteCustomer } from '../../services/customerService';
import { useNavigate } from 'react-router-dom';

function CustomerList() {
  const [customers, setCustomers] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    fetchCustomers()
      .then((data) => setCustomers(data))
      .catch((error) => console.error('Error:', error));
  }, []);

  const handleDelete = (id) => {
    if (window.confirm('Are you sure you want to delete this customer?')) {
      deleteCustomer(id)
        .then(() => {
          setCustomers(customers.filter((customer) => customer.id !== id));
        })
        .catch((error) => console.error('Error deleting customer:', error));
    }
  };

  return (
    <div>
      <h2>Customer List</h2>
      <button onClick={() => navigate('/customers/new')}>Add Customer</button>
      <table className="table">
        <thead>
          <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Phone Number</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {customers.map((customer) => (
            <tr key={customer.customerID}>
              <td>{customer.name}</td>
              <td>{customer.email}</td>
              <td>{customer.phoneNumber}</td>
              <td>
                <button onClick={() => navigate(`/customers/edit/${customer.customerID}`)}>Edit</button>
                <button onClick={() => handleDelete(customer.customerID)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default CustomerList;
