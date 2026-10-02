import "./Slideshow.css";
import image1 from "@/assets/image1.jpg";
import image2 from "@/assets/image2.jpg";
import image3 from "@/assets/image3.jpg";
import image4 from "@/assets/image4.jpg";
import image5 from "@/assets/image5.jpg";
import Leb from "./ControlButton.jsx";

import { useState } from "react";

const image = [image1, image2, image3, image4, image5];

function Slideshow() {
  const [back, setback] = useState(0);
  function onClickButton(x) {
    let temp = (back + x) % 5;
    if (temp < 0) {
      temp = 4;
    }
    setback(temp);
  }
  return (
    <>
      <div
        className="slideshow"
        style={{ backgroundImage: `url(${image[back]})` }}
      >
        <Leb
          classnom="btnRight"
          onClickListener={() => {
            onClickButton(1);
          }}
        >
          &gt;
        </Leb>
        <Leb
          classnom="btnLeft"
          onClickListener={() => {
            onClickButton(-1);
          }}
        >
          &lt;
        </Leb>
      </div>
    </>
  );
}

export default Slideshow;
