
/**
 * Beschreiben Sie hier die Klasse Mitarbeiter.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Mitarbeiter extends Person
{
    // Instanzvariablen
    private String mail;
    
    private static final String MAIL_LEER = "Die Mail Adresse darf nicht leer sein!";
    
    /**
     * Konstruktor fuer Objekte der Klasse Mitarbeiter
     */
    public Mitarbeiter(String vorname, String nachname, String mail)
    {
        super(vorname, nachname);
        if (mail == null || mail.strip().isEmpty()) {
            throw new IllegalArgumentException(MAIL_LEER);
        }
        this.mail = mail;
    }

    /**
     * Methode zum ausgeben eines Mitarbeiters als String
     * 
     * @return mitarbeiter Die Ausgabe eines Mitarbeiters mit Signatur: VORNAME NACHNAME (MAIL)
     */
    public String toString()
    {
        String person = (getVorname() + " " + getVorname() + " (" + mail + ") ");
        return person;
    }
    
    /**
     * Methode zum resavieren eines Raumes
     * 
     * @param raum Der Raum, welcher Reserviert werden soll
     * @param beginn die Uhrzeit ab welcher die Reservierung starten soll
     * @param ende die Uhrzeit an der die Reservierung beendet werden soll
     * @param bemerkung Bemerkungen zur Reservierung
     */
    public void reserviere(Raum raum, Uhrzeit beginn, Uhrzeit ende, String bemerkung)
    {
        Reservierung reservierung = new Reservierung(beginn, ende);
        reservierung.setRaum(raum);
        reservierung.setBemerkung(bemerkung);
        raum.addResavierung(reservierung);
    }
}
