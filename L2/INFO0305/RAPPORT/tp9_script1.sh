#!/bin/bash
set -e

# 1. Vérification du nombre d'arguments
if [ "$#" -ne 1 ]; then
    echo "Usage: $0 <fichier_log>" >&2
    exit 1
fi

LOG_FILE="$1"

# Vérification de l'existence et de la lisibilité du fichier
if [ ! -r "$LOG_FILE" ]; then
    echo "Erreur : le fichier '$LOG_FILE' est introuvable ou illisible." >&2
    exit 2
fi

echo "=== Top des adresses IP par nombre d'accès ==="
echo "Occurrences | Adresse IP"
echo "------------------------"

awk '{print $1}' "$LOG_FILE" | sort | uniq -c | sort -nr