import React, { useState, useEffect } from "react";
import {
  FaFacebookF,
  FaInstagram,
  FaEnvelope,
  FaSearch,
  FaTimes,
} from "react-icons/fa";
import "../styling/viewCustomer.css";
import { Link } from "react-router-dom";
import logo from "../images/logo.png";

const ViewCustomer = () => {
  const [searchTerm, setSearchTerm] = useState("");
  const [selectedCategory, setSelectedCategory] = useState("All");
  const [customers, setCustomers] = useState([]);
  const [showPopup, setShowPopup] = useState(false);
  const [selectedCustomer, setSelectedCustomer] = useState(null);
  const [sizeDetails, setSizeDetails] = useState(null);


  useEffect(() => {
    fetch("http://localhost:8080/api/customers/all-with-categories")
      .then((res) => res.json())
      .then((data) => setCustomers(data))
      .catch((err) => console.error("Error fetching customers:", err));
  }, []);

  const filteredCustomers = customers.filter((cust) => {
    const matchesSearch = cust.phoneNumber
      ?.toLowerCase()
      .includes(searchTerm.trim().toLowerCase());
    const matchesCategory =
      selectedCategory === "All" ||
      cust.category?.toLowerCase() === selectedCategory.toLowerCase();
    return matchesSearch && matchesCategory;
  });

  const handleRowClick = (cust) => {
    setSelectedCustomer(cust);
    setShowPopup(true);

    const categoryEndpoint = cust.category.toLowerCase();
    fetch(`http://localhost:8080/api/${categoryEndpoint}/${cust.phoneNumber}`)
      .then((res) => res.json())
      .then((data) => setSizeDetails(data))
      .catch((err) => console.error("Error fetching size details:", err));
  };

  const closePopup = () => {
    setShowPopup(false);
    setSelectedCustomer(null);
    setSizeDetails(null);
  };

  return (
    <div className="page-container">
      <nav className="navbar">
        <div className="logo-section">
          <img src={logo} alt="Raanjhanaa Logo" className="logo" />
          <span className="brand-name">aanjhanaa</span>
        </div>
        <ul className="nav-links">
          <li>
            <Link to="/" className="nav-item">
              Home
            </Link>
          </li>
          <li>
            <Link to="/add-size" className="nav-item">
              Add Customer
            </Link>
          </li>
          <li>
            <Link to="/update-customer" className="nav-item">
              Update Customer
            </Link>
          </li>
          <li>
            <Link to="/view-customer" className="nav-item">
              View Customers
            </Link>
          </li>
        </ul>
      </nav>

      <div className="search-section">
        <div className="search-bar">
          <FaSearch className="search-icon" />
          <input
            type="text"
            placeholder="Search by phone number..."
            className="search-input"
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)}
          />
        </div>

        <select
          className="category-filter"
          value={selectedCategory}
          onChange={(e) => setSelectedCategory(e.target.value)}
        >
          <option value="All">All Categories</option>
          <option value="Trouser">Trouser</option>
          <option value="Sherwani">Sherwani</option>
          <option value="Kurta">Kurta</option>
          <option value="Shirt">Shirt</option>
          <option value="Coat">Coat</option>
          <option value="Waistcoat">Waist Coat</option>
        </select>
      </div>

      <div className="all-customers">
        <h2 className="table-title">Customer Size Details</h2>
        <table className="customer-table">
          <thead>
            <tr>
              <th>Phone Number</th>
              <th>Category</th>
            </tr>
          </thead>
          <tbody>
            {filteredCustomers.length > 0 ? (
              filteredCustomers.map((cust, index) => (
                <tr
                  key={index}
                  className="clickable-row"
                  onClick={() => handleRowClick(cust)}
                >
                  <td>{cust.phoneNumber}</td>
                  <td>{cust.category}</td>
                </tr>
              ))
            ) : (
              <tr>
                <td colSpan="2" className="empty-row">
                  No customers found
                </td>
              </tr>
            )}
          </tbody>
        </table>
      </div>

      {showPopup && selectedCustomer && (
        <div className="popup-overlay" onClick={closePopup}>
          <div className="popup-content" onClick={(e) => e.stopPropagation()}>
            <div className="popup-header">
              <h3>
                {selectedCustomer.category} Details for{" "}
                {selectedCustomer.phoneNumber}
              </h3>
              <FaTimes className="close-icon" onClick={closePopup} />
            </div>

            {sizeDetails ? (
              <table className="size-table">
                <thead>
                  <tr>
                    {Object.keys(sizeDetails).map((key) => (
                      <th key={key} className="size-key">
                        {key}
                      </th>
                    ))}
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    {Object.values(sizeDetails).map((value, index) => (
                      <td key={index} className="size-value">
                        {value}
                      </td>
                    ))}
                  </tr>
                </tbody>
              </table>
            ) : (
              <p>Loading size details...</p>
            )}
          </div>
        </div>
      )}

      <footer className="footer">
        <div className="footer-container">
          <div className="footer-brand">
            <h2 className="brand-name">Raanjhanaa</h2>
            <p className="tagline">Style that fits every story.</p>
          </div>

          <div className="footer-links">
            <h4>Quick Links</h4>
            <ul>
              <li>
                <Link to="/" className="nav-item">
                  Home
                </Link>
              </li>
              <li>
                <Link to="/add-size" className="nav-item">
                  Add Customer
                </Link>
              </li>
              <li>
                <Link to="/update-customer" className="nav-item">
                  Update Customer
                </Link>
              </li>
              <li>
                <Link to="/view-customer" className="nav-item">
                  View Customers
                </Link>
              </li>
            </ul>
          </div>

          <div className="footer-contact">
            <h4>Contact</h4>
            <p>Email: raanjhanaa13@gmail.com</p>
            <p>Phone: +91 734-7278272</p>
            <p>Phone: +91 98786 41457</p>
            <div className="social-icons">
              <a href="https://www.facebook.com/raanjhanaa.amritsar/">
                <FaFacebookF />
              </a>
              <a href="https://www.instagram.com/raanjhanaa_amritsar/?hl=en">
                <FaInstagram />
              </a>
              <a href="mailto:raanjhanaa13@gmail.com">
                <FaEnvelope />
              </a>
            </div>
          </div>
        </div>

        <div className="footer-bottom">
          <p>
            © {new Date().getFullYear()}{" "}
            <span className="highlight">Raanjhanaa</span>. All rights reserved.
          </p>
        </div>
      </footer>
    </div>
  );
};

export default ViewCustomer;
