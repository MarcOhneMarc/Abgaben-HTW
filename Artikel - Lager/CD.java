public class CD extends Artikel{
    //initialisierung der Attribute
    private String interpret;
    private String titel;
    private int anzahlTitel;

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
            throw new IllegalArgumentException("Der Interpret darf nicht null sein");
        if (titel == null)
            throw new IllegalArgumentException("Der Titel darf nicht leer sein");
        if (anzahlTitel < 0)
            throw new IllegalArgumentException("Du must eine Posivive zahl als Titel anzahl eingeben");
        this.interpret = interpret;
        this.titel = titel;
        this.anzahlTitel = anzahlTitel;
    }

    /**
     * Methode zum Vergleichen von einem Artikel mit einem anderen
     *
     * @param obj ist das Objekt, dass verglichen werden soll
     */
    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CD other = (CD) obj;
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
        String ausgabe = String.format("%-10d %-60s %8.2f %10d", artikelNr, getBeschreibung(), preis, bestand);
        return ausgabe;
    }
}