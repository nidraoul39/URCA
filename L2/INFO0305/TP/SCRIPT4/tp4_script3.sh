#!/bin/bash

# Vérification du nombre de paramètres
if [ $# -ne 6 ];
then
    echo "il n'y a pas le bon nb de parametre c'est jj mm aa jj2 mm2 aa2"
    exit 1
fi

if [[ $1 -gt 31 || $1 -lt 1 || \
      $4 -gt 31 || $4 -lt 1 || \
      $2 -gt 12 || $2 -lt 1 || \
      $5 -gt 12 || $5 -lt 1 || \
      $3 -lt 1  || $6 -lt 1 ]]; then
    echo "date incorrect"
    exit 1
fi

text="la premiere date est plus récente"
text2="la deuxieme date est plus récente"
text3="les deux dates sont identiques"

# Comparaison des années
if [ $3 -gt $6 ];
then 
    echo "$text"
elif [ $3 -lt $6 ];
then
    echo "$text2"
else
    # Si les années sont égales, on compare les mois
    if [ $2 -gt $5 ];
    then
        echo "$text"
    elif [ $2 -lt $5 ];
    then
        echo "$text2"
    else
        # Si les mois sont égaux, on compare les jours
        if [ $1 -gt $4 ];
        then
            echo "$text"
        elif [ $1 -lt $4 ];
        then
            echo "$text2"
        else
            echo "$text3"
        fi
    fi
fi
