import { NavLink } from "react-router-dom";

function MenuItem({ children, link }) {
  return (
    <NavLink
      to={link}
      className={({ isActive }) => (isActive ? "nav-link active" : "nav-link")}
    >
      {children}
    </NavLink>
  );
}

export default MenuItem;
