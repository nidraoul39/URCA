/* Ch Jaillet
 * Info0301 - PFL
 */

#ifndef __FILE_CH_H__
#define __FILE_CH_H__
#include "Cellule.h"
// partie specifique uniquement //////////////////////////
// representation memoire

struct xFile {
	cellule *deb, 
	        *fin; // les deux sont des cellule *
};

#endif
