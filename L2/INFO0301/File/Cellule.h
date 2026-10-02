#ifndef CELLULE
#define CELLULE
#include "Element.h"
typedef struct Xcellule cellule;

struct Xcellule
{
    Element e;
    cellule *svt;
};


#endif