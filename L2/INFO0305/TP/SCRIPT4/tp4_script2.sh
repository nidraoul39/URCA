#!/bin/bash

if [ $# -ne 1 ]
then
    echo "le nombre de parametre est incorrect";
    exit -1;
fi

heure=$(($1/3600));
minute=$(($1%3600/60));
seconde=$(($1%3600%60));


echo "$heure" "$minute" "$seconde"