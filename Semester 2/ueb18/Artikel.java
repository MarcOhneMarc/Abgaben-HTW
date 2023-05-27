/**
 * Klasse zum erstellen und Bearbeiten eines Artikels mit den Attributen artikelNr, art, bestand und preis
 *
 * @author Marc Perwark & Jonas Neu
 * 06.11.2022
 */
public class Artikel{
    //initialisierung der Attribute
    protected int artikelNr;
    protected String art;
    protected int bestand;
    protected double preis;
    
    private static final String ART_NICHT_LEER = "'Art' darf nicht leer sein!";
    private static final String ARTIKELNUMMER_NICHT_4STELLIG = "Die Artikelnummer muss 4 Stellen haben!";
    private static final String BESTAND_NEGATIV = "Der Bestand darf nicht negativ sein!";
    private static final String PREIS_NEGATIV = "Der Preis darf nicht negativ sein!";
    private static final String MENGE_NEGATIV = "Die Menge darf nicht negativ sein!";
    
     /**
     * Konstruktor zum initialisiern eines Artikel mit Bestand
     *
     * @param artikelNr ist die Artikelnummer als vierstellige Ganzzahl
     * @param art beschreibt den Artikel (Was ist der Artikel?)
     * @param bestand ist der Bestand als Ganzzahl
     * @param preis ist der Preis des Atikels
     */
    public Artikel(int artikelNr, String art, int bestand, double preis) {
        int anzahlDerStellen = String.valueOf(artikelNr).length();
        if (art == null || art.strip().isEmpty()) {
            throw new IllegalArgumentException(ART_NICHT_LEER);
        } else if (anzahlDerStellen != 4) {
            throw new IllegalArgumentException(ARTIKELNUMMER_NICHT_4STELLIG);
        } else if (bestand < 0) {
            throw new IllegalArgumentException(BESTAND_NEGATIV);
        } else {
            this.artikelNr = artikelNr;
            this.art = art;
            this.bestand = bestand;
            this.preis = preis;
        }
    }

     /**
     * Konstruktor zum initialisiern eines Artikel ohne Bestand
     *
     * @param artikelNr ist die Artikelnummer als vierstellige Ganzzahl
     * @param art beschreibt den Artikel (Was ist der Artikel?)
    */
    public Artikel(int artikelNr, String art, double preis) {
        int anzahlDerStellen = String.valueOf(artikelNr).length();
        if (art == null || art.strip().isEmpty()) {
            throw new IllegalArgumentException(ART_NICHT_LEER);
        } else if (anzahlDerStellen != 4) {
            throw new IllegalArgumentException(ARTIKELNUMMER_NICHT_4STELLIG);
        } else {
            this.artikelNr = artikelNr;
            this.art = art;
            this.preis = preis;
        }
    }
    
    /**
     * Methode zur Buchung einer Bestandserhoehung
     *
     * @param menge gibt an welcher int Wert zum urspruenglichen Bestand addiert werden soll
     */
    public void bucheZugang(int menge) {
        if (menge < 0) {
            throw new IllegalArgumentException(MENGE_NEGATIV);
        } else {
            bestand = bestand + menge;
        }
    }

    /**
     * Methode zur Buchung einer Bestandsverminderung
     *
     * @param menge gibt an welcher int Wert vom ursprünglichen bestand abgezogen werden soll
     */
    public void bucheAbgang(int menge) {
        if (menge < 0) {
            throw new IllegalArgumentException(MENGE_NEGATIV);
        } else if (bestand - menge < 0) {
            throw new IllegalArgumentException(BESTAND_NEGATIV);
        } else {
            bestand = bestand - menge;
        }
    }

    /**
     * Ausgabe der Artikelattribute mit dem aktuellen Wert als Zeichenkette
     */
    public String toString() {
        String ausgabe = String.format("%-10d %-60s %8.2f %10d", artikelNr, art, preis, bestand);
        return ausgabe;
    }

    /**
     * get Artikelnummer
     */
    public int getArtikelNr() {
        return artikelNr;
    }

    /**
     * get Art des Artikels
     */
    public String getArt() {
        return art;
    }

    /**
     * get Benstand eines Artikels
     */
    public int getBestand() {
        return bestand;
    }
    
    /**
     * get Preis eines Artikels
     */
    public double getPreis() {
        return preis;
    }

    /**
     * set Art eines Artikels
     *
     * @param art gibt als Zeichenkette an was der Artikel ist
     */
    public void setArt(String art) {
        if (art == null || art.strip().isEmpty()) {
            throw new IllegalAccessError(ART_NICHT_LEER);
        } else {
            this.art = art;
        }
    }

    /**
     * set Benstand eines Artikels
     *
     * @param bestand gibt den wahrenbestand als ganzzahl an
     */
    public void setBestand(int bestand) {
        if (bestand < 0) {
            throw new IllegalAccessError(BESTAND_NEGATIV);
        } else {
            this.bestand = bestand;
        }
    }

    /**
     * set Preis eines Artikels
     *
     * @param preis gibt den neuen Preis als ganzzahl an
     */
    public void setPreis(double preis) {
        if (bestand < 0) {
            throw new IllegalAccessError(PREIS_NEGATIV);
        } else {
            this.preis = preis;
        }
    }

    /**
     * get Beschreibung eines Artikels
     */
    public String getBeschreibung(){
        return art;
    }
}
