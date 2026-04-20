import React, { useState, useEffect } from "react";
import {
  FaFacebookF,
  FaInstagram,
  FaEnvelope,
  FaSearch,
  FaSpinner,
} from "react-icons/fa";
import "../styling/viewCustomer.css";
import { Link } from "react-router-dom";
import logo from "../images/logo.png";


const ViewCustomer = () => {
  const renderStars = (value) => {
  if (typeof value === "number" && value > 0 && value <= 3) {
    return "★".repeat(value); // or include empty stars if you want
  }
  return value;
};
  const [searchTerm, setSearchTerm] = useState("");
  const [selectedCategory, setSelectedCategory] = useState("All");
  const [customers, setCustomers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [expandedRows, setExpandedRows] = useState({});
  const [sizeCache, setSizeCache] = useState({});

  const BASE_URL = "https://raanjhana-backend.onrender.com";


  useEffect(() => {
    setLoading(true);
    fetch(`${BASE_URL}/api/customers/all-with-categories`)
      .then((res) => res.json())
      .then((data) => {
        setCustomers(Array.isArray(data) ? data : []);
        setLoading(false);
      })
      .catch((err) => {
        console.error("Error fetching customers:", err);
        setLoading(false);
      });
  }, []);

  const filteredCustomers = Array.isArray(customers)
    ? customers.filter((cust) => {
        const search = searchTerm.trim().toLowerCase();

        const matchesSearch =
          cust.phoneNumber?.toLowerCase().includes(search) ||
          cust.name?.toLowerCase().includes(search);

        const matchesCategory =
          selectedCategory === "All" ||
          cust.category?.toLowerCase() === selectedCategory.toLowerCase();

        return matchesSearch && matchesCategory;
      })
    : [];
 const displayedCustomers = filteredCustomers;

  const handleRowClick = (cust) => {
    const key = cust.phoneNumber + cust.category;

    if (expandedRows[key]) {
      setExpandedRows((prev) => ({ ...prev, [key]: false }));
      return;
    }

    setExpandedRows((prev) => ({ ...prev, [key]: true }));

    if (!sizeCache[key]) {
      const endpoint = `${BASE_URL}/api/sizes/${cust.category.toLowerCase()}/${cust.phoneNumber}`;
      fetch(endpoint)
        .then((res) => res.json())
        .then((data) => {
          setSizeCache((prev) => ({ ...prev, [key]: data }));
        })
        .catch((err) =>
          console.error("Error fetching size details:", err)
        );
    }
  };

  return (
    <div className="page-container">
      {/* Navbar */}
      <nav className="navbar">
        <div className="logo-section">
          <img src={logo} alt="Raanjhanaa Logo" className="logo" />
          <span className="brand-name">aanjhanaa</span>
        </div>
        <ul className="nav-links">
          <li><Link to="/" className="nav-item">Home</Link></li>
          <li><Link to="/add-size" className="nav-item">Add Customer</Link></li>
          <li><Link to="/update-customer" className="nav-item">Update Customer</Link></li>
          <li><Link to="/view-customer" className="nav-item">View Customers</Link></li>
        </ul>
      </nav>

      {/* Search */}
      <div className="search-section">
        <div className="search-bar">
          <FaSearch className="search-icon" />
          <input
            type="text"
            placeholder="Search by name or phone..."
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

      {/* Table */}
      <div className="all-customers">
        <h2 className="table-title">Customer Size Details</h2>



        {loading ? (
          <div className="loading-container">
            <FaSpinner className="spinner" /> Loading customers...
          </div>
        ) : displayedCustomers.length > 0 ? (
          <div className="scroll-container">
          <table className="customer-table">
            <thead>
              <tr>
                <th>Name</th>
                <th>Phone Number</th>
                <th>Category</th>
              </tr>
            </thead>

            <tbody>
              {displayedCustomers.map((cust, index) => {
                const key = cust.phoneNumber + cust.category;

                return (
                  <React.Fragment key={index}>
                    <tr
                      className="clickable-row"
                      onClick={() => handleRowClick(cust)}
                    >
                      <td>{cust.name}</td>
                      <td>{cust.phoneNumber}</td>
                      <td>{cust.category}</td>
                    </tr>

                    {expandedRows[key] && sizeCache[key] && (
                      <tr>
                        <td colSpan="3">
                          <div className="size-wrapper">
                          <table className="inner-size-table">
  <tbody>
    {Object.entries(sizeCache[key]).map(([k, v]) => (
      <tr key={k}>
        <td className="label">{k.toUpperCase()}</td>
        <td className="value">
         {v === null || v === "" ? "-" : v === 0 ? "0" : renderStars(v)}
        </td>
      </tr>
    ))}
  </tbody>
</table>
</div>
                        </td>
                      </tr>
                    )}
                  </React.Fragment>
                );
              })}
            </tbody>
          </table>
          </div>
        ) : (
          <p className="empty-row">No customers found.</p>
        )}
        
      </div>

      {/* Footer (UNCHANGED) */}
      <footer className="footer">
        <div className="footer-container">
          <div className="footer-brand">
            <h2 className="brand-name">Raanjhanaa</h2>
            <p className="tagline">Style that fits every story.</p>
          </div>

          <div className="footer-links">
            <h4>Quick Links</h4>
            <ul>
              <li><Link to="/" className="nav-item">Home</Link></li>
              <li><Link to="/add-size" className="nav-item">Add Customer</Link></li>
              <li><Link to="/update-customer" className="nav-item">Update Customer</Link></li>
              <li><Link to="/view-customer" className="nav-item">View Customers</Link></li>
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
                           <a href="mailto:raanjhanaa@gmail.com">
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