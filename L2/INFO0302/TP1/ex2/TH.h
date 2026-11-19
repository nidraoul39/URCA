#ifndef TH
#define TH
#include "ListeR.h"
#include "Key.h"
#define MAX 500

typedef ListeR* Th[MAX] ;

int hash(Key);
void insererTH(Th*,Key,Element);


#endif