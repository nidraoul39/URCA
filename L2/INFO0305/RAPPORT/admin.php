<?php
define("BD_HOST", "192.168.100.2");
define("BD_BASE", "tp9");
define("BD_USER", "webuser");
define("BD_PASSWORD", "MotDePasseTP9!");

try {
    $BD = new PDO("mysql:host=".BD_HOST.";dbname=".BD_BASE.";charset=UTF8", BD_USER, BD_PASSWORD);

    $stmt = $BD->query("SELECT * FROM connexions LIMIT 10");

    while ($ligne = $stmt->fetch(PDO::FETCH_ASSOC)) {
        echo implode(" | ", $ligne) . "<br>";
    }

} catch(Exception $e) {
    exit("Erreur : " . $e->getMessage());
}
?>