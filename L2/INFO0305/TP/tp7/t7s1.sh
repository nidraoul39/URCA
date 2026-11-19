#!/bin/bash

free=$(df / | tail -n 1);
date=$(date '+%d/%m');


while [ true ]
do
    echo "$date"-"$$"-"$PPID":"$free" >> esp.txt;
    $(sleep 5);
    tail -n 3 /home/nidal/Documents/URCA/L2/INFO0305/TP/tp7/esp.txt;
done