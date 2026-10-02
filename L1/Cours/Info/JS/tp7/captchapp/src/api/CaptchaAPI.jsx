import { URL, API_KEY } from "../config.jsx";

const CaptchaAPI = {
  getCaptcha: function (storeJSON) {
    fetch(URL, {
      method: "POST",
      ReferrerPolicy: "no-referrer",
      body: JSON.stringify({ type: "get", key: API_KEY }),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        storeJSON(data);
      })
      .catch((error) => {
        console.log("erreur :" + error);
        storeJSON(null);
      });
  },
  checkCaptcha: async function (id, res) {
    fetch(URL, {
      method: "POST",
      ReferrerPolicy: "no-referrer",
      body: JSON.stringify({}),
    });
  },
};
export default CaptchaAPI;
