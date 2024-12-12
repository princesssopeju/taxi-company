const API_BASE_URL = 'http://localhost:8080/api/taxis';

// Fetch all taxis
export const fetchTaxis = async () => {
  try {
    const response = await fetch(API_BASE_URL);
    if (!response.ok) {
      throw new Error('Failed to fetch taxis');
    }
    return await response.json();
  } catch (error) {
    console.error('Error:', error);
    throw error;
  }
};

// Create a new taxi
export const createTaxi = async (taxi) => {
  try {
    const response = await fetch(`${API_BASE_URL}/create`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(taxi),
    });
    if (!response.ok) {
      throw new Error('Failed to create taxi');
    }
    return await response.json();
  } catch (error) {
    console.error('Error:', error);
    throw error;
  }
};

// Fetch taxi by ID
export const fetchTaxiById = async (id) => {
  try {
    const response = await fetch(`${API_BASE_URL}/${id}`);
    if (!response.ok) {
      throw new Error('Failed to fetch taxi');
    }
    return await response.json();
  } catch (error) {
    console.error('Error:', error);
    throw error;
  }
};

// Update a taxi
export const updateTaxi = async (id, taxi) => {
  try {
    const response = await fetch(`${API_BASE_URL}/${id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(taxi),
    });
    if (!response.ok) {
      throw new Error('Failed to update taxi');
    }
    return await response.json();
  } catch (error) {
    console.error('Error:', error);
    throw error;
  }
};

// Delete a taxi
export const deleteTaxi = async (id) => {
  try {
    const response = await fetch(`${API_BASE_URL}/${id}`, {
      method: 'DELETE',
    });
    if (!response.ok) {
      throw new Error('Failed to delete taxi');
    }
    return await response.json();
  } catch (error) {
    console.error('Error:', error);
    throw error;
  }
};
