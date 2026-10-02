#!/bin/bash



for element in *; 
do
    if [ -f "$element" ]; 
    then
        mv -- "$element" "$(stat -c %y "$element" | awk '{print $1}')_$element"
    fi
done
