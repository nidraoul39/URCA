  GNU nano 8.7.1                                                traitement.php *                                                        
<?php
define("BD_HOST", "192.168.100.2"); // URL du serveur
define("BD_BASE", "tp9");   // Nom de la base de données
define("BD_USER", "webuser");      // Login
define("BD_PASSWORD", "MotDePasseTP9!");      // Mot de passe



function getOS(): string {
    // 1. Vérification moderne via les Client Hints (si disponibles en HTTPS)
    if (!empty($_SERVER['HTTP_SEC_CH_UA_PLATFORM'])) {
        return trim($_SERVER['HTTP_SEC_CH_UA_PLATFORM'], '"');
    }

    $userAgent = $_SERVER['HTTP_USER_AGENT'] ?? '';
    if (empty($userAgent)) {
        return 'OS Inconnu';
    }

    $osPlatforms = [
        'Windows 11'            => '/windows nt 10\.0.*(build (22[0-9]{3}|2[3-9][0-9]{3}))/i', // Détection spécifique Win 11 si exposé
        'Windows 10'            => '/windows nt 10/i',
        'Windows 8.1'           => '/windows nt 6\.3/i',
        'Windows 8'             => '/windows nt 6\.2/i',
        'Windows 7'             => '/windows nt 6\.1/i',
        'Windows Vista'         => '/windows nt 6\.0/i',
        'Windows XP'            => '/windows nt 5\.1|windows xp/i',
        'Windows'               => '/windows|win32/i',
        'iPhone'                => '/iphone/i',
        'iPad'                  => '/ipad/i',
        'iOS'                   => '/iphone|ipad|ipod/i',
        'Android'               => '/android/i',
        'macOS'                 => '/macintosh|mac os x/i',
        'Mac OS Classic'        => '/mac_powerpc/i',
        'Chrome OS'             => '/cros/i',
        'Ubuntu'                => '/ubuntu/i',
        'Linux'                 => '/linux/i',
        'BlackBerry'            => '/blackberry/i',
        'OpenBSD'               => '/openbsd/i',
        'FreeBSD'               => '/freebsd/i',
    ];

    foreach ($osPlatforms as $os => $regex) {
        if (preg_match($regex, $userAgent)) {
            return $os;
        }
    }

    return 'OS Inconnu';
}



if ($_SERVER["REQUEST_METHOD"] === "POST") {
    
    $os   = htmlspecialchars(getOS(), ENT_QUOTES, 'UTF-8');
    $co = isset($_POST['login']) ? trim($_POST['login']) : '';
    $nav = $_SERVER['HTTP_USER_AGENT'];
    $addr = $_SERVER['REMOTE_ADDR'];

    try {
        $BD = new PDO("mysql:host=".BD_HOST.";dbname=".BD_BASE.";charset=UTF8", BD_USER, BD_PASSWORD);
        $BD->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        $sql = "INSERT INTO connexions (ip, navigateur, systeme, login) VALUES (:ip, :nav, :os, :co)";
        $stmt = $BD->prepare($sql);
            
        $stmt->execute([
            'ip'  => $addr,
            'nav' => $nav,
            'os'  => $os,
            'co'  => $co
        ]);

        // Affichage du succès
        echo "<p style='color: green; font-weight: bold;'>Connexion enregistrée avec succès !</p>";
        echo "<p><a href='login.php'>Retour au formulaire</a></p>";

    } catch(Exception $e) {
        // En phase de test/TP, tu peux afficher $e->getMessage() pour debugger
        exit("<p>Problème de connexion ou d'insertion : " . htmlspecialchars($e->getMessage()) . "</p>");
    }


} else {
    // Si le fichier est accédé directement sans passer par le formulaire
    header("Location: login.php");
    exit;
}
?>

