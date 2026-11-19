#!/bin/bash

info=$(ps -eo %cpu=)
total=0

while read -r cpu; do
    total=$(echo "$total + $cpu" | bc -l)
done <<< "$info"

echo "$total"
