#!/bin/bash

if [ $# -ne 1 ]
then
    exit 1;
fi

if [ ! -f "$1" ]
then
    echo "le fichier n'existe pas";
    exit 2;
fi

inverserLettre() {
    if [ $# -ne 1 ]
    then
        echo "erreur pas de ligne fournit";
        exit 10;
    fi
    echo "$1" | rev;
}

inverserL() {
    nl=$(wc -l < "$1");
    echo $nl;

    while [ $nl -ne 0 ]
    do  
        ligne=$(sed -n "${nl}p" "$1");
        ligne=$(inverserLettre "$ligne");
        echo "$ligne" >> "new2$1";
        nl=$((nl-1));
    done
}

inverserL "$1"

echo "Terminé ! Le fichier inversé est disponible dans 'new$1'."

