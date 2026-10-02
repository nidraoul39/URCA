
## Formulaire HTML – Attributs utiles

```html
<form action="traitement.php" method="post">
  <label for="nom">Nom :</label>
  <input type="text" id="nom" name="nom" required autofocus placeholder="Ex : Dupont">

  <label for="email">Email :</label>
  <input type="email" id="email" name="email" required placeholder="exemple@domaine.com">

  <label for="code_postal">Code postal :</label>
  <input type="text" id="code_postal" name="code_postal" required pattern="[0-9]{5}" title="5 chiffres requis" placeholder="75000">

  <button type="submit">Envoyer</button>
</form>
```

**Résumé des attributs :**

* `required` → champ obligatoire.
* `autofocus` → place le curseur automatiquement.
* `pattern` → impose un format avec regex.
* `placeholder` → texte indicatif dans le champ.

---

Si tu veux, je peux te **faire un petit tableau récapitulatif de tous les attributs importants pour les formulaires HTML**, très synthétique pour le cours. Veux‑tu que je fasse ça ?
