//
// Created by Jonas on 09.07.2023.
//

#ifndef GERADLINIGEBEWEGUNGEN_H
#define GERADLINIGEBEWEGUNGEN_H

#include "mechanischeGroessen.h"

Strecke berechneStreckeGleichfoermigeBewegung(Geschwindigkeit v, Zeit t, Zeit t0);
Strecke berechneStreckeGleichmaessigBeschleunigteBewegung(Geschwindigkeit v0, Geschwindigkeit v, Beschleunigung a);
Geschwindigkeit berechneGeschwindigkeitGleichmaessigBeschleunigteBewegung(Beschleunigung a, Zeit t, Zeit t0, Geschwindigkeit v0);


#endif