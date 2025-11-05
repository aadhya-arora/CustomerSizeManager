import React, { useState } from "react";
import "../styling/addCustomer.css";
import { Link } from "react-router-dom";
import logo from "../images/logo.png";
import { FaFacebookF, FaInstagram, FaEnvelope } from "react-icons/fa";

const UpdateCustomer = () => {
  const [phone, setPhone] = useState("");
  const [category, setCategory] = useState("");
  const [trouserType, setTrouserType] = useState("");
  const [formData, setFormData] = useState({});

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Updated Data:", { phone, category, trouserType, ...formData });
    alert("Customer size updated successfully!");
  };

  return (
    <div>
        <nav className="navbar">
                <div className="logo-section">
                  <img src={logo} alt="Raanjhana Logo" className="logo" />
                  <span className="brand-name">aanjhanaa</span>
                </div>
                <ul className="nav-links">
                  <li>
                     <Link to="/" className="nav-item">Home</Link>
                  </li>
                  <li>
                     <Link to="/add-size" className="nav-item">Add Customer</Link>
                  </li>
                  <li>
                    <Link to="/update-customer" className="nav-item">Update Customer</Link>
                </li>
                  <li>
                    <Link to="/view-customer" className="nav-item">
                View Customers
                </Link>
                  </li>
                  <li>Search</li>
                </ul>
              </nav>
    
    <div className="add-size-container">
      <h2>Update Customer Size</h2>

      <form className="add-size-form" onSubmit={handleSubmit}>
        <label>Phone Number</label>
        <input
          type="text"
          placeholder="Enter customer's phone number"
          value={phone}
          onChange={(e) => setPhone(e.target.value)}
          required
        />

        <label>Category</label>
        <select
          value={category}
          onChange={(e) => setCategory(e.target.value)}
          required
        >
          <option value="">Select Category</option>
          <option value="Trouser">Trouser</option>
          <option value="Sherwani">Sherwani</option>
          <option value="Kurta">Kurta</option>
          <option value="Shirt">Shirt</option>
          <option value="Coat">Coat</option>
          <option value="WaistCoat">Waist Coat</option>
        </select>

        {category === "Trouser" && (
          <div className="category-section">
            <h3>Trouser Details</h3>
            <label className="trouser-fields">Trouser Type</label>
            <select
              value={trouserType}
              onChange={(e) => setTrouserType(e.target.value)}
              required
            >
              <option value="">Select Type</option>
              <option value="With Pleats">With Pleats</option>
              <option value="Without Pleats">Without Pleats</option>
            </select>

            <div className="trouser-grid">
              {["length", "waist", "IL", "hips", "thigh", "R", "knee", "calf", "bottom"].map(
                (field) => (
                  <div key={field}>
                    <label>{field}</label>
                    <input
                      type="text"
                      name={field}
                      value={formData[field] || ""}
                      onChange={handleChange}
                    />
                  </div>
                )
              )}
            </div>
          </div>
        )}

        {["Sherwani", "Kurta", "Shirt", "Coat"].includes(category) && (
          <div className="category-section">
            <h3>{category} Details</h3>
            <div className="trouser-grid">
              {[
                "length",
                "chest",
                "gap",
                "waist",
                "hips",
                "shoulder",
                "sleeve",
                "bicep",
                "elbow",
                "cuff",
                "cb",
                "neck",
              ].map((field) => (
                <div key={field}>
                  <label>{field}</label>
                  <input
                    type="text"
                    name={field}
                    value={formData[field] || ""}
                    onChange={handleChange}
                  />
                </div>
              ))}
            </div>
          </div>
        )}

        {category === "WaistCoat" && (
          <div className="category-section">
            <h3>Waist Coat Details</h3>
            <div className="trouser-grid">
              {[
                "length",
                "chest",
                "gap",
                "waist",
                "hips",
                "shoulder",
                "neck",
              ].map((field) => (
                <div key={field}>
                  <label>{field}</label>
                  <input
                    type="text"
                    name={field}
                    value={formData[field] || ""}
                    onChange={handleChange}
                  />
                </div>
              ))}
            </div>
          </div>
        )}

        <button type="submit" className="add-size-button">Update Size</button>
      </form>
    </div>
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
                <a href="https://www.facebook.com/raanjhanaa.amritsar/"><FaFacebookF /></a>
                <a href="https://www.instagram.com/raanjhanaa_amritsar/?hl=en"><FaInstagram /></a>
                <a href="mailto:raanjhanaa13@gmail.com"><FaEnvelope /></a>
              </div>
            </div>
          </div>
    
          <div className="footer-bottom">
            <p>© {new Date().getFullYear()} <span className="highlight">Raanjhanaa</span>. All rights reserved.</p>
          </div>
        </footer>
    </div>
  );
};

export default UpdateCustomer;
