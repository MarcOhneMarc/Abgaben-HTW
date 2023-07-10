//
// Created by Jonas on 10.07.2023.
//
#include <stdio.h>
#include "mechanischeGroessen.h"
#include "geradlinigeBewegungen.h"
#include "mechanischeGroessen.c"
#include "geradlinigeBewegungen.c"

int getAuswahl() {
        printf("\nWas soll berechnet werden?");
        printf("\n[1] Geschwindigkeit");
        printf("\n[2] Beschleunigung");
        printf("\n[3] Impuls");
        printf("\n[4] Strecke fuer gleichfoermige Bewegung");
        printf("\n[5] Strecke fuer gleichmaessig beschleunigte Bewegung");
        printf("\n[6] Geschwindigkeit fuer gleichmaessig beschleunigte Bewegung");
        printf("\n[7] Beenden\n");

        int auswahl;
        scanf("\n%d", &auswahl);
        return auswahl;
}

void berechneGeschwindigkeitDialog() {
    Strecke delta_s;
    Zeit delta_t;
    printf("\nGeben Sie die Strecke ein (delta_s): ");
    scanf("\n%f", &delta_s);
    printf("\nGeben Sie die Zeit ein (delta_t): ");
    scanf("\n%f", &delta_t);

    Geschwindigkeit v = berechneGeschwindigkeit(delta_s, delta_t);
    printf("\nDie Geschwindigkeit betraegt: %.2f\n", v);
}

void berechneBeschleunigungDialog() {
    Geschwindigkeit delta_v;
    Zeit delta_t;
    printf("\nGeben Sie die Geschwindigkeitsaenderung (delta_v): ");
    scanf("\n%f", &delta_v);
    printf("\nGeben Sie die Zeit (delta_t): ");
    scanf("\n%f", &delta_t);

    Beschleunigung a = berechneBeschleunigung(delta_v, delta_t);
    printf("\nDie Beschleunigung betraegt: %.2f\n", a);
}

void berechneImpulsDialog() {
    Masse m;
    Geschwindigkeit v;
    printf("\nGeben Sie die Masse (m): ");
    scanf("\n%f", &m);
    printf("\nGeben Sie die Geschwindigkeit (v): ");
    scanf("\n%f", &v);

    Impuls p = berechneImpuls(m, v);
    printf("\nDer Impuls betraegt: %.2f\n", p);
}

void berechneStreckeGleichfoermigeBewegungDialog() {
    Geschwindigkeit v;
    Zeit t, t0;
    printf("\nGeben Sie die Geschwindigkeit (v): ");
    scanf("\n%f", &v);
    printf("\nGeben Sie die Zeit (t): ");
    scanf("\n%f", &t);
    printf("\nGeben Sie die Startzeit (t0): ");
    scanf("\n%f", &t0);

    Strecke s = berechneStreckeGleichfoermigeBewegung(v, t, t0);
    printf("\nDie Strecke fuer die gleichfoermige Bewegung betraegt: %.2f\n", s);
}

void berechneStreckeGleichmaessigBeschleunigteBewegungDialog() {
    Geschwindigkeit v0, v;
    Beschleunigung a;
    printf("\nGeben Sie die Anfangsgeschwindigkeit (v0): ");
    scanf("\n%f", &v0);
    printf("\nGeben Sie die Endgeschwindigkeit (v): ");
    scanf("\n%f", &v);
    printf("\nGeben Sie die Beschleunigung (a): ");
    scanf("\n%f", &a);

    Strecke s = berechneStreckeGleichmaessigBeschleunigteBewegung(v0, v, a);
    printf("\nDie Strecke fuer die gleichmaessig beschleunigte Bewegung betraegt: %.2f\n", s);
}

void berechneGeschwindigkeitGleichmaessigBeschleunigteBewegungDialog() {
    Beschleunigung a;
    Zeit t, t0;
    Geschwindigkeit v0;
    printf("\nGeben Sie die Beschleunigung (a): ");
    scanf("\n%f", &a);
    printf("\nGeben Sie die Zeit (t): ");
    scanf("\n%f", &t);
    printf("\nGeben Sie die Startzeit (t0): ");
    scanf("\n%f", &t0);
    printf("\nGeben Sie die Anfangsgeschwindigkeit (v0): ");
    scanf("\n%f", &v0);

    Geschwindigkeit v = berechneGeschwindigkeitGleichmaessigBeschleunigteBewegung(a, t, t0, v0);
    printf("\nDie Geschwindigkeit fuer die gleichmaessig beschleunigte Bewegung betraegt: %.2f\n", v);
}

int main() {
    while (1) {
        int auswahl = getAuswahl();
        switch (auswahl) {
            case 1:
                berechneGeschwindigkeitDialog();
                break;
            case 2:
                berechneBeschleunigungDialog();
                break;
            case 3:
                berechneImpulsDialog();
                break;
            case 4:
                berechneStreckeGleichfoermigeBewegungDialog();
                break;
            case 5:
                berechneStreckeGleichmaessigBeschleunigteBewegungDialog();
                break;
            case 6:
                berechneGeschwindigkeitGleichmaessigBeschleunigteBewegungDialog();
                break;
            case 7:
                printf("\nAuf Wiedersehen!\n");
                return 0;
            default:
                printf("\nUngueltige Auswahl. Bitte waehlen Sie erneut.\n");
                break;
        }
    }
}