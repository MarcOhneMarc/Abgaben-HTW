public class Buch extends Artikel {
    //initialisierung der Attribute
    private String titel;
    private String autor;
    private String verlag;
    private static final String TITEL_NICHT_LEER = "Der Titel darf nicht leer sein";
    private static final String SPIELDAUER_NICHT_LEER = "Der Autor darf nicht null sein";
    private static final String VERLAG_NICHT_LEER = "Der verlag darf nicht null sein";
    
    /**
     * Konstruktor zum initialisiern eines Buches
     *
     * @param artikelNr ist die Artikelnummer als vierstellige Ganzzahl
     * @param bestand ist der Bestand als Ganzzahl
     * @param preis ist der Preis des Atikels
     * @param verlag ist der Verlag, der das Buch herausgebracht hat
     * @param titel ist der Titel des Buches
     * @param autor ist der Autor, der das Buch geschrieben hat
     */
    public Buch(int artikelNr, int bestand, double preis, String verlag, String titel, String autor){
        super(artikelNr,"Medien",bestand,preis);
        if (titel == null)
            throw new IllegalArgumentException(TITEL_NICHT_LEER);
        if (autor == null)
            throw new IllegalArgumentException(SPIELDAUER_NICHT_LEER);
        if (verlag == null)
            throw new IllegalArgumentException(VERLAG_NICHT_LEER);
        this.verlag = verlag;
        this.titel = titel;
        this.autor = autor;
    }
    
    /**
     * Methode zum Vergleichen von einem Artikel mit einem anderen
     *
     * @param Buch ist das Objekt, dass verglichen werden soll
     */
    @Override
    public boolean equals(Object Buch){
        if (this == Buch)
            return true;
        if (Buch == null)
            return false;
        if (getClass() != Buch.getClass())
            return false;
        Buch other = (Buch) Buch;
        if (titel == null && autor == null){
            if (other.titel != null && other.autor != null)
                return false;
        } else if (!titel.equals(other.titel) && !autor.equals(other.autor))
            return false;

        return true;
    }

    /**
     * get Methode zum weitergeben der Beschreibung eines Buches an die toString Methode
     */
    @Override
    public String getBeschreibung(){
        return "Autor: " + autor + " Titel: " + titel + " Verlag: " + verlag;
    }

    /**
     * Methode zum ausgeben der Attribute eines Buches als Zeichenkette
     */
    @Override
    public String toString(){
        return String.format("%-10d %-60s %8.2f %10d", artikelNr, getBeschreibung(), preis, bestand);
    }
}