const contenu = document.getElementById("contenu");
const contenu2 = document.getElementById("contenu2");
const texte = document.getElementById("text");
const texte2 = document.getElementById("text2");

const regex = { "\n": "<br>", ";)": "&#x1F609;", ":)": "&#128522;" };
let nt;

function remplacer(chaine) {
  console.log(chaine);
  return regex[chaine];
}

function ajoutergauche() {
  nt = texte.value.replace(/\n|;\)|:\)/g, remplacer);

  contenu.innerHTML += '<div class="message droite">' + nt + "</div>";
  contenu2.innerHTML += '<div class="message gauche">' + nt + "</div>";

  texte.value = "";
  texte2.focus();
  contenu.scrollTop = contenu.scrollHeight;
}

function ajouterdroite() {
  nt = texte2.value.replace(/\n|;\)|:\)/g, remplacer);

  contenu2.innerHTML += '<div class="message droite">' + nt + "</div>";
  contenu.innerHTML += '<div class="message gauche">' + nt + "</div>";

  texte2.value = "";
  texte.focus();
  contenu.scrollTop = contenu.scrollHeight;
}

document.getElementById("ajouterBtn").addEventListener("click", function (e) {
  ajoutergauche(e, 1);
});
document.getElementById("ajouterBtn2").addEventListener("click", function (e) {
  ajouterdroite(e, 1);
});
