import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { createCustomer } from "../../services/customerService";
import { Spinner, Form, Button, Breadcrumb, OverlayTrigger, Tooltip, Alert } from "react-bootstrap";

function CustomerForm() {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [phoneNumber, setPhoneNumber] = useState("");
  const [loading, setLoading] = useState(false);
  const [success, setSuccess] = useState(false);
  const [error, setError] = useState("");
  const navigate = useNavigate();

  // Tooltip function for accessibility
  const renderTooltip = (props) => (
    <Tooltip {...props}>This field is required</Tooltip>
  );

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError(""); // Clear previous errors
    setSuccess(false); // Reset success message

    // Client-side validation
    if (!name.trim()) {
      setError("Name is required.");
      return;
    }
    if (!email.trim() || !email.includes("@")) {
      setError("Please enter a valid email address.");
      return;
    }
    if (phoneNumber.length < 10 || isNaN(phoneNumber)) {
      setError("Phone number must be at least 10 digits and numeric.");
      return;
    }

    const customer = { name, email, phoneNumber };
    setLoading(true);

    try {
      await createCustomer(customer);
      setSuccess(true);
      setTimeout(() => {
        navigate("/customers");
      }, 2000); // Redirect after showing success message
    } catch (error) {
      console.error("Error creating customer:", error);
      setError("Failed to create customer. Please try again later.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="container mt-4">
      {/* Breadcrumb for navigation */}
      <Breadcrumb>
        <Breadcrumb.Item href="/">Home</Breadcrumb.Item>
        <Breadcrumb.Item href="/customers">Customers</Breadcrumb.Item>
        <Breadcrumb.Item active>Add Customer</Breadcrumb.Item>
      </Breadcrumb>

      <h2>Add Customer</h2>

      {/* Success and error messages */}
      {success && <Alert variant="success">Customer added successfully!</Alert>}
      {error && <Alert variant="danger">{error}</Alert>}

      <Form onSubmit={handleSubmit}>
        {/* Name field */}
        <Form.Group className="mb-3" controlId="formName">
          <Form.Label>Name</Form.Label>
          <OverlayTrigger placement="right" overlay={renderTooltip}>
            <Form.Control
              type="text"
              placeholder="Enter customer's name"
              value={name}
              onChange={(e) => setName(e.target.value)}
              required
            />
          </OverlayTrigger>
        </Form.Group>

        {/* Email field */}
        <Form.Group className="mb-3" controlId="formEmail">
          <Form.Label>Email</Form.Label>
          <OverlayTrigger placement="right" overlay={renderTooltip}>
            <Form.Control
              type="email"
              placeholder="Enter customer's email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </OverlayTrigger>
        </Form.Group>

        {/* Phone Number field */}
        <Form.Group className="mb-3" controlId="formPhoneNumber">
          <Form.Label>Phone Number</Form.Label>
          <OverlayTrigger placement="right" overlay={renderTooltip}>
            <Form.Control
              type="text"
              placeholder="Enter customer's phone number"
              value={phoneNumber}
              onChange={(e) => setPhoneNumber(e.target.value)}
              required
            />
          </OverlayTrigger>
        </Form.Group>

        {/* Submit button with loading spinner */}
        <Button type="submit" variant="primary" disabled={loading}>
          {loading ? <Spinner as="span" animation="border" size="sm" /> : "Save"}
        </Button>
      </Form>
    </div>
  );
}

export default CustomerForm;
