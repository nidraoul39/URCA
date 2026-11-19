<!DOCTYPE html>
<html lang="fr">
<head><meta charset="utf-8"><title>Info0305 TP9 – Accueil</title></head>
<body>
<h1>Serveur Web d'Info0305 TP 9</h1>
<p>Serveur : <strong><?php echo htmlspecialchars(gethostname()); ?></strong></p>
<p>Votre adresse IP : <strong> <?php echo $_SERVER['REMOTE_ADDR']; ?> </strong> </p>
<p>Votre navigateur : <?php  echo $_SERVER['HTTP_USER_AGENT']; ?></p>
<p>
<a href="login.php">Se connecter</a> |
<a href="admin.php">Journal des connexions</a>
</p>
</body>
</html>