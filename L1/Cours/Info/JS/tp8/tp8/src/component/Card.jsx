import { Link } from "react-router-dom";

function Card({ title, description, link }) {
  return (
    <div class="col-sm-4 mb-4">
      <div class="card">
        <div class="card-body">
          <h5 class="card-title">{title}</h5>
          <p class="card-text">{description}</p>
          <Link className="btn-primary btn" to={link}>
            Réserver
          </Link>
        </div>
      </div>
    </div>
  );
}

export default Card;
