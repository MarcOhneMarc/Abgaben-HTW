/**
 * Eine funktionale Schnittstelle, die eine Funktion darstellt,
 * die eine Ganzzahl als Eingabe annimmt und eine Ganzzahl als
 * Ausgabe liefert.
 */
public interface MyFunction {
    /**
     * Wendet die Funktion auf eine gegebene Ganzzahl an und gibt das Ergebnis zurueck.
     *
     * @param i die Ganzzahl, auf die die Funktion angewendet werden soll
     * @return das Ergebnis der Funktion
     */
    int apply(int i);
}