//
// Created by Jonas on 09.07.2023.
//

#include "geradlinigeBewegungen.h"

Strecke berechneStreckeGleichfoermigeBewegung(Geschwindigkeit v, Zeit t, Zeit t0) {
    return v * (t - t0);
}

Strecke berechneStreckeGleichmaessigBeschleunigteBewegung(Geschwindigkeit v0, Geschwindigkeit v, Beschleunigung a) {
    return (v * v - v0 * v0) / (2 * a);
}

Geschwindigkeit berechneGeschwindigkeitGleichmaessigBeschleunigteBewegung(Beschleunigung a, Zeit t, Zeit t0, Geschwindigkeit v0) {
    return a * (t - t0) + v0;
}
