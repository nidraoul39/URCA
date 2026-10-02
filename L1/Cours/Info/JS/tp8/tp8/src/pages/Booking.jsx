import Menu from "@/component/Menu.jsx";
import { useParams } from "react-router-dom";

export default function Booking() {
  const params = useParams();
  return (
    <>
      <h1>Booking</h1>
      <div className="container">
        <Menu></Menu>
        <h1>Réservation du séjour n°{params.id}</h1>
      </div>
    </>
  );
}
