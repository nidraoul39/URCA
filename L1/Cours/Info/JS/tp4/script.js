const debut = document.getElementById("inputDateDebut");
const fin = document.getElementById("inputDateFin");
const duree = document.getElementById("inputDuree");

function formatDate(date) {
  return (
    String(date.getFullYear()).padStart(4, "0") +
    "-" +
    String(date.getMonth()).padStart(2, "0") +
    "-" +
    String(date.getDate()).padStart(2, "0")
  );
}

function checkValidity() {
  if (debut.value != "") {
    let datedeb = new Date(debut.value);
    let datemin = new Date().setDate(new Date().getDate() + 2);
    console.log(datemin);
    if (datedeb.getDate() < datemin.getDate()) {
      datedeb = datemin;
      console.log("erreur date de debut est pas possible");
      debut.value = formatDate(datedeb);
    }
  }
  if (fin.value != "") {
    datefin = new Date(fin.value);
    if (datedeb.getDate() > datefin.getDate()) {
      datefin = new Date(datedeb.getDate() + 1);
      fin.value = formatDate(datefin);
      console.log("erreur la date de fin est trop top");
    }
  }
  if (debut.value != "" && fin.value != "")
    duree.value = String(datefin.getDate() - datedeb.getDate()) + " jour";
}

function checkFormat(field) {
  if (field.value.match(/\d{4}-\d{2}-\d{2}/)) {
    const date = new Date(field.value);
    if (date.toString() == "Invalid Date") {
      console.log("DATE INNEXISTANTE");
    } else {
      field.value = formatDate(date);
      checkValidity();
    }
  } else {
    console.log("error format");
  }
}

document.getElementById("inputDateDebut").addEventListener("change", (f) => {
  checkFormat(debut);
});
document.getElementById("inputDateFin").addEventListener("change", (f) => {
  checkFormat(fin);
});
