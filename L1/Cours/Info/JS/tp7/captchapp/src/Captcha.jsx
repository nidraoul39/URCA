import "./assets/css/Captcha.css";
import Square from "./Square";

import { URL, API_KEY } from "./config.jsx";
import { useEffect } from "react";
import { useState } from "react";
import CaptchaAPI from "./api/CaptchaAPI.jsx";

let i = 0;
let l = 0;

function Captcha() {
  const [square, setSquare] = useState(Array(25).fill(false));
  function selectsquare(id) {
    const newsquare = [...square];
    newsquare[id] = !newsquare[id];
    setSquare(newsquare);
  }
  function storeJSON(data) {
    if (data == null) console.log("error");
    else {
      setCaptcha(data);
      setSquare(Array(25).fill(false));
    }
  }
  const [captcha, setCaptcha] = useState();
  useEffect(() => {
    CaptchaAPI.getCaptcha(storeJSON);
  }, []);

  return (
    <div className="captcha-container">
      <div
        className="captcha"
        style={{
          backgroundImage: captcha
            ? `url(${URL + "/" + captcha.image})`
            : "none",
        }}
      >
        {Array.from({ length: 5 }, (_, row) => (
          <div key={row}>
            {Array.from({ length: 5 }, (_, col) => {
              const index = row * 5 + col;

              return (
                <Square
                  key={index}
                  value={index}
                  active={square[index]}
                  onSelectListener={selectsquare}
                />
              );
            })}
          </div>
        ))}
      </div>
      <div className="captcha-title"> {captcha ? captcha.question : ""}</div>
      <button className="captcha-button">Valider</button>
    </div>
  );
}

export default Captcha;
