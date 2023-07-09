//
// Created by Jonas on 09.07.2023.
//

#ifndef SEMESTER_2_GERADLINIGEBEWEGUNGEN_H
#define SEMESTER_2_GERADLINIGEBEWEGUNGEN_H

#include "mechanischeGroessen.h"

Strecke berechneStreckeGleichfoermigeBewegung(Geschwindigkeit v, Zeit t, Zeit t0);
Strecke berechneStreckeGleichmaessigBeschleunigteBewegung(Geschwindigkeit v0, Geschwindigkeit v, Beschleunigung a);
Geschwindigkeit berechneGeschwindigkeitGleichmaessigBeschleunigteBewegung(Beschleunigung a, Zeit t, Zeit t0, Geschwindigkeit v0);


#endif //SEMESTER_2_GERADLINIGEBEWEGUNGEN_H
