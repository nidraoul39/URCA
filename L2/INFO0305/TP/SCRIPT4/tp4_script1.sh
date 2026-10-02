#!/bin/bash

madate=$(date +%s);
heure=$((madate/3600));
minute=$((madate%3600/60));
seconde=$((madate%3600%60));


echo "$heure" "$minute" "$seconde"