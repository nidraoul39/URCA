#!/bin/bash

if [ $# -ne 3 ];
then
    echo "il manque des paramettre"
    exit -1;
fi
echo $1
echo $2
echo $3

if [ -d $1 ];
then
    tar -"$2" "$3" "$1"
else
    echo "le répertoir indiqué n'existe pas ! "
    exit 1;
fi