public class CD extends Artikel{
    //initialisierung der Attribute
    private String interpret;
    private String titel;
    private int anzahlTitel;
    private static final String TITEL_NICHT_LEER = "'Titel' darf nicht leer sein!";
    private static final String INTERPRET_NICHT_NULL = "Interpret darf nicht null sein";
    private static final String ANZAHL_TITEL_UNGUELTIG = "Anzahl Titel muss Posiv sein";

    /**
     * Konstruktor zum initialisiern einer CD
     *
     * @param artikelNr ist die Artikelnummer als vierstellige Ganzzahl
     * @param bestand ist der Bestand als Ganzzahl
     * @param preis ist der Preis des Atikels
     * @param interpret ist der Interpret, der die CD erstellt hat
     * @param titel ist der Titel der CD
     * @param anzahlTitel ist die Anzahl der Titel als Ganzzahl
     */
    public CD(int artikelNr, int bestand, double preis, String interpret, String titel, int anzahlTitel){
        super(artikelNr, "Medien", bestand, preis);
        if (interpret == null)
            throw new IllegalArgumentException(INTERPRET_NICHT_NULL);
        if (titel == null)
            throw new IllegalArgumentException(TITEL_NICHT_LEER);
        if (anzahlTitel < 0)
            throw new IllegalArgumentException(ANZAHL_TITEL_UNGUELTIG);
        this.interpret = interpret;
        this.titel = titel;
        this.anzahlTitel = anzahlTitel;
    }

    /**
     * Methode zum Vergleichen von einem Artikel mit einem anderen
     *
     * @param CD ist das Objekt, dass verglichen werden soll
     */
    @Override
    public boolean equals(Object CD){
        if (this == CD)
            return true;
        if (CD == null)
            return false;
        if (getClass() != CD.getClass())
            return false;
        CD other = (CD) CD;
        if (titel == null ){
            if (other.titel != null)
                return false;
        } else if (!titel.equals(other.titel))
            return false;
        if (interpret == null ){
            if (other.interpret != null)
                return false;
        } else if (!interpret.equals(other.interpret))
            return false;
        return true;
    }
    
    /**
     * get Methode zum weitergeben der Beschreibung einer CD an die toString Methode
     */
    @Override
    public String getBeschreibung(){
        return "Interpert: " + interpret + " Titel: "+ titel;
    }

    /**
     * Methode zum ausgeben der Attribute einer CD als Zeichenkette
     */
    @Override
    public String toString(){
        return String.format("%-10d %-60s %8.2f %10d", artikelNr, getBeschreibung(), preis, bestand);
    }
}