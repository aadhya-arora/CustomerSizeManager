import React, { useState,useEffect } from "react";
import "../styling/addCustomer.css";
import { Link } from "react-router-dom";
import logo from "../images/logo.png";
import { FaFacebookF, FaInstagram, FaEnvelope } from "react-icons/fa";

const UpdateCustomer = () => {
  const [phone, setPhone] = useState("");
  const [category, setCategory] = useState("");
  const [trouserType, setTrouserType] = useState("");
  const [formData, setFormData] = useState({});
  const [name, setName] = useState("");
  const [availableCategories, setAvailableCategories] = useState([]);
const [expanded, setExpanded] = useState({});
const [sizeData, setSizeData] = useState({});
const [loadingSizes, setLoadingSizes] = useState(false);


 useEffect(() => {
  if (!phone) {
    setAvailableCategories([]);
    setLoadingSizes(false);
    return;
  }

  setLoadingSizes(true);
  setAvailableCategories([]);

  const BASE_URL = "https://raanjhana-backend.onrender.com";

  const categories = ["trouser", "shirt", "kurta", "coat", "sherwani", "waistcoat"];

  Promise.all(
    categories.map((cat) =>
      fetch(`${BASE_URL}/api/sizes/${cat}/${phone}`)
        .then((res) => (res.ok ? res.json() : null))
        .then((data) => (data ? cat : null))
        .catch(() => null)
    )
  ).then((results) => {
    const filtered = results
      .filter((c) => c !== null)
      .map((c) => ({
        category: c.charAt(0).toUpperCase() + c.slice(1),
      }));

    setAvailableCategories(filtered);
    setLoadingSizes(false);
  });
}, [phone]);

const handleExpand = (cat) => {
  const key = cat.category;

  if (expanded[key]) {
    setExpanded(prev => ({ ...prev, [key]: false }));
    return;
  }

  setExpanded(prev => ({ ...prev, [key]: true }));

  if (!sizeData[key]) {
    const BASE_URL = "https://raanjhana-backend.onrender.com";

    fetch(`${BASE_URL}/api/sizes/${cat.category.toLowerCase()}/${phone}`)
      .then(res => res.json())
      .then(data => {
        setSizeData(prev => ({ ...prev, [key]: data }));
      })
      .catch(err => console.error(err));
  }
};

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
  e.preventDefault();

  if (!phone || !category) {
    alert("Please fill out all required fields!");
    return;
  }

  // ✅ remove empty fields
  const cleanData = (obj) => {
    const newObj = {};
    Object.keys(obj).forEach((key) => {
      if (obj[key] !== "") {
        newObj[key] = obj[key];
      }
    });
    return newObj;
  };

  let payload = {
    customerPhoneNumber: phone,
    name: name,
    ...cleanData(formData),
  };

  if (category.toLowerCase() === "trouser" && trouserType !== "") {
    payload.pleats = trouserType;
  }

  const BASE_URL = "https://raanjhana-backend.onrender.com";


  let endpoint = "";
  switch (category.toLowerCase()) {
    case "trouser":
      endpoint = `${BASE_URL}/api/sizes/trouser/update`;
      break;
    case "kurta":
      endpoint = `${BASE_URL}/api/sizes/kurta/update`;
      break;
    case "shirt":
      endpoint = `${BASE_URL}/api/sizes/shirt/update`;
      break;
    case "coat":
      endpoint = `${BASE_URL}/api/sizes/coat/update`;
      break;
    case "sherwani":
      endpoint = `${BASE_URL}/api/sizes/sherwani/update`;
      break;
    case "waistcoat":
      endpoint = `${BASE_URL}/api/sizes/waistcoat/update`;
      break;
    default:
      alert("Invalid category");
      return;
  }

  fetch(endpoint, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(payload),
  })
    .then((res) => {
      if (!res.ok) throw new Error("Failed to update");
      return res.text();
    })
    .then(() => {
      alert("✅ Updated successfully!");

      setPhone("");
      setName("");
      setCategory("");
      setTrouserType("");
      setFormData({});
    })
    .catch((err) => {
      console.error(err);
      alert("❌ Update failed");
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
        </ul>
      </nav>
      
        <h2 className="update-title">Update Customer Size</h2>
      <div className="update-size-container" >
        <div className="update-form-section">
        <form className="add-size-form" onSubmit={handleSubmit}>
          <label>Phone Number</label>
          <input
            type="tel"
            placeholder="Enter customer's phone number"
            value={phone}
            onChange={(e) => setPhone(e.target.value)}
            required
          />

          <label>Customer Name</label>
          <input
            type="text"
            placeholder="Enter customer's name"
            value={name}
            onChange={(e) => setName(e.target.value)}
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


        <div>

          <div className="existing-section">
  <h3>Existing Sizes</h3>

{loadingSizes ? (
  <p className="no-data">🔍 Searching...</p>
) : availableCategories.length === 0 ? (
  <p className="no-data">No sizes found</p>
) : (
    availableCategories.map((cat, index) => {
      const key = cat.category;

      return (
        <div key={index} style={{ marginBottom: "10px" }}>
          <div
            className="size-card"
            onClick={() => handleExpand(cat)}
          >
            {cat.category}
          </div>

          {expanded[key] && sizeData[key] && (
            <div style={{ background: "#333", color: "#fff", padding: "10px" }}>
              {Object.entries(sizeData[key]).map(([k, v]) => (
                <div key={k}>
                  <b>{k}</b>: {v}
                </div>
              ))}
            </div>
          )}
        </div>
      );
    })
  )}
  </div>
</div>
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
