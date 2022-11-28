public class MathFunctions {

    /**
    * Methode zur berechnung von nullstellen mit der PQ Formel
    *
    * @param p der wert p als double für die PQ Formel
    * @param q der wert p als double für die PQ Formel
     */
    public static String berechneNullstellen (double p, double q){
        // Definition der Variablen discriminant, retZeroPoints, zeroPoint1, zeroPoint2
        double discriminant = Math.pow( p/2 ,2 ) - q; // Berechnung der Discriminanten
        String retZeroPoints = "Es wurde noch nichts berechnet"; // Rückgabe der Nullstellen als String mit default ausgabe
        double zeroPoint1 = -p/2 + Math.sqrt(Math.pow(p/2, 2) - q) ; // Nullstelle 1
        double zeroPoint2 = -p/2 - Math.sqrt(Math.pow(p/2, 2) - q) ; // Nullstelle 2

        // Feststellung wieviele nullstellen existiren mit dem aendern der rückgabe variable retZeroPoints
        if (discriminant == 0){
            retZeroPoints = "Doppelte Nullstelle: " + zeroPoint1;
        } else if (discriminant > 0){
            retZeroPoints = "Zwei Nullstellen: " + zeroPoint1 + " | " + zeroPoint2;
        } else if (discriminant < 0){
            retZeroPoints = "Komplexe Nullstellen";
        }


        // Rückgabe des ergebnisses als string
        return retZeroPoints;
    }

    public static int berechneGgt(int zahl1, int zahl2){
        int ausgabe = 0;

        if (zahl1 == 0){
            ausgabe = zahl2;
        } else {
            while (zahl2 != 0) {
                if (zahl1 > zahl2){

                }
            }
        }
        return ausgabe;
    }
}
