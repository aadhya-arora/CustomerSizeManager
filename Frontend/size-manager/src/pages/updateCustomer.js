import React, { useState, useEffect } from "react";
import "../styling/addCustomer.css";
import { Link } from "react-router-dom";
import logo from "../images/logo.png";
import { FaFacebookF, FaInstagram, FaEnvelope } from "react-icons/fa";

const UpdateCustomer = () => {
  const [phone, setPhone] = useState("");
  const [name, setName] = useState("");
  const [category, setCategory] = useState("");
  const [trouserType, setTrouserType] = useState("");
  const [formData, setFormData] = useState({});

  const [availableCategories, setAvailableCategories] = useState([]);
  const [expanded, setExpanded] = useState({});
  const [sizeData, setSizeData] = useState({});

  const BASE_URL = "https://raanjhana-backend.onrender.com";

  // ✅ Fetch categories
  useEffect(() => {
    if (!phone) {
      setAvailableCategories([]);
      return;
    }

    fetch(`${BASE_URL}/api/customers/all-with-categories`)
      .then((res) => res.json())
      .then((data) => {
        const filtered = data.filter(
          (c) => c.phoneNumber === phone
        );
        setAvailableCategories(filtered);
      })
      .catch((err) => console.error(err));
  }, [phone]);

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleExpand = (cat) => {
    const key = cat.category;

    if (expanded[key]) {
      setExpanded((prev) => ({ ...prev, [key]: false }));
      return;
    }

    setExpanded((prev) => ({ ...prev, [key]: true }));

    if (!sizeData[key]) {
      fetch(`${BASE_URL}/api/sizes/${cat.category.toLowerCase()}/${phone}`)
        .then((res) => res.json())
        .then((data) => {
          setSizeData((prev) => ({ ...prev, [key]: data }));
        })
        .catch((err) => console.error(err));
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!phone || !category || !name) {
      alert("Please fill all required fields!");
      return;
    }

    const cleanData = (obj) => {
      const newObj = {};
      Object.keys(obj).forEach((key) => {
        if (obj[key] !== "") newObj[key] = obj[key];
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

    let endpoint = `${BASE_URL}/api/sizes/${category.toLowerCase()}/update`;

    fetch(endpoint, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(payload),
    })
      .then((res) => {
        if (!res.ok) throw new Error("Failed");
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
      .catch(() => alert("❌ Update failed"));
  };

  return (
    <div className="page-container">
      {/* NAVBAR */}
      <nav className="navbar">
        <div className="logo-section">
          <img src={logo} alt="Logo" className="logo" />
          <span className="brand-name">aanjhanaa</span>
        </div>
        <ul className="nav-links">
          <li><Link to="/">Home</Link></li>
          <li><Link to="/add-size">Add Customer</Link></li>
          <li><Link to="/update-customer">Update Customer</Link></li>
          <li><Link to="/view-customer">View Customers</Link></li>
        </ul>
      </nav>

      {/* MAIN */}
      <div style={{ display: "flex", gap: "40px", padding: "20px" }}>
        
        {/* FORM */}
        <div style={{ flex: 1 }}>
          <h2>Update Customer Size</h2>

          <form onSubmit={handleSubmit}>
            <label>Phone Number</label>
            <input
              type="tel"
              value={phone}
              onChange={(e) => setPhone(e.target.value)}
              required
            />

            <label>Customer Name</label>
            <input
              type="text"
              value={name}
              onChange={(e) => setName(e.target.value)}
              required
            />

            <label>Select Category</label>
            <select
              value={category}
              onChange={(e) => setCategory(e.target.value)}
              required
            >
              <option value="">Select</option>
              <option value="Trouser">Trouser</option>
              <option value="Sherwani">Sherwani</option>
              <option value="Kurta">Kurta</option>
              <option value="Shirt">Shirt</option>
              <option value="Coat">Coat</option>
              <option value="Waistcoat">Waistcoat</option>
            </select>

            <button type="submit">Update</button>
          </form>
        </div>

        {/* RIGHT PANEL */}
        <div style={{ width: "300px" }}>
          <h3>Existing Sizes</h3>

          {availableCategories.length === 0 ? (
            <p>No data</p>
          ) : (
            availableCategories.map((cat, i) => {
              const key = cat.category;

              return (
                <div key={i}>
                  <div
                    style={{
                      background: "#222",
                      color: "#fff",
                      padding: "10px",
                      cursor: "pointer",
                      marginTop: "10px"
                    }}
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

      {/* ✅ FOOTER BACK */}
      <footer className="footer">
        <div className="footer-container">
          <div className="footer-brand">
            <h2 className="brand-name">Raanjhanaa</h2>
            <p className="tagline">Style that fits every story.</p>
          </div>

          <div className="footer-links">
            <h4>Quick Links</h4>
            <ul>
              <li><Link to="/">Home</Link></li>
              <li><Link to="/add-size">Add Customer</Link></li>
              <li><Link to="/update-customer">Update Customer</Link></li>
              <li><Link to="/view-customer">View Customers</Link></li>
            </ul>
          </div>

          <div className="footer-contact">
            <h4>Contact</h4>
            <p>Email: raanjhanaa13@gmail.com</p>
            <p>Phone: +91 734-7278272</p>
            <p>Phone: +91 98786 41457</p>

            <div className="social-icons">
              <a href="#"><FaFacebookF /></a>
              <a href="#"><FaInstagram /></a>
              <a href="#"><FaEnvelope /></a>
            </div>
          </div>
        </div>
      </footer>
    </div>
  );
};

export default UpdateCustomer;