# Nom de l'exécutable final
TARGET = programPoint

# Compilateur et options de base
CC = gcc
CFLAGS = -Wall -Wextra -std=c11 -lm

# Recherche automatique de tous les fichiers .c
SRCS = $(wildcard *.c)
OBJS = $(SRCS:.c=.o)
LDLIBS = -lm

# Règle par défaut : compile le projet
all: $(TARGET)

# Lien des fichiers objets pour créer l'exécutable
$(TARGET): $(OBJS)
	$(CC) $(OBJS) -o $(TARGET) $(LDLIBS)

# Nettoyage des fichiers temporaires et de l'exécutable
clean:
	rm -f *.o $(TARGET)

# Indique que 'all' et 'clean' ne sont pas de vrais fichiers
.PHONY: all clean
