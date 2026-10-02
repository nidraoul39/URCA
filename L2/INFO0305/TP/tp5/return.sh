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

nl=$(wc -l < "$1");
echo $nl;

while [ $nl -ne 0 ]
do
    sed -n "${nl}p" "$1" >> "new$1";
    nl=$((nl-1));
done

echo "Terminé ! Le fichier inversé est disponible dans 'new$1'."