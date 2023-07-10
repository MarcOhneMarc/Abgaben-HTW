//
// Created by Jonas on 08.07.2023.
//
#include "stdio.h"
#include "mechanischeGroessen.h"

Geschwindigkeit berechneGeschwindigkeit(Strecke delta_s, Zeit delta_t) {
    return delta_s / delta_t;
}

Beschleunigung berechneBeschleunigung(Geschwindigkeit delta_v, Zeit delta_t) {
    return delta_v / delta_t;
}

Impuls berechneImpuls(Masse m, Geschwindigkeit v) {
    return m * v;
}

/*void main() {
    Geschwindigkeit geschwindigkeit;
    geschwindigkeit = berechneGeschwindigkeit(10, 3);
    printf("\n %f", geschwindigkeit);

    Geschwindigkeit beschleunigung;
    beschleunigung = berechneBeschleunigung(10, 3);
    printf("\n %f", beschleunigung);

    Impuls impuls;
    impuls = berechneImpuls(3, 3);
    printf("\n %f", impuls);
}
*/