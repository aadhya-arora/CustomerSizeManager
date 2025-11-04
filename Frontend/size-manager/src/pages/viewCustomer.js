import { FaFacebookF, FaInstagram, FaLinkedinIn, FaEnvelope } from "react-icons/fa";
import "../styling/viewCustomer.css";
import { Link } from "react-router-dom";
import logo from "../images/logo.png";

const ViewCustomer = () => {
    const customers = [
    { phone: "9876543210", category: "Shirts" },
    { phone: "9123456789", category: "Trousers" },
  ];

  return (
    <div className="page-container">   
      <nav className="navbar">
        <div className="logo-section">
          <img src={logo} alt="Raanjhana Logo" className="logo" />
          <span className="brand-name">aanjhanaa</span>
        </div>
        <ul className="nav-links">
          <li><Link to="/" className="nav-item">Home</Link></li>
          <li><Link to="/add-size" className="nav-item">Add Customer</Link></li>
          <li><Link to="/update-customer" className="nav-item">Update Customer</Link></li>
          <li><Link to="/view-customer" className="nav-item">View Customers</Link></li>
          <li>Search</li>
        </ul>
      </nav> 

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
            {customers.length > 0 ? (
              customers.map((cust, index) => (
                <tr key={index}>
                  <td>{cust.phone}</td>
                  <td>{cust.category}</td>
                </tr>
              ))
            ) : (
              <tr>
                <td colSpan="2" className="empty-row">No customers added yet</td>
              </tr>
            )}
          </tbody>
        </table>
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

export default ViewCustomer;
