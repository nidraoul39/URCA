#!/bin/bash



for element in *; 
do
    if [ -f "$element" ]; 
    then
        touch -m "$element"
    fi
done