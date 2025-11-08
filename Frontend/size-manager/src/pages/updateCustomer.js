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

    if (!phone || !category) {
      alert("Please fill out all required fields!");
      return;
    }

    const payload = {
      ...formData,
      customer: { phoneNumber: phone },
    };

    if (category.toLowerCase() === "trouser") {
      payload.pleats = trouserType;
    }

    let endpoint = "";
    switch (category.toLowerCase()) {
      case "trouser":
        endpoint = "http://localhost:8080/api/sizes/trouser/update";
        break;
      case "kurta":
        endpoint = "http://localhost:8080/api/sizes/kurta/update";
        break;
      case "shirt":
        endpoint = "http://localhost:8080/api/sizes/shirt/update";
        break;
      case "coat":
        endpoint = "http://localhost:8080/api/sizes/coat/update";
        break;
      case "sherwani":
        endpoint = "http://localhost:8080/api/sizes/sherwani/update";
        break;
      case "waistcoat":
        endpoint = "http://localhost:8080/api/sizes/waistcoat/update";
        break;
      default:
        alert("Please select a valid category!");
        return;
    }

    console.log("Updating with payload:", payload);

    fetch(endpoint, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(payload),
    })
      .then((res) => {
        if (res.status === 404) throw new Error("Customer not found");
        if (!res.ok) throw new Error("Failed to update customer");
        return res.text();
      })
      .then(() => {
        alert("✅ Customer size updated successfully!");
        setPhone("");
        setCategory("");
        setTrouserType("");
        setFormData({});
      })
      .catch((err) => {
        console.error("Update failed:", err);
        alert("❌ Failed to update customer. Please try again.");
      });
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
            <Link to="/update-customer" className="nav-item active">
              Update Customer
            </Link>
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
            type="tel"
            placeholder="Enter customer's phone number"
            value={phone}
            onChange={(e) => setPhone(e.target.value)}
            required
          />

          <label>Select Category</label>
          <select
            value={category}
            onChange={(e) => setCategory(e.target.value)}
            required
            className="select-category"
          >
            <option value="">-- Select Category --</option>
            <option value="Trouser">Trouser</option>
            <option value="Sherwani">Sherwani</option>
            <option value="Kurta">Kurta</option>
            <option value="Shirt">Shirt</option>
            <option value="Coat">Coat</option>
            <option value="Waistcoat">Waist Coat</option>
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
                {[
                  "length",
                  "waist",
                  "il",
                  "hips",
                  "thigh",
                  "r",
                  "knee",
                  "calf",
                  "bottom",
                ].map((field) => (
                  <div key={field}>
                    <label>{field.toUpperCase()}</label>
                    <input
                      type="number"
                      name={field}
                      value={formData[field] || ""}
                      onChange={handleChange}
                      required
                    />
                  </div>
                ))}
              </div>
            </div>
          )}

          {/* Sherwani / Kurta / Shirt / Coat Section */}
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
                    <label>{field.toUpperCase()}</label>
                    <input
                      type="number"
                      name={field}
                      value={formData[field] || ""}
                      onChange={handleChange}
                      required
                    />
                  </div>
                ))}
              </div>
            </div>
          )}

          {/* Waistcoat Section */}
          {category === "Waistcoat" && (
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
                    <label>{field.toUpperCase()}</label>
                    <input
                      type="number"
                      name={field}
                      value={formData[field] || ""}
                      onChange={handleChange}
                      required
                    />
                  </div>
                ))}
              </div>
            </div>
          )}

          <button type="submit" className="add-size-button">
            Update Size
          </button>
        </form>
      </div>

      {/* Footer */}
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

export default UpdateCustomer;
