import MenuItem from "@/component/MenuItem.jsx";
import { Link } from "react-router-dom";

function Menu() {
  return (
    <nav className="navbar navbar-expand-lg bg-body-tertiary">
      <div className="container-fluid">
        <Link to="/" className="navbar-brand">
          <i className="bi-duffle fs-2"></i>
        </Link>

        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          <ul className="navbar-nav me-auto mb-2 mb-lg-0">
            <MenuItem link="/">Accueil</MenuItem>
            <MenuItem link="/Vacation">Séjour</MenuItem>
            <MenuItem link="/Booking">Reservation</MenuItem>
          </ul>
        </div>
      </div>
    </nav>
  );
}

export default Menu;
