
/**
 * Beschreiben Sie hier die Klasse Reservierung.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Reservierung
{
    // Instanzvariablen
    private String bemerkung;
    private Uhrzeit beginn;
    private Uhrzeit ende;
    private Mitarbeiter mitarbeiter;
    private Raum raum;

    /**
     * Konstruktor fuer Objekte der Klasse Reservierung
     */
    public Reservierung(Uhrzeit beginn, Uhrzeit ende)
    {
        this.beginn = beginn;
        this.ende = ende;
    }
    
    /**
     * Methode zum ausgeben eines Raumes als String
     * 
     * @return raumausgabe Die Ausgabe einers Raumes mit Signatur: Raum GEB-ETAGE.RAUM
     */
    public String toString()
    {
        String raumausgabe = ("gebucht von " + mitarbeiter + "von " + beginn + " bis "
                                + ende + " fuer " + bemerkung);
        return raumausgabe;
    }

    /**
     * Diese Methode f�gt einer Reservierung eine Bemerkung zu
     * 
     * @param bemerkung Die Bemerkung
     */
    public void setBemerkung(String bemerkung)
    {
        this.bemerkung = bemerkung;
    }
    
    /**
     * Diese Methode stellt einer Reservierung einen Mitarbeiter zu
     * 
     * @param mitarbeiter Der Mitarbeiter
     */
    public void setMitarbeiter(Mitarbeiter mitarbeiter)
    {
        this.mitarbeiter = mitarbeiter;
    }

    /**
     * Diese Methode stellt einer Reservierung einen Mitarbeiter zu
     * 
     * @param mitarbeiter Der Mitarbeiter
     */
    public void setRaum(Raum raum)
    {
        this.raum = raum;
    }
    
    /**
     * Methode zur Rueckgabe des beginns einer Reservierung
     * 
     * @return beginn Die Rueckgabe des beginns einer Reservierung als Uhrzeit
     */
    public Uhrzeit getBeginn()
    {
        return beginn;
    }
    
    /**
     * Methode zur Rueckgabe des endes einer Reservierung
     * 
     * @return ende Die Rueckgabe des endes einer Reservierung als Uhrzeit
     */
    public Uhrzeit getEnde()
    {
        return ende;
    }
}
