#!/bin/bash

echo "entrer un nom de fichier non existant dans le répertoir courant";

read fichier;

if [ -e $fichier ];
then
    echo "erreur le fichier existe deja";
    exit 1;
fi

while read LINE
do
    if [ "stop" = "$LINE" ];
    then
        break;
    fi
    echo $LINE >> $fichier;
done