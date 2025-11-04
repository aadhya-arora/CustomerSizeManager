import React from "react";
import { FaPlus, FaSearch, FaCloud, FaTshirt } from "react-icons/fa";
import { FaFacebookF, FaInstagram, FaLinkedinIn, FaEnvelope } from "react-icons/fa";
import "../styling/home.css";
import { Link } from "react-router-dom";
import hero from "../images/hero.png";
import logo from "../images/logo.png";
const HomePage = () => {
  return (
    <div className="homepage">
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

      <section className="hero">
        <img src={hero} alt="Hero" className="hero-image" />
        <h1 className="hero-text">Save Customer Sizes Effortlessly and Accurately</h1>
        <Link to="/add-size" style={{ textDecoration: "none", color: "inherit" }}>
        <button class="cssbuttons-io-button">
         Get started
          <div class="icon">
            <svg
              height="24"
              width="24"
              viewBox="0 0 24 24"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path d="M0 0h24v24H0z" fill="none"></path>
              <path
                d="M16.172 11l-5.364-5.364 1.414-1.414L20 12l-7.778 7.778-1.414-1.414L16.172 13H4v-2z"
                fill="currentColor"
              ></path>
            </svg>
          </div>
        </button>
        </Link>
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
          <h3>Update Sizes</h3>
          <p>Update the size of an existing customer.</p>
        </div>
      </section>

       <footer className="footer">
      <div className="footer-container">
        <div className="footer-brand">
          <h2 className="brand-name">Raanjhanaa</h2>
          <p className="tagline">Style that fits every story.</p>
        </div>

        
        <div className="footer-links">
          <h4>Quick Links</h4>
          <ul>
            <li><a href="#">Home</a></li>
            <li><a href="#">Add Customer</a></li>
            <li><a href="#">Update Customer</a></li>
            <li><a href="#">View Customers</a></li>
          </ul>
        </div>

        <div className="footer-contact">
          <h4>Contact</h4>
          <p>Email: support@raanjhanaa.com</p>
          <p>Phone: +91 98765 43210</p>
          <div className="social-icons">
            <a href="#"><FaFacebookF /></a>
            <a href="#"><FaInstagram /></a>
            <a href="#"><FaLinkedinIn /></a>
            <a href="mailto:support@raanjhanaa.com"><FaEnvelope /></a>
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

export default HomePage;
