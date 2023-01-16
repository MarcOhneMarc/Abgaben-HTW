public class Video extends Artikel{
    private int spieldauer;
    private int jahr;
    private String titel;

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
        this.spieldauer = spieldauer;
        this.titel = titel;
        this.jahr = jahr;
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
        Video other = (Video) obj;
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
        return "Titel: " + titel + " Spieldauer: " + spieldauer + " Erscheinungsjahr: " + jahr;
    }

    /**
     * Methode zum ausgeben der Attribute eines Videos als Zeichenkette
     */
    @Override
    public String toString(){
        String ausgabe = String.format("%-10d %-60s %8.2f %10d", artikelNr, getBeschreibung(), preis, bestand);
        return ausgabe;
    }
}
