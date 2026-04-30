import React, { useState } from "react";
import "../styling/addCustomer.css";
import { Link } from "react-router-dom";
import { FaFacebookF, FaInstagram, FaEnvelope } from "react-icons/fa";
import logo from "../images/logo.png";

const StarRating = ({ value = 0, onChange }) => {
  const [hover, setHover] = React.useState(0);

  return (
    <div
      style={{
        display: "flex",
        flexDirection: "row", 
        alignItems: "center",
        gap: "6px",
      }}
    >
      {[1, 2, 3].map((star) => (
        <span
          key={star}
          style={{
            fontSize: "20px",
            cursor: "pointer",
            color: (hover || value) >= star ? "gold" : "#ccc",
          }}
          onClick={() => onChange(star)}
          onMouseEnter={() => setHover(star)}
          onMouseLeave={() => setHover(0)}
        >
          ★
        </span>
      ))}
    </div>
  );
};
const AddCustomerSize = () => {
  const [phoneNumber, setPhoneNumber] = useState("");
  const [customerName, setCustomerName] = useState("");
  const [category, setCategory] = useState("");
  const [sizesList, setSizesList] = useState([]);
  const [expandedIndex, setExpandedIndex] = useState(null);

  const [trouserData, setTrouserData] = useState({
    frontDown: "",
frontUp: "",
backDown: "",
fitting: "",
comfort: "",
shoeCut: "",
    pleats: "",
    length: "",
    waist: "",
    il: "",
    hips: "",
    thigh: "",
    r: "",
    r1:"",
    knee: "",
    calf: "",
    bottom: "",
  });

  const [upperWearData, setUpperWearData] = useState({
    rsd: 0,
lsd: 0,
sd: 0,
ss: 0,
fitting: 0,
comfort: 0,
loose: 0,
backRound: 0,
backDown: 0,
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
    rsd: 0,
lsd: 0,
sd: 0,
ss: 0,
fitting: 0,
comfort: 0,
loose: 0,
backRound: 0,
backDown: 0,
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

  const handleAddOneMore = () => {
  if (!phoneNumber || !category) {
  alert("Fill required fields first");
  return;
}


  const cleanData = (obj) => {
    const newObj = {};
    Object.keys(obj).forEach((key) => {
      if (obj[key] !== "") {
        newObj[key] = obj[key];
      }
    });
    return newObj;
  };

  const normalizedPhone = phoneNumber.replace(/\D/g, "");

  const data =
    category === "trouser"
      ? cleanData(trouserData)
      : category === "waistcoat"
      ? cleanData(waistCoatData)
      : cleanData(upperWearData);

      if (Object.keys(data).length === 0) {
  alert("Please fill at least one measurement");
  return;
}

  const newEntry = {
    category,
    payload: {
      customerPhoneNumber: normalizedPhone,
      name: customerName,
      ...data,
    },
  };

  setSizesList([...sizesList, newEntry]);

  // reset only category + form (keep phone & name)
  setCategory("");
  setTrouserData({
  frontDown: "",
  frontUp: "",
  backDown: "",
  fitting: "",
  comfort: "",
  shoeCut: "",
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
  rsd: 0,
  lsd: 0,
  sd: 0,
  ss: 0,
  fitting: 0,
  comfort: 0,
  loose: 0,
  backRound: 0,
  backDown: 0,
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
  rsd: 0,
  lsd: 0,
  sd: 0,
  ss: 0,
  fitting: 0,
  comfort: 0,
  loose: 0,
  backRound: 0,
  backDown: 0,
  length: "",
  chest: "",
  gap: "",
  waist: "",
  hips: "",
  shoulder: "",
  neck: "",
});
};

  const handleSubmit = async (e) => {
  e.preventDefault();

  if (sizesList.length === 0) {
    alert("Please add at least one size first!");
    return;
  }

  const BASE_URL = "https://raanjhana-backend.onrender.com";

  const getEndpoint = (category) => {
    switch (category) {
      case "trouser":
        return `${BASE_URL}/api/sizes/trouser/add`;
      case "kurta":
        return `${BASE_URL}/api/sizes/kurta/add`;
      case "shirt":
        return `${BASE_URL}/api/sizes/shirt/add`;
      case "coat":
        return `${BASE_URL}/api/sizes/coat/add`;
      case "sherwani":
        return `${BASE_URL}/api/sizes/sherwani/add`;
      case "waistcoat":
        return `${BASE_URL}/api/sizes/waistcoat/add`;
      default:
        return null;
    }
  };

  try {
    for (let item of sizesList) {
      const endpoint = getEndpoint(item.category);

      if (!endpoint) {
        alert("Invalid category in list");
        return;
      }

      const res = await fetch(endpoint, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(item.payload),
      });

      if (!res.ok) {
        throw new Error("Failed to add one of the sizes");
      }
    }

    alert("All sizes added successfully!");

    setSizesList([]);
    setPhoneNumber("");
    setCustomerName("");
    setCategory("");
    setTrouserData({
  frontDown: "",
  frontUp: "",
  backDown: "",
  fitting: "",
  comfort: "",
  shoeCut: "",
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
  rsd: 0,
  lsd: 0,
  sd: 0,
  ss: 0,
  fitting: 0,
  comfort: 0,
  loose: 0,
  backRound: 0,
  backDown: 0,
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
  rsd: 0,
  lsd: 0,
  sd: 0,
  ss: 0,
  fitting: 0,
  comfort: 0,
  loose: 0,
  backRound: 0,
  backDown: 0,
  length: "",
  chest: "",
  gap: "",
  waist: "",
  hips: "",
  shoulder: "",
  neck: "",
});
  } catch (err) {
    console.error("Error:", err);
    alert("Failed to add all sizes. Please try again.");
  }
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
    { label: "R1", name: "r1" },
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

          <label htmlFor="name">Customer Name</label>
          <input
            type="text"
            id="name"
            placeholder="Enter customer's name"
            value={customerName}
            onChange={(e) => setCustomerName(e.target.value)}
            required
          />

          <label htmlFor="category">Select Category</label>
          <select
            id="category"
            value={category}
            onChange={(e) => setCategory(e.target.value)}
            required
            className="select-category"
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

              <label htmlFor="pleats" className="trouser-fields">
                Pleats
              </label>
              <select
                id="pleats"
                name="pleats"
                value={trouserData.pleats}
                onChange={handleTrouserChange}
              >
                <option value="">-- Select Option --</option>
                <option value="with pleats">With Pleats</option>
                <option value="without pleats">Without Pleats</option>
              </select>

<div className="fields-grid">
  {[
    "frontDown",
    "frontUp",
    "backDown",
    "fitting",
    "comfort",
    "shoeCut",
  ].map((field) => (
    <div key={field}>
      <label>{field.toUpperCase()}</label>
      <input
        type="number"
        name={field}
        value={trouserData[field]}
        onChange={handleTrouserChange}
      />
    </div>
  ))}
</div>
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
                    />
                  </div>
                ))}
              </div>
            </div>
          )}

          {["sherwani", "kurta", "shirt", "coat"].includes(category) && (
            <div className="category-section">
              <h3>
                {category.charAt(0).toUpperCase() + category.slice(1)}{" "}
                Measurements
              </h3>


<div className="fields-grid">
  {[
    "rsd",
    "lsd",
    "sd",
    "ss",
    "fitting",
    "comfort",
    "loose",
    "backRound",
    "backDown",
  ].map((field) => (
    <div key={field}>
      <label>{field.toUpperCase()}</label>
      <StarRating
        value={upperWearData[field]}
        onChange={(val) =>
          setUpperWearData({
            ...upperWearData,
            [field]: val,
          })
        }
      />
    </div>
  ))}
</div>
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
  {[
    "rsd",
    "lsd",
    "sd",
    "ss",
    "fitting",
    "comfort",
    "loose",
    "backRound",
    "backDown",
  ].map((field) => (
    <div key={field}>
      <label>{field.toUpperCase()}</label>
      <StarRating
        value={upperWearData[field]}
        onChange={(val) =>
          setUpperWearData({
            ...upperWearData,
            [field]: val,
          })
        }
      />
    </div>
  ))}
</div>
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
                    />
                  </div>
                ))}
              </div>
            </div>
          )}

        <div className="added-sizes-container">
  {sizesList.map((item, index) => {
    const isOpen = expandedIndex === index;

    return (
      <div key={index} className="size-box">
        
        {/* Header (clickable) */}
        <div
          onClick={() =>
            setExpandedIndex(isOpen ? null : index)
          }
          style={{
            cursor: "pointer",
            display: "flex",
            justifyContent: "space-between",
            alignItems: "center",
            fontWeight: "bold",
          }}
        >
          <span>{item.category.toUpperCase()}</span>
          <span>{isOpen ? "▲" : "▼"}</span>
        </div>

        {/* Expandable content */}
        {isOpen && (
          <div style={{ marginTop: "10px" }}>
            {Object.entries(item.payload).map(([k, v]) => (
              <p key={k}>
                <b>{k}:</b> {v}
              </p>
            ))}
          </div>
        )}
      </div>
    );
  })}
</div>

         <div style={{ display: "flex", gap: "10px" }}>
  <button
    type="button"
    onClick={handleAddOneMore}
    className="add-size-button"
  >
    Add One More Size
  </button>

  <button
    type="submit"
    className="add-size-button"
  >
    Add All
  </button>
</div>
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

export default AddCustomerSize;
