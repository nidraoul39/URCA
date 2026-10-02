CC = gcc
CFLAGS = -Wall -Wextra
EXE = executable

all: $(EXE)

$(EXE): Element.o File_.o testF.o
	$(CC) Element.o File_.o testF.o -o $(EXE)

File : File_.h File_.c File_ch.h
	$(CC) $(CFLAGS) File_.c -c

Element : Element.c Element.h
	$(CC) $(CFLAGS) Element.c -c

Principal : testF.c
	$(CC) $(CFLAGS) testF.c -c
	
.PHONY: all clean mrproper
clean :
	rm *.o

mrproper : clean
	rm $(EXE)
