import Menu from "@/component/Menu.jsx";
import Data from "@/data/vacations.json";
import Card from "@/component/Card.jsx";
function Vacation() {
  return (
    <>
      <h1>Vacation</h1>
      <div className="container">
        <Menu></Menu>
        <h1>Nos séjours</h1>
        <div className="row">
          <Card
            title={Data[0].title}
            description={Data[0].description}
            link="Reservation/1"
          ></Card>
          <Card
            title={Data[1].title}
            description={Data[1].description}
            link="Booking/2"
          ></Card>
          <Card
            title={Data[2].title}
            description={Data[1].description}
            link="Booking/3"
          ></Card>
          <Card
            title={Data[3].title}
            description={Data[1].description}
            link="Booking/4"
          ></Card>
          <Card
            title={Data[4].title}
            description={Data[1].description}
            link="Booking/5"
          ></Card>
        </div>
      </div>
    </>
  );
}

export default Vacation;
