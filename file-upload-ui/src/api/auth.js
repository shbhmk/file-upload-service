import axios from "axios";

const API_URL = "http://localhost:8080/api/auth";

export const registerUser = async (userData) => {
  try {
    const response = await axios.post(`http://localhost:8080/api/users`, userData);
    return response.data;
  } catch (error) {
    throw error.response?.data || "An error occurred";
  }
};

export const loginUser = async (credentials) => {
  try {
    const response = await axios.post(`http://localhost:8080/api/users`, credentials);
    return response.data;
  } catch (error) {
    throw error.response?.data || "An error occurred";
  }
};
