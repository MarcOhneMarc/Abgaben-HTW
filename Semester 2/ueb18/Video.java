public class Video extends Artikel{
    private int spieldauer;
    private int jahr;
    private String titel;

    private static final String TITEL_NICHT_LEER = "'Titel' darf nicht leer sein!";
    private static final String SPIELDAUER_NICHT_NULL = "Spieldauer ist ungueltig!";
    private static final String UNGUELTIGES_ERSCHEINUNGSJAHR = "Ungueltiges Erscheinungsjahr";

    /**
     * Konstruktor zum initialisiern eines Video
     *
     * @param artikelNr ist die Artikelnummer als vierstellige Ganzzahl
     * @param bestand ist der Bestand als Ganzzahl
     * @param preis ist der Preis des Atikels
     * @param spieldauer ist die Spieldauer des Videos
     * @param titel ist der Titel des Videos
     * @param jahr ist das Jahr, in dem das Video erschienen ist als Ganzzahl
     */
    public Video(int artikelNr, int bestand, double preis, String titel, int spieldauer, int jahr){
        super(artikelNr,"Medien",bestand,preis);
        if (titel == null)
            throw new IllegalArgumentException(TITEL_NICHT_LEER);
        if (spieldauer < 0)
            throw new IllegalArgumentException(SPIELDAUER_NICHT_NULL);
        if (jahr < 1900 || jahr > 2022)
            throw new IllegalArgumentException(UNGUELTIGES_ERSCHEINUNGSJAHR);
        this.spieldauer = spieldauer;
        this.titel = titel;
        this.jahr = jahr;
    }

    /**
     * Methode zum Vergleichen von einem Artikel mit einem anderen
     *
     * @param Video ist das Objekt, dass verglichen werden soll
     */
    @Override
    public boolean equals(Object Video){
        if (this == Video)
            return true;
        if (Video == null)
            return false;
        if (getClass() != Video.getClass())
            return false;
        Video other = (Video) Video;
        if (titel == null ){
            if (other.titel != null)
                return false;
        } else if (!titel.equals(other.titel))
            return false;
        return true;
    }
    
    /**
     * get Methode zum weitergeben der Beschreibung eines Videos an die toString Methode
     */
    @Override
    public String getBeschreibung(){
        return titel;
    }

    /**
     * Methode zum ausgeben der Attribute eines Videos als Zeichenkette
     */
    @Override
    public String toString(){
        return String.format("%-10d %-60s %8.2f %10d", artikelNr, getBeschreibung(), preis, bestand);
    }
}
