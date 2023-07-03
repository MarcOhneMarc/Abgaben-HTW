//
// Created by Jonas on 03.07.2023.
//
#include <stdio.h>

int main() {

    float nettopreis;
    printf("Bitte geben sie den Nettopreis ein: ");
    scanf("%f", &nettopreis);
    float prozentwert = nettopreis * 0.2;
    float bruttopreis = nettopreis * 1.2;
    float skonto = bruttopreis * 0.02;
    float rechnungsbetrag = bruttopreis - skonto;

    printf("\n\n");
    printf("%-20s %5s %7.2f\n", "Nettopreis:", "Euro", nettopreis);
    printf("%-20s %5s %7.2f\n", "+ 20% MwSt:", "Euro", prozentwert);
    printf("==================================\n");
    printf("%-20s %5s %7.2f\n", "Bruttopreis:", "Euro", bruttopreis);
    printf("%-20s %5s %7.2f\n", "- 2% Skonto:", "Euro", skonto);
    printf("==================================\n");
    printf("%-20s %5s %7.2f\n", "Rechnungsbetrag:", "Euro", rechnungsbetrag);

}