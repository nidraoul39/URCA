import { createRoot } from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "@/pages/Home.jsx";
import Vacation from "@/pages/Vacation.jsx";
import Error from "@/pages/Error.jsx";
import Booking from "@/pages/Booking.jsx";
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap/dist/js/bootstrap.js";
import "bootstrap-icons/font/bootstrap-icons.css";

createRoot(document.getElementById("root")).render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/vacation" element={<Vacation />} />
      <Route path="Booking/:id" element={<Booking />} />
      <Route path="*" element={<Error />} />
    </Routes>
  </BrowserRouter>,
);
