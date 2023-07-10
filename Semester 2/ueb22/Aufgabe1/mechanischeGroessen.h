//
// Created by Jonas on 08.07.2023.
//

#ifndef MECHANISCHEGROESSEN_H
#define MECHANISCHEGROESSEN_H

typedef float Strecke;
typedef float Zeit;
typedef float Geschwindigkeit;
typedef float Beschleunigung;
typedef float Impuls;
typedef float Masse;

Geschwindigkeit berechneGeschwindigkeit(Strecke delta_s, Zeit delta_t);
Beschleunigung berechneBeschleunigung(Geschwindigkeit delta_v, Zeit delta_t);
Impuls berechneImpuls(Masse m, Geschwindigkeit v);

#endif