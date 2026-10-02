#ifndef FILE
#define FILE

typedef struct file file;

void initialiser(file *f);
void enfiler(file *f);
void defiler(file *f);
int taille(file *f);
bool estVide(file *f);
file sommet(file f);

#endif