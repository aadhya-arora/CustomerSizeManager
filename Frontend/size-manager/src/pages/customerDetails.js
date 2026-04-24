import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import "../styling/customerDetails.css";
import { useNavigate } from "react-router-dom";

const CustomerDetails = () => {
  const { phone, category } = useParams();
  const [data, setData] = useState(null);

  const location = useLocation();
const name = location.state?.name;

  const BASE_URL = "https://raanjhana-backend.onrender.com";

  useEffect(() => {
    fetch(`${BASE_URL}/api/sizes/${category.toLowerCase()}/${phone}`)
      .then(res => res.json())
      .then(setData)
      .catch(err => console.error(err));
  }, [phone, category]);

const navigate = useNavigate();

return (
  <div className="details-page">
    
    <div className="details-header">
      <h2>{category} Size Details</h2>
    </div>

    <div className="details-card">

      <div className="back-btn" onClick={() => navigate(-1)}>
        ← Back
      </div>

      <div className="customer-info">
        <div><strong>Name:</strong> {name || "Unknown"}</div>
        <div><strong>Phone:</strong> {phone}</div>
        <div><strong>Category:</strong> {category}</div>
      </div>

      {data ? (
        <table className="details-table">
          <tbody>
            {Object.entries(data).map(([k, v]) => (
              <tr key={k}>
                <td className="details-key">{k}</td>
                <td className="details-value">
                  {v === null || v === "" ? "-" : v}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <p className="details-loading">Loading...</p>
      )}
    </div>
  </div>
);
};

export default CustomerDetails;