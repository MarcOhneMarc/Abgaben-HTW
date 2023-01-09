

public class Patient {
    //initialisierung der Konstanten für Exceptions
    private static final String PATIENTENNUMMER_NICHT_4STELLIG = "Die Patientennummer muss 4 Stellen haben!";
    private static final String VORNAME_LEER = "Der Vorname darf nicht leer sein!";
    private static final String NACHNAME_LEER = "Der Nachname darf nicht leer sein!";
    
    //initialisierung der Attribute
    private int patientennummer;
    private String vorname;
    private String nachname;
    
     /**
     * Konstruktor zum initialisiern eines Patienten
     *
     * @param patientennummer Die Patientennummer als 4-Stellige Ganzzahl
     * @param vorname Der Vorname als String
     * @param nachname Der Nachname als String
     */
    public Patient(int patientennummer, String vorname, String nachname) {
        int puefungPatientennummer = String.valueOf(patientennummer).length();
        if (puefungPatientennummer != 4) {
            throw new IllegalArgumentException(PATIENTENNUMMER_NICHT_4STELLIG);
        } else if (vorname == null || vorname.strip().isEmpty()) {
            throw new IllegalArgumentException(VORNAME_LEER);
        } else if (nachname == null || nachname.strip().isEmpty()) {
            throw new IllegalArgumentException(NACHNAME_LEER);
        } else {
            this.patientennummer = patientennummer;
            this.vorname = vorname;
            this.nachname = nachname;
        }
    }
    
    /**
     * Ausgabe eines Patienten als Zeichenkette ????????????????????
     */
    public String toString() {
        return patientennummer + vorname + nachname;
    }
    
    /**
     * get Patientennummer
     */
    public int getpatientennummer() {
        return patientennummer;
    }
    
    /**
     * get Vorname
     */
    public String getvorname() {
        return vorname;
    }
    
    /**
     * get Nachname
     */
    public String getnachname() {
        return nachname;
    }
}
