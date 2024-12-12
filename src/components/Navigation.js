import React from "react";
import { Navbar, Nav } from "react-bootstrap";
import { Link } from "react-router-dom";

const Navigation = () => {
  return (
    <Navbar bg="dark" variant="dark" expand="lg">
      <Navbar.Brand as={Link} to="/">Taxi Management</Navbar.Brand>
      <Nav className="ml-auto">
        <Nav.Link as={Link} to="/drivers">Drivers</Nav.Link>
        <Nav.Link as={Link} to="/taxis">Taxis</Nav.Link>
        <Nav.Link as={Link} to="/customers">Customers</Nav.Link>
        <Nav.Link as={Link} to="/trips">Trips</Nav.Link>
      </Nav>
    </Navbar>
  );
};

export default Navigation;
