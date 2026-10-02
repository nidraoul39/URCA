#!/bin/bash

list=$(ls);

for element in $list
do
    if [ -f $element ];
    then
    echo "$element est un fichier";
    fi
done

for element in $list
do
    if [ -d $element ];
    then
    echo "$element est un répertoir";
    fi
done