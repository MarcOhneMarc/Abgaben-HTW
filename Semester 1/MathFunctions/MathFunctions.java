import java.util.InputMismatchException;
/**
 * Programm zum Berechnen verschiedener Mathematischer Funktionen.
 * 
 * @Jonas Neu & Marc Perwark
 */
public class MathFunctions {
    /**
     * Privater Standardkonstruktor damit kein Objekt erzeugt werden kann.
     */
    private MathFunctions() {
    }
    
    /**
     * Methode zum berechnen der Teilersumme einer Zahl.
     *
     * @param zahl ist die Zahl, von der die Teilersumme ausgerechnet werden soll als long
     * @return teilersumme gibt Teilersumme der Zahl zurück.
     */
    public static long berechneTeilersumme(long zahl) {
        if (zahl <= 0) {
            throw new IllegalArgumentException("Zahl muss groeßer als 0 sein.");
        } else {
            int teilersumme = 0; // initialisierung der Teilersumme
            
            // Berechnung der Summe aller Teiler der Zahl.
            for (int i = 1; i < zahl+1; i++) {
                if (zahl % i == 0) {
                    teilersumme = teilersumme + i;
                }
            }
            
            return teilersumme;
        }
    }
    
    /**
     * Methode zum berechnen der Checksumme einer 10-Stelligen ISBN-Nummer.
     *
     * @param isbn ist die ISBN Nummer ohne Pruefzifferals, von der die Pruefzifferals als long ausgerechnet werden soll.
     * @return pruefziffer gibt die prüfziffer, die aus den ersten 9 Zahlen generiert wird zurück.
     */
    public static String berechneChecksummeIsbn(long isbn) {
        if (String.valueOf(isbn).length() != 9) {
            throw new IllegalAccessError("Die ISBN Nummer muss groeßer als 0 und 9-Stellig sein.");
        } else {
            String pruefziffer = ""; // initialisierung der pruefziffer als String
            long summe = 0; // Zwischensumme zur berechnung der Pruefzffer
            int i = 9; // Index zum Berechnen der Prüfziffer
            
            // Errechnung der Summe der 9 ISBN Stellen multipliziert mit der Stelle, an der sie sich befinden.
            while(isbn > 0) {
                summe = summe + i * (isbn % 10);
                isbn = isbn / 10;
                i--;
            }
            
            // Berechnung der endgueltigen Pruefziffer und Uebergabe in den Rueckgabestring.
            if (summe % 11 == 10) {
                pruefziffer = "X";
            } else {
                pruefziffer = pruefziffer + summe % 11;
            }
            return pruefziffer;
        }
    }
    
    /**
     * Methode zur Berechnung von Nullstellen mit der PQ Formel.
     *
     * @param p der Wert p als double für die PQ Formel
     * @param q der Wert p als double für die PQ Formel
     */
    public static String berechneNullstellen(double p, double q){
        double negativFastNull = -0.000000001;
        double positivFastNull = 0.000000001;
        // Definition der Variablen discriminant, retZeroPoints, zeroPoint1, zeroPoint2
        double discriminant = Math.pow( p/2 ,2 ) - q; // Berechnung der Discriminanten
        String retZeroPoints = "Es wurde noch nichts berechnet"; // Rückgabe der Nullstellen als String mit default ausgabe
        double zeroPoint1 = -p/2 + Math.sqrt(Math.pow(p/2, 2) - q) ; // Nullstelle 1
        double zeroPoint2 = -p/2 - Math.sqrt(Math.pow(p/2, 2) - q) ; // Nullstelle 2
        // Feststellung der Anzahl der Nullstellen und dementsprechende aenderung der Rueckgabe-Variable retZeroPoints
        if (discriminant == 0){
            retZeroPoints = "Doppelte Nullstelle: " + zeroPoint1;
        } else if (discriminant <= positivFastNull && discriminant >= negativFastNull){
            retZeroPoints = "Zwei Nullstellen: " + zeroPoint1 + " | " + zeroPoint2;
        } else if (discriminant < 0){
            retZeroPoints = "Komplexe Nullstellen";
        }
        // Rückgabe des Ergebnisses als String
        return retZeroPoints;
    }
    
    /**
     * Dient der pruefung, ob man die uebergebene Zahl als a hoch 4, b hoch 3 und c hoch 2 darstellen kann
     *
     * @param zahl ist die zu pruefende Zahl als lange natuerliche Zahl (long)
     * @return returnedBool gibt einen boolschen wert zur Aussage, ob es moeglich ist zurueck
     */
    public static boolean istSummeVonPotenzen(long zahl){
        boolean returnedBool = false; // Definition des Rueckgabe Booleans
        
        if (zahl <= 0 || zahl % 1 != 0) {
            throw new IllegalArgumentException("Die eingegebene Zahl ist nicht natuerlich!");
        } else {
            long checkSum = 0; // Definition der Pruef Summe
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
        }
        return returnedBool;
    }

    /**
     *
     * Methode berechneGgt dient der berechnung des groessten gemeinsamen teilers zweier Natuerlicher ganzzahliger Zahlen
     *
     * @param zahl1 eine natuerliche ganzzahlige Zahl die der Methode uebergeben wird
     * @param zahl2 eine natuerliche ganzzahlige Zahl die der Mehtode uebergeben wird
     * @return returnedGgt gibt den groesten gemeinsamen teiler der uebergeben zahlen zurueck
     */
    public static int berechneGgt(int zahl1, int zahl2){
        int returnedGgt = 0; // Definition der Rueckgabe variable
        if (zahl1 <= 0 || zahl2 <= 0  || zahl1 % 1 != 0 || zahl2 % 1 != 0) {
            throw new IllegalArgumentException("Die eingegebene Zahl ist nicht natuerlich!");
        } else {
            // Berechnung des groessten gemeinsamen teiler
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
        }
        return returnedGgt;
    }
    
    /**
     * Methode zur berechnung der Fakultaet einer Zahl
     *
     * @param zahl zahl als int, dessen Fakultaet berechnet werden soll
     * @return fakultaet fakultaet ist die Fakultaet der zahl die eingegeben wurde
     */
    public static long berechneFakultaet(int zahl) {
        if (zahl <= 0) {
            throw new IllegalArgumentException("Die Zahl darf nicht negativ oder 0 sein!");
        } else {
            long fakultaet = 1;
            for (int i = 1; i <= zahl; i++) {
                fakultaet = fakultaet * i;
            }
            return fakultaet;
        }
    }
    
    /**
     * Methode zur berechnung einer Reihensumme
     *
     * @param anzahl gibt die anzahl der Schleifendurchlaeufe an
     * @param x wird als ganzzahl in die funktion eingesetzt
     * @return ergebnis gibt das ergebnis zurueck
     */
    public static double berechneReihensumme(int anzahl, double x) {
        if (anzahl <= 0) {
            throw new IllegalArgumentException("Die Zahl darf nicht negativ oder 0 sein!");
        } else {
            double ergebnis = 0;
            for (int i = 1; i <= anzahl; i++) {
                ergebnis = ergebnis + ((Math.pow((x-1), i))/(i*(Math.pow(x, i))));
            }
            return ergebnis;
        }
    }
}