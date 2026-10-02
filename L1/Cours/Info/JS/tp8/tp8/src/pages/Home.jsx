import Menu from "@/component/Menu.jsx";
import Slideshow from "@/component/Slideshow";
function Home() {
  return (
    <>
      <Menu></Menu>
      <div className="container">
        <h1>BVN agence voyage</h1>
      </div>
      <div className="d-flex, justify-content-center mb-3">
        <Slideshow></Slideshow>
      </div>
    </>
  );
}

export default Home;
