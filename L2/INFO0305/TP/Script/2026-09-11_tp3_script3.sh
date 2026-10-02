#!/bin/bash

nombre=$((RANDOM % 1000000000))
nuser=-1;
echo "Devine le nombre entre 0 et 1000000000 : ";
nc=0;
while [[ $nombre -ne $nuser && $nc -le 10 ]]
do
    read nuser;
    if [ $nuser -gt $nombre ];
    then
        echo "le nombre chercher est plus petit : ";
    elif [ $nuser -lt $nombre ];
    then
        echo "le nombre chercher est plus grand : ";
    fi
    ((nc++))
done

echo "bravo vous avez gagner";
exit 0;