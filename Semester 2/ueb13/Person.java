
/**
 * Diese Klasse definiert das Grundgeruest einer Person.
 * 
 * @jonas_neu_+_marc_perwak
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
    public Person(String vorname, String nachname) {
        if (vorname == null || vorname.strip().isEmpty()) {
            throw new IllegalArgumentException(VORNAME_LEER);
        } else if (nachname == null || nachname.strip().isEmpty())
            throw new IllegalArgumentException(NACHNAME_LEER);
        this.vorname = vorname;
        this.nachname = nachname;
    }

    /**
     * Methode zum ausgeben einer Person als String
     * 
     * @return person Die Ausgabe einer Person mit Signatur: VORNAME NACHNAME
     */
    public String toString() {
        String person = (vorname + " " + nachname);
        return person;
    }
    
    /**
     * Methode zur Rueckgabe des Vornamens
     * 
     * @return vorname Die Rueckgabe des Vornamens als String
     */
    public String getVorname() {
        return vorname;
    }
    
    /**
     * Methode zur Rueckgabe des Nachnamens
     * 
     * @return vorname Die Rueckgabe des Nachnamens als String
     */
    public String getNachname() {
        return nachname;
    }
    
    public boolean equals(Person person) {
        if (this == person)
            return true;
        if (person == null)
            return false;
        if (getClass() != person.getClass())
            return false;
        Person other = (Person) person;
        if (vorname == null) {
            if (other.vorname != null)
                    return false;
        } else if (!vorname.equals(other.vorname))
            return false;
        if (nachname == null) {
            if (other.nachname != null)
                    return false;
        } else if (!nachname.equals(other.nachname))
            return false;
        return true;
    }
}
