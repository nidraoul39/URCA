#include <stdio.h>
#include "element.h"

Element saisi(){
    Element e;
    printf("entrer x et y x:y");
    scanf("%d:%lf",&e.x,&e.y);
    return e;
}
void afficher(Element *e){
    printf("x=%d : y=%lf",e->x,e->y);
}
