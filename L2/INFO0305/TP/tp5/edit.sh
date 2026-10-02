if [ $# -ne 7 ]
then 
    echo "entrer [username] [password] [ip] <répertoire> <archiveur: zip|tar|tar.gz> <nom_archive>";
fi


REP_A_SAUVEGARDER="$4"
ARCHIVEUR="$5"
NOM_ARCHIVE="$6"



sshpass -p "$2" ssh "$1"@"$3" << 'EOF' > ./log.log
    if [ ! -d "$REP_A_SAUVEGARDER" ]; then
        echo "❌ Erreur : Le répertoire source '$REP_A_SAUVEGARDER' n'existe pas."
        exit 1
    fi

    if [ "$ARCHIVEUR" != "zip" ] && [ "$ARCHIVEUR" != "tar" ] && [ "$ARCHIVEUR" != "tar.gz" ]; then
        echo "❌ Erreur : Archiveur '$ARCHIVEUR' non valide."
        echo "Veuillez choisir parmi : zip, tar, tar.gz"
        exit 1
    fi

    while [ -f "$NOM_ARCHIVE" ]; do
        echo "⚠️ Le fichier destination '$NOM_ARCHIVE' existe déjà."
        read -p "Souhaitez-vous (o)uoverrécrire, (c)hanger de nom ou (q)uitter ? [o/c/q] : " choix
        
        case "$choix" in
            [oO])
                echo "🔄 Le fichier existant sera écrasé."
                rm -f "$NOM_ARCHIVE"
                ;;
            [cC])
                read -p "Entrez le nouveau nom pour l'archive : " NOM_ARCHIVE
                ;;
            *)
                echo "❌ Opération annulée par l'utilisateur."
                exit 0
                ;;
        esac
    done

    # 5. Création de l'archive selon l'archiveur sélectionné
    echo "⏳ Création de l'archive en cours avec l'outil '$ARCHIVEUR'..."

    case "$ARCHIVEUR" in
        "zip")
            # Vérification si l'outil zip est installé
            if ! command -v zip &> /dev/null; then
                echo "❌ Erreur : L'outil 'zip' n'est pas installé sur ce système."
                exit 1
            fi
            zip -r "$NOM_ARCHIVE" "$REP_A_SAUVEGARDER" > /dev/null
            ;;
        "tar")
            tar -cvf "$NOM_ARCHIVE" "$REP_A_SAUVEGARDER" > /dev/null
            ;;
        "tar.gz")
            tar -czvf "$NOM_ARCHIVE" "$REP_A_SAUVEGARDER" > /dev/null
            ;;
    esac

    # 6. Vérification du succès de l'opération
    if [ $? -eq 0 ] && [ -f "$NOM_ARCHIVE" ]; then
        echo "✅ Succès : L'archive '$NOM_ARCHIVE' a été créée avec succès."
        exit 0
    else
        echo "❌ Erreur critique lors de la création de l'archive."
        exit 1
    fi
EOF