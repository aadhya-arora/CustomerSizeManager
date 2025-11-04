import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from './pages/home';
import AddCustomer from "./pages/addCustomer";
import UpdateCustomer from "./pages/updateCustomer";
import ViewCustomer from "./pages/viewCustomer";
function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/add-size" element={<AddCustomer />} />
        <Route path="/update-customer" element={<UpdateCustomer />} />
        <Route path="/view-customer" element={<ViewCustomer />} />
      </Routes>
    </Router>
  );
}

export default App;
