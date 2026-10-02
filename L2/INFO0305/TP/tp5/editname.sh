if [ $# -ne 4 ]
then 
    echo "entrer [username] [password] [ip] <répertoire>";
    exit 1;
fi

REP_A_SAUVEGARDER="$4"

export SSHPASS="$2"

sshpass -e ssh -tt "$1"@"$3" << EOF
    if [ ! -d "$REP_A_SAUVEGARDER" ]; then
        echo " Erreur : Le répertoire source '$REP_A_SAUVEGARDER' n'existe pas."
        exit 1;
    fi

    i=1;

    for f in "$REP_A_SAUVEGARDER"/*;
    do
        if [ -f "\$f" ];then
            extension="\${f##*.}"
            mv "\$f" "$REP_A_SAUVEGARDER"/fic"\$i"."\$extension";
            i=\$((i+1));
        fi
    done


EOF