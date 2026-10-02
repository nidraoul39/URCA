#ifndef ELEMENT
#define ELEMENT

typedef struct Element
{
    int  x;
    double y;
} Element;

Element saisi();
void afficher(Element *e);


#endif