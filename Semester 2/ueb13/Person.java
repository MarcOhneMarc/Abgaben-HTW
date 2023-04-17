
/**
 * Beschreiben Sie hier die Klasse Mitarbeiter.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Person
{
    // Instanzvariablen
    private String vorname;
    private String nachname;
    
    private static final String VORNAME_LEER = "Der Vorname darf nicht leer sein!";
    private static final String NACHNAME_LEER = "Der Nachname darf nicht leer sein!";
    
    /**
     * Konstruktor fuer Objekte der Klasse Person
     */
    public Person(String vorname, String nachname)
    {
        if (vorname == null || vorname.strip().isEmpty()) {
            throw new IllegalArgumentException(VORNAME_LEER);
        } else if (nachname == null || nachname.strip().isEmpty()) {
            throw new IllegalArgumentException(NACHNAME_LEER);
        }
        this.vorname = vorname;
        this.nachname = nachname;
    }

    /**
     * Methode zum ausgeben einer Person als String
     * 
     * @return person Die Ausgabe einer Person mit Signatur: VORNAME NACHNAME
     */
    public String toString()
    {
        String person = (vorname + " " + nachname);
        return person;
    }
    
    /**
     * Methode zur Rueckgabe des Vornamens
     * 
     * @return vorname Die R�ckgabe des Vornamens als String
     */
    public String getVorname()
    {
        return vorname;
    }
    
    /**
     * Methode zur Rueckgabe des Nachnamens
     * 
     * @return vorname Die R�ckgabe des Nachnamens als String
     */
    public String getNachname()
    {
        return nachname;
    }
}
