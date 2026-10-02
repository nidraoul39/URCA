const contenu = document.getElementById("contenu");
const texte = document.getElementById("text");

function ajouter() {
  contenu.innerHTML += "<p>" + texte.value + "</p>";
  texte.value = "";
  texte.focus();
}
document.getElementById("ajouterBtn").addEventListener("click", function (e) {
  ajouter(e, 1);
});
