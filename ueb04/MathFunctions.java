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


    /**
     *
     * Dient der pruefung, ob man die uebergebene zahl als ahoch4 + bhoch3 + choch2 darstellen kann
     *
     * @param zahl die zupruefende zahl als Lange Natuerliche Zahl (long)
     * @return Rueckgabe eines boolschen werts zur Aussage, ob es moeglich ist
     */
    public static boolean istSummeVonPotenzen(long zahl){
        long checkSum = 0; // Definition der Pruef Summe
        boolean returnedBool = false; // Definition des Rueckgabe Booleans
        double maxBaseA = (Math.pow(zahl,(1.0/4.0))); // Definition der maximalen basis fuer hoch 4
        double maxBaseB = (Math.pow(zahl,(1.0/3.0))); // Definition der maximalen basis fuer hoch 3
        double maxBaseC = (Math.pow(zahl,(1.0/2.0))); // Definition der maximalen basis fuer hoch 2

        // Ueberpruefung der verschiedenen basen a, b, und c
        for (int a = 1; a <= maxBaseA; a++){
            for (int b = 1; b <= maxBaseB;  b++){
                for (int c = 1; c <= maxBaseC;  c++){
                    checkSum = (long)Math.pow(a,4) + (long)Math.pow(b,3) + (long)Math.pow(c,2);
                    if (checkSum == zahl){
                        returnedBool = true;
                        break;
                    }
                }
            }
        }
        return returnedBool;
    }

    /**
     *
     * Methode berechneGgt dient der berechnung des groesten gemeinsamen teilers zweier Natuerlicher ganzzahliger Zahlen
     *
     * @param zahl1 eine Natuerliche ganzyahlige zahl die der mehtode uebergeben wird
     * @param zahl2 eine Natuerliche ganzyahlige zahl die der mehtode uebergeben wird
     * @return des groesten gemeinsamen teilers der uebergeben zahlen
     */
    public static int berechneGgt(int zahl1, int zahl2){
        int returnedGgt = 0; // Definition der Rueckgabe variable

        // Berechnung des Groesten gemeinsamen teiler
        if (zahl1 == 0){
            returnedGgt = zahl2;
        } else {
            while (zahl2 != 0) {
                if (zahl1 > zahl2){
                    zahl1 = zahl1 - zahl2;
                } else {
                    zahl2 = zahl2- zahl1;
                }
            }
        }
        returnedGgt = zahl1;
        return returnedGgt;
    }
}
