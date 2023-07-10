#include <stdio.h>
#include <string.h>

#define MAX_MARKE_LENGTH 20
#define MAX_SONDERAUSSTATTUNG 10
#define MAX_AUSSTATTUNG_LENGTH 100
#define MAX_AUTOS 10

typedef struct {
    int ps;
    int zylinder;
    int hubraum;
} Motor;

typedef struct {
    char marke[MAX_MARKE_LENGTH + 1];
    int max_geschwindigkeit;
    int tuerenanzahl;
    int abs;
    char sonderausstattung[MAX_SONDERAUSSTATTUNG][MAX_AUSSTATTUNG_LENGTH + 1];
    int anzahl_sonderausstattung;
    Motor motor;
} Auto;

Auto erstelleAuto(char marke[], int max_geschwindigkeit, int tuerenanzahl, int abs,
                  char sonderausstattung[][MAX_AUSSTATTUNG_LENGTH + 1], int anzahl_sonderausstattung,
                  int ps, int zylinder, int hubraum) {
    Auto autoObjekt;
    strncpy(autoObjekt.marke, marke, MAX_MARKE_LENGTH);
    autoObjekt.marke[MAX_MARKE_LENGTH] = '\0';
    autoObjekt.max_geschwindigkeit = max_geschwindigkeit;
    autoObjekt.tuerenanzahl = tuerenanzahl;
    autoObjekt.abs = abs;
    autoObjekt.anzahl_sonderausstattung = anzahl_sonderausstattung;
    for (int i = 0; i < anzahl_sonderausstattung; i++) {
        strncpy(autoObjekt.sonderausstattung[i], sonderausstattung[i], MAX_AUSSTATTUNG_LENGTH);
        autoObjekt.sonderausstattung[i][MAX_AUSSTATTUNG_LENGTH] = '\0';
    }
    autoObjekt.motor.ps = ps;
    autoObjekt.motor.zylinder = zylinder;
    autoObjekt.motor.hubraum = hubraum;
    return autoObjekt;
}

int schaetzeWert(Auto autoObjekt) {
    int wert = autoObjekt.max_geschwindigkeit * 50;
    wert *= autoObjekt.tuerenanzahl;
    if (autoObjekt.abs)
        wert += 5000;
    wert += autoObjekt.anzahl_sonderausstattung * 3000;
    if (strcmp(autoObjekt.marke, "Porsche") == 0)
        wert *= 2;
    return wert;
}

void printAuto(Auto autoObjekt) {
    printf("Marke: %s\n", autoObjekt.marke);
    printf("Maximale Geschwindigkeit: %d km/h\n", autoObjekt.max_geschwindigkeit);
    printf("Anzahl der Türen: %d\n", autoObjekt.tuerenanzahl);
    printf("ABS: %s\n", autoObjekt.abs ? "Ja" : "Nein");
    printf("Sonderausstattung:\n");
    for (int i = 0; i < autoObjekt.anzahl_sonderausstattung; i++) {
        printf("- %s\n", autoObjekt.sonderausstattung[i]);
    }
    printf("Motor:\n");
    printf("PS: %d\n", autoObjekt.motor.ps);
    printf("Zylinder: %d\n", autoObjekt.motor.zylinder);
    printf("Hubraum: %d\n", autoObjekt.motor.hubraum);
}

int main() {
    Auto autos[MAX_AUTOS];
    int anzahl_autos = 0;

    int auswahl = 0;
    while (auswahl != 3) {
        printf("Menü:\n");
        printf("1. Auto erstellen\n");
        printf("2. Autos anzeigen\n");
        printf("3. Beenden\n");
        printf("Auswahl treffen: ");
        scanf("%d", &auswahl);

        switch (auswahl) {
            case 1: {
                if (anzahl_autos >= MAX_AUTOS) {
                    printf("Es können keine weiteren Autos erstellt werden. Maximale Anzahl erreicht.\n");
                } else {
                    char marke[MAX_MARKE_LENGTH + 1];
                    int max_geschwindigkeit;
                    int tuerenanzahl;
                    int abs;
                    char sonderausstattung[MAX_SONDERAUSSTATTUNG][MAX_AUSSTATTUNG_LENGTH + 1];
                    int anzahl_sonderausstattung;
                    int ps;
                    int zylinder;
                    int hubraum;

                    printf("Bitte geben Sie die Marke des Autos ein: ");
                    scanf("%s", marke);

                    printf("Bitte geben Sie die maximale Geschwindigkeit des Autos ein: ");
                    scanf("%d", &max_geschwindigkeit);

                    printf("Bitte geben Sie die Anzahl der Türen des Autos ein: ");
                    scanf("%d", &tuerenanzahl);

                    printf("Hat das Auto ABS? (1 für Ja, 0 für Nein): ");
                    scanf("%d", &abs);

                    printf("Bitte geben Sie die Anzahl der Sonderausstattungen ein: ");
                    scanf("%d", &anzahl_sonderausstattung);

                    printf("Bitte geben Sie die Sonderausstattungen des Autos ein:\n");
                    for (int i = 0; i < anzahl_sonderausstattung; i++) {
                        printf("Sonderausstattung %d: ", i + 1);
                        scanf("%s", sonderausstattung[i]);
                    }

                    printf("Bitte geben Sie die PS des Motors ein: ");
                    scanf("%d", &ps);

                    printf("Bitte geben Sie die Anzahl der Zylinder des Motors ein: ");
                    scanf("%d", &zylinder);

                    printf("Bitte geben Sie den Hubraum des Motors ein: ");
                    scanf("%d", &hubraum);

                    autos[anzahl_autos] = erstelleAuto(marke, max_geschwindigkeit, tuerenanzahl, abs, sonderausstattung, anzahl_sonderausstattung, ps, zylinder, hubraum);
                    anzahl_autos++;

                    printf("Das Auto wurde erstellt.\n\n");
                }
                break;
            }
            case 2: {
                if (anzahl_autos == 0) {
                    printf("Es sind keine Autos vorhanden.\n\n");
                } else {
                    printf("Alle Autos:\n");
                    for (int i = 0; i < anzahl_autos; i++) {
                        printf("Auto %d:\n", i + 1);
                        printAuto(autos[i]);
                        printf("Geschätzter Wert: %d\n\n", schaetzeWert(autos[i]));
                    }
                }
                break;
            }
            case 3: {
                printf("Programm wird beendet.\n");
                break;
            }
            default: {
                printf("Ungültige Auswahl. Bitte geben Sie eine Zahl zwischen 1 und 3 ein.\n\n");
                break;
            }
        }
    }

    return 0;
}