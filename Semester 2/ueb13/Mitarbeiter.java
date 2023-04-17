
/**
 * Diese Klasse definiert einen Mitarbeiter welcher von der Klasse Person erbt.
 * 
 * @jonas_neu_+_marc_perwak
 */
public class Mitarbeiter extends Person {
    // Instanzvariablen
    private String mail;
    
    private static final String KEINE_GUELTIGE_MAIL = "Die angegebene E-Mail Adresse ist nicht gueltig!";
    
    /**
     * Konstruktor fuer Objekte der Klasse Mitarbeiter
     */
    public Mitarbeiter(String vorname, String nachname, String mail) {
        super(vorname, nachname);
        if (mail == null || mail.strip().isEmpty()) {
            throw new IllegalArgumentException(KEINE_GUELTIGE_MAIL);
        }
        if (!mail.contains("@")) {
            throw new IllegalArgumentException(KEINE_GUELTIGE_MAIL);
        }
        this.mail = mail;
    }

    /**
     * Methode zum ausgeben eines Mitarbeiters als String
     * 
     * @return mitarbeiter Die Ausgabe eines Mitarbeiters mit Signatur: VORNAME NACHNAME (MAIL)
     */
    public String toString() {
        String person = (getVorname() + " " + getNachname() + " (" + mail + ")");
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
    public void reserviere(Raum raum, Uhrzeit beginn, Uhrzeit ende, String bemerkung) {
        Reservierung reservierung = new Reservierung(beginn, ende);
        reservierung.setRaum(raum);
        reservierung.setMitarbeiter(this);
        reservierung.setBemerkung(bemerkung);
        raum.addReservierung(reservierung);
    }
    
    /**
     * Methode zur Rueckgabe der Email
     * 
     * @return mail Die Rueckgabe des Vornamens als String
     */
    public String getEmail() {
        return mail;
    }
    
    public boolean equals(Mitarbeiter mitarbeiter) {
        if (this == mitarbeiter)
            return true;
        if (mitarbeiter == null)
            return false;
        if (getClass() != mitarbeiter.getClass())
            return false;
        Mitarbeiter other = (Mitarbeiter) mitarbeiter;
        if (this.getVorname() == null) {
            if (other.getVorname() != null)
                    return false;
        } else if (!this.getVorname().equals(other.getVorname()))
            return false;
        if (this.getNachname() == null) {
            if (other.getNachname() != null)
                    return false;
        } else if (!this.getNachname().equals(other.getNachname()))
            return false;
        if (mail == null) {
            if (other.mail != null)
                    return false;
        } else if (!mail.equals(other.mail))
            return false;
        return true;
    }
}
