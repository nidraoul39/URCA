/* Ch Jaillet
 * Info0301 - PFL
 */

#ifndef __ELEMENT_H__
#define __ELEMENT_H__

//////////////////////////////////////////////
// partie generique //////////////////////////

typedef struct xElement Element;

void saisie(Element*);
void affichage(Element);
int egaux(Element, Element);

//////////////////////////////////////////////
// partie specifique /////////////////////////

struct xElement {
	double x;
	int n;	
};


double valeurReelle(Element e);
int valeurEntiere(Element e);

#endif
