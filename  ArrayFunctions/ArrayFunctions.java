public class ArrayFunctions {

    /**
     * Privater Konstrucktor
     */
    private ArrayFunctions() {
    }

    /**
     * berechneMittelwert ist eine Methode zur berechnung des Mittelwerts aus einem uebergebenen Array
     *
     * @param messwerte werden als double Array uebergeben und stellen die zu analysirenden daten da
     * @return Erzeugen eines Objekts in der Klasse Mittelwert
     */
    public static Mittelwert berechneMittelwert(double[] messwerte){
        
        if (messwerte.length == 0){
            throw new IllegalArgumentException("'Art' darf nicht leer sein!");
        } else {
            
            double summe = 0; // Initialisirung der variable summe die, die summe der zahlen im Array darstellt
            double median = 0; // Initialisirung der Median variable die den Mittelwert speichert
            double naechsterwert = messwerte[0]; // Initialisirung einer Vaibale die den naechsten wert zum Median Darstellt
            double entferntesterwert = messwerte[0]; // Initialisirung einer Vaibale die den Entferntesten wert zum Median Darstellt


            // Berechnung der Summe
            for(int i = 0; i < messwerte.length; i++){
                summe = summe + messwerte[i];
            }
            median = summe/messwerte.length; // Berechnug des Median

            // Berechnung des Naechesten und entferntesten wertes
            for(int i = 0; i < messwerte.length; i++){
                if (Math.abs((messwerte[i] - median)) < Math.abs((naechsterwert - median))){
                    naechsterwert = messwerte[i];
                } else if (Math.abs((messwerte[i] - median)) > Math.abs((entferntesterwert - median))){
                    entferntesterwert = messwerte[i];
                }
            }
            // Das Return Statement erzuegt dirket ein Objekt in der mittelwert Klasse
            return new Mittelwert(median,entferntesterwert,naechsterwert);
        
        }
    }

    /**
     * Methode die bestimmt wiefiele gross und kleingeschriebene woerter in einem Strig array existirern
     * @param strings Uebergebeber String Array
     * @return ruebgabe des Ergebnisses
     */
    public static int stringsAuswerten(String[] strings){
        int uebergabe = 0; // Initialisirung der Uebergabe Variable die spaeter veraendert und zurueckgegeben wird

        if (strings == null){
            throw new IllegalArgumentException("'Art' darf nicht leer sein!");
        }

        // Die bestimmung der Gross und klein geschriebenen woerter
        for (int i = 0; i< strings.length; i++){
            if ((strings[i].toUpperCase()).equals(strings[i]) || (strings[i].toLowerCase()).equals(strings[i])) {
                uebergabe++;
            }
        }

        return uebergabe;
    }
}