/**
 * Bestandsfuehrung.
 *
 * @author Marc Perwark & Jonas Neu
 * 06.11.2022
 */
public class Artikel{
    //initialisierung der Attribute
    private int artikelNr;
    private String art;
    private int bestand;

    private double preis;

     /**
     * Konstruktor zum initialisiern eines Artikel mit Bestand
     *
     * @param artikelNr gibt die Artikelnummer als vierstellige ganzzahl an
     * @param art gibt als Zeichenkette an was der Artikel ist
     * @param bestand gibt den wahrenbestand als ganzzahl an
     */
    public Artikel(int artikelNr, String art, int bestand, double preis) {
        int anzahlDerStellen = String.valueOf(artikelNr).length();
        if (art == null || art.strip().isEmpty()) {
            throw new IllegalArgumentException("'Art' darf nicht leer sein!");
        } else if (anzahlDerStellen != 4) {
            throw new IllegalArgumentException("Die Artikelnummer muss 4 Stellen haben!");
        } else if (bestand < 0) {
            throw new IllegalArgumentException("Der bestand darf nicht negativ sein!");
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
     * @param artikelNr gibt die Artikelnummer als vierstellige ganzzahl an
     * @param art gibt als Zeichenkette an was der Artikel ist
     */
    public Artikel(int artikelNr, String art, double preis) {
        int anzahlDerStellen = String.valueOf(artikelNr).length();
        if (art == null || art.strip().isEmpty()) {
            throw new IllegalArgumentException("'Art' darf nicht leer sein!");
        } else if (anzahlDerStellen != 4) {
            throw new IllegalArgumentException("Die Artikelnummer muss 4 Stellen haben!");
        } else {
            this.artikelNr = artikelNr;
            this.art = art;
            this.preis = preis;
        }
    }
    //Ein Standardkonstruktor wie Artikel() macht hier keinen Sinn, da jeder Artikel unterschiedlich sein muss.
    /**
     * Methode zur Buchung einer Bestandserhoehung
     *
     * @param menge gibt an welcher int Wert zum ursprünglichen bestand addiert werden soll
     */
    public void bucheZugang(int menge) {
        if (menge < 0) {
            throw new IllegalArgumentException("Die Menge darf nicht negativ sein!");
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
            throw new IllegalArgumentException("Die Menge darf nicht negativ sein!");
        } else if (bestand - menge < 0) {
            throw new IllegalArgumentException("Der Finale Bestand darf nicht negativ sein!");
        } else {
            bestand = bestand - menge;
        }
    }

    /**
     * Ausgabe der Artikelattribute mit aktuellem Wert als Zeichenkette
     */
    public String toString() {
        return "Artikel: " + artikelNr + ", Art: " + art + ", Bestand: " + bestand + ", Preis: " + preis;
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
            throw new IllegalAccessError("'Art' darf nicht leer sein!");
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
            throw new IllegalAccessError("Der bestand darf nicht negativ sein!");
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
            throw new IllegalAccessError("Der preis darf nicht negativ sein!");
        } else {
            this.preis = preis;
        }
    }
}
