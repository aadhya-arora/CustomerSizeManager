import React, { useState } from "react";
import "../styling/addCustomer.css";
import { Link } from "react-router-dom";
import { FaFacebookF, FaInstagram, FaEnvelope } from "react-icons/fa";
import logo from "../images/logo.png";

const AddCustomerSize = () => {
  const [phoneNumber, setPhoneNumber] = useState("");
  const [category, setCategory] = useState("");

  const [trouserData, setTrouserData] = useState({
    pleats: "",
    length: "",
    waist: "",
    il: "",
    hips: "",
    thigh: "",
    r: "",
    knee: "",
    calf: "",
    bottom: "",
  });

  const [upperWearData, setUpperWearData] = useState({
    length: "",
    chest: "",
    gap: "",
    waist: "",
    hips: "",
    shoulder: "",
    sleeve: "",
    bicep: "",
    elbow: "",
    cuff: "",
    cb: "",
    neck: "",
  });

  const [waistCoatData, setWaistCoatData] = useState({
    length: "",
    chest: "",
    gap: "",
    waist: "",
    hips: "",
    shoulder: "",
    neck: "",
  });

  const handleTrouserChange = (e) => {
    const { name, value } = e.target;
    setTrouserData({ ...trouserData, [name]: value });
  };

  const handleUpperWearChange = (e) => {
    const { name, value } = e.target;
    setUpperWearData({ ...upperWearData, [name]: value });
  };

  const handleWaistCoatChange = (e) => {
    const { name, value } = e.target;
    setWaistCoatData({ ...waistCoatData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!phoneNumber || !category) {
      alert("Please fill all required fields!");
      return;
    }

    const payload = {
      phoneNumber,
      category,
      ...(category === "trouser"
        ? trouserData
        : category === "waistcoat"
        ? waistCoatData
        : upperWearData),
    };

    console.log("Submitted Data:", payload);
    alert(`Size details added for ${category.toUpperCase()} of ${phoneNumber}`);

 
    setPhoneNumber("");
    setCategory("");
    setTrouserData({
      pleats: "",
      length: "",
      waist: "",
      il: "",
      hips: "",
      thigh: "",
      r: "",
      knee: "",
      calf: "",
      bottom: "",
    });
    setUpperWearData({
      length: "",
      chest: "",
      gap: "",
      waist: "",
      hips: "",
      shoulder: "",
      sleeve: "",
      bicep: "",
      elbow: "",
      cuff: "",
      cb: "",
      neck: "",
    });
    setWaistCoatData({
      length: "",
      chest: "",
      gap: "",
      waist: "",
      hips: "",
      shoulder: "",
      neck: "",
    });
  };

  const upperWearFields = [
    { label: "Length", name: "length" },
    { label: "Chest", name: "chest" },
    { label: "Gap", name: "gap" },
    { label: "Waist", name: "waist" },
    { label: "Hips", name: "hips" },
    { label: "Shoulder", name: "shoulder" },
    { label: "Sleeve", name: "sleeve" },
    { label: "Bicep", name: "bicep" },
    { label: "Elbow", name: "elbow" },
    { label: "Cuff", name: "cuff" },
    { label: "CB", name: "cb" },
    { label: "Neck", name: "neck" },
  ];

  const trouserFields = [
    { label: "Length", name: "length" },
    { label: "Waist", name: "waist" },
    { label: "IL", name: "il" },
    { label: "Hips", name: "hips" },
    { label: "Thigh", name: "thigh" },
    { label: "R", name: "r" },
    { label: "Knee", name: "knee" },
    { label: "Calf", name: "calf" },
    { label: "Bottom", name: "bottom" },
  ];

  const waistCoatFields = [
    { label: "Length", name: "length" },
    { label: "Chest", name: "chest" },
    { label: "Gap", name: "gap" },
    { label: "Waist", name: "waist" },
    { label: "Hips", name: "hips" },
    { label: "Shoulder", name: "shoulder" },
    { label: "Neck", name: "neck" },
  ];

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
          <li><Link to="/update-customer" className="nav-item">Update Customer</Link></li>
          <li>
            <Link to="/view-customer" className="nav-item">
                View Customers
                </Link>
          </li>
          <li>Search</li>
        </ul>
      </nav>

      <div className="add-size-container">
        <h2>Add Customer Size</h2>

        <form className="add-size-form" onSubmit={handleSubmit}>
          <label htmlFor="phone">Phone Number</label>
          <input
            type="tel"
            id="phone"
            placeholder="Enter customer's phone number"
            value={phoneNumber}
            onChange={(e) => setPhoneNumber(e.target.value)}
            required
          />

          <label htmlFor="category">Select Category</label>
          <select
            id="category"
            value={category}
            onChange={(e) => setCategory(e.target.value)}
            required className="select-category"
          >
            <option value="">-- Select Category --</option>
            <option value="trouser">Trouser</option>
            <option value="sherwani">Sherwani</option>
            <option value="kurta">Kurta</option>
            <option value="shirt">Shirt</option>
            <option value="coat">Coat</option>
            <option value="waistcoat">Waist Coat</option>
          </select>

       
          {category === "trouser" && (
            <div className="category-section">
              <h3>Trouser Measurements</h3>

              <label htmlFor="pleats" className="trouser-fields">Pleats</label>
              <select
                id="pleats"
                name="pleats"
                value={trouserData.pleats}
                onChange={handleTrouserChange}
                required
              >
                <option value="">-- Select Option --</option>
                <option value="with pleats">With Pleats</option>
                <option value="without pleats">Without Pleats</option>
              </select>

              <div className="fields-grid">
                {trouserFields.map((field) => (
                  <div key={field.name}>
                    <label htmlFor={field.name}>{field.label}</label>
                    <input
                      type="number"
                      id={field.name}
                      name={field.name}
                      placeholder={`Enter ${field.label}`}
                      value={trouserData[field.name]}
                      onChange={handleTrouserChange}
                      required
                    />
                  </div>
                ))}
              </div>
            </div>
          )}

     
          {["sherwani", "kurta", "shirt", "coat"].includes(category) && (
            <div className="category-section">
              <h3>
                {category.charAt(0).toUpperCase() + category.slice(1)} Measurements
              </h3>

              <div className="fields-grid">
                {upperWearFields.map((field) => (
                  <div key={field.name}>
                    <label htmlFor={field.name}>{field.label}</label>
                    <input
                      type="number"
                      id={field.name}
                      name={field.name}
                      placeholder={`Enter ${field.label}`}
                      value={upperWearData[field.name]}
                      onChange={handleUpperWearChange}
                      required
                    />
                  </div>
                ))}
              </div>
            </div>
          )}

        
          {category === "waistcoat" && (
            <div className="category-section">
              <h3>Waist Coat Measurements</h3>

              <div className="fields-grid">
                {waistCoatFields.map((field) => (
                  <div key={field.name}>
                    <label htmlFor={field.name}>{field.label}</label>
                    <input
                      type="number"
                      id={field.name}
                      name={field.name}
                      placeholder={`Enter ${field.label}`}
                      value={waistCoatData[field.name]}
                      onChange={handleWaistCoatChange}
                      required
                    />
                  </div>
                ))}
              </div>
            </div>
          )}

          <button type="submit" className="add-size-button">
            Add Size
          </button>
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
                <Link to="/view-customer" className="nav-item">View Customers</Link>
              </li>
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
          <p>
            © {new Date().getFullYear()}{" "}
            <span className="highlight">Raanjhanaa</span>. All rights reserved.
          </p>
        </div>
      </footer>
    </div>
  );
};

export default AddCustomerSize;
