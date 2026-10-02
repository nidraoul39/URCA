#ifndef TEMPS
#define TEMPS

struct temps
{
    int h;
    int m;
    double s;   
};


typedef struct temps temps;


temps creer(int h, int m, double s);
// renvoie une var de temps avc val en parametre

_Bool correct(temps t);

void afficher(temps t);

temps normaliser(temps t);

temps creer2(void);

void saisir(temps *pt);

#endif