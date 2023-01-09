public class Mittelwert {

    public ArrayFunctions arrayFunctions; // Aufruf der ArrayFunctions Klasse
    private double mittelwert; // Initialisirung der Instanz Variable Mittelwert
    private double naechster; // Initialisirung der Instanz Variable naechster
    private double entferntester; // Initialisirung der Instanz Variable entfernteser

    /**
     * Konstrucktor zum Erzeugen des Mittelwertobjekts
     *
     * @param mittelwert ist der uebergebner Mittelwert
     * @param entferntester ist der uebergebene wert mit der weitesten entfernung zum median
     * @param naechster ist der uebergebene wert mit der geringsten entfernung zum mittelwert
     */
    public Mittelwert(double mittelwert, double entferntester, double naechster){
        this.mittelwert = mittelwert;
        this.naechster = naechster;
        this.entferntester = entferntester;
    }

    /**
     * Get Methode fuer Mittelwert
     * @return die Instanzvariable Mittelwert
     */
    public double getMittelwert(){
        return mittelwert;
    }

    /**
     * Get Methode fuer naechster
     * @return die Instanzvariable naechster
     */
    public double getMin(){
        return naechster;
    }

    /**
     * Get Methode fuer entferntester
     * @return die Instanzvariable entferntester
     */
    public double getMax(){
        return entferntester;
    }

}
