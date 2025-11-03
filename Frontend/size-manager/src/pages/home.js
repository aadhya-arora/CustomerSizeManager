import React from "react";
import { FaPlus, FaSearch, FaCloud,FaTshirt } from "react-icons/fa";
import "../styling/home.css";

const HomePage = () => {
  return (
    <div className="homepage">
      <nav className="navbar">
        <div className="logo-section">
          <img src="#" alt="Raanjhana Logo" className="logo" />
          <h1 className="brand-name">Raanjhanaa</h1>
        </div>
        <ul className="nav-links">
          <li>Home</li>
          <li>Add Customer</li>
          <li>View Customers</li>
          <li>Search</li>
        </ul>
      </nav>

      <section className="hero">
        <h2>Raanjhanaa – Men’s Boutique</h2>
        <p>
          Save your customers’ size details effortlessly. Quick, reliable, and
          tailor-made for your store.
        </p>
        <div className="hero-buttons">
          <button className="btn primary">
            <FaPlus /> Add Customer
          </button>
          <button className="btn secondary">
            <FaSearch /> Search by Phone
          </button>
        </div>
      </section>

  
      <section className="features">
        <div className="feature-card">
          <FaTshirt className="icon" />
          <h3>Save Sizes</h3>
          <p>Record shirt, pant, and shoe sizes easily.</p>
        </div>

        <div className="feature-card">
          <FaSearch className="icon" />
          <h3>Quick Search</h3>
          <p>Find customers by phone instantly.</p>
        </div>

        <div className="feature-card">
          <FaCloud className="icon" />
          <h3>Cloud Ready</h3>
          <p>Secure storage with future login support.</p>
        </div>
      </section>

      {/* Footer */}
      <footer className="footer">
        © 2025 <span className="highlight">Raanjhanaa</span> | Built with ❤️ in
        Java + React
      </footer>
    </div>
  );
};

export default HomePage;
