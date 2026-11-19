#!/bin/bash
set -e

if [ $# -ne 2 ]
then
    echo "entrer l'addresse sur 24 octect que l'on va scaner ex : 192.168.1";
    exit 1;
fi

i=0;

while [ $i -ne 255 ]
do
    res=$(ping -c 1 "$1.$i" &> /dev/null && echo 1 || echo 0);
    if [ $res -eq 1 ]
    then
        echo "l'addresse $1.$i existe !";
    fi
done
