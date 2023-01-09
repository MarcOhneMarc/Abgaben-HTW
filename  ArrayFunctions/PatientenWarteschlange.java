/**
 * Der nächste bitte fertig
 * Überarbeiten
 * Aufgabenstellung wieder lesen
*/

public class PatientenWarteschlange {
    //initialisierung der Konstanten für Exceptions
    private static final int PATIENT_NICHT_GEFUNDEN = -1;
    private static final String MIN_MAX_WARTESCHLANGE = "Die Warteschlange darf maximal 10 Personen groß und nicht kleiner als 1 sein!";
    private static final String PATIENT_EXISTIERT_NICHT = "Dieser Patient existiert nicht!";
    private static final String WARTESCHLANGE_VOLL = "Die Warteschlange ist voll!";
    private static final String PATIENT_EXISTIERT_BEREITS = "Dieser Patient ist bereits in der Warteschlange!";
    private static final String PATIENTENNUMMER_NICHT_4STELLIG = "Die Patientennummer muss 4 Stellen haben!";
    private static final String WARTESCHLANGE_LEER = "Die Warteschlange ist leer!";
    
    //initialisierung der Attribute
    private Patient[] warteschlange;
    private int aktuelleAnzahlPatienten;
    private Patient uebergabe;
    
    /**
     * Konstruktor zum initialisiern der Warteschlange
     *
     * @param groesseWarteschlange Die groesse der Warteschlange (Minimal 1, Maximal 10)
     */
    public PatientenWarteschlange(int groesseWarteschlange) {
        if (groesseWarteschlange <= 0 || groesseWarteschlange > 10) {
            throw new IllegalArgumentException(MIN_MAX_WARTESCHLANGE);
        } else {
           warteschlange = new Patient[groesseWarteschlange];
        }
    }
    
    public void neuerPatient(int patientennummer, String vorname, String nachname) {
        uebergabe = new Patient(patientennummer, vorname, nachname);
        patienthinzufuegen(uebergabe);
    }
    
    /**
     * Methode zum hinzufuegen eines Patienten zur Warteschlange
     *
     * @param patient gibt an welcher Patient hinzugefuegt werden soll
     */
    public void patienthinzufuegen(Patient patient){
        //Pruefen ob der Patient existiert
        if (patient == null) {
           throw new IllegalArgumentException(PATIENT_EXISTIERT_NICHT);
        }
        //Pruefen ob die Warteschlange bereits voll ist
        if (warteschlange.length == aktuelleAnzahlPatienten) {
           throw new IllegalArgumentException(WARTESCHLANGE_VOLL);
        }
        int patientennummer = patient.getpatientennummer();
        int index = findePatientenIndex(patientennummer);
        //Ueberpruefung ob sich der Patient noch nicht in der Warteschlange befindet
        if (index != PATIENT_NICHT_GEFUNDEN) {
           throw new IllegalArgumentException(PATIENT_EXISTIERT_BEREITS);
        }
        warteschlange[aktuelleAnzahlPatienten] = patient;
        aktuelleAnzahlPatienten++;
    }
    
    /**
     * Methode zum entfernen eines Patienten zur Warteschlange
     *
     * @param patient gibt an welcher Patient entfernt werden soll
     */
    public Patient entfernePatient(int patientennummer) {
        int patientenindex = findePatientenIndex(patientennummer); // Abspeichern des Index an dem sich der Artikel befindet

        // Ueberpruefung ob sich der Artikel bereits im Lager befindet
        if (patientenindex == PATIENT_NICHT_GEFUNDEN) {
          throw new IllegalArgumentException(PATIENT_EXISTIERT_NICHT);
        }
        Patient entfernterPatient =warteschlange[patientenindex];
        for (int i = patientenindex; i < aktuelleAnzahlPatienten -1; i++) {
          warteschlange[i] = warteschlange[i + 1];
        }
        
        warteschlange[aktuelleAnzahlPatienten - 1] = null;
        aktuelleAnzahlPatienten--;
        return entfernterPatient;
    }
    
    /**
     * Methode zum aufrufen des naechsten Patienten
     */
    public Patient derNaechsteBitte() {
        if (aktuelleAnzahlPatienten <= 0) {
            throw new IllegalArgumentException(WARTESCHLANGE_LEER);
        }
        Patient next = warteschlange[0];
        for (int i = 0; i < aktuelleAnzahlPatienten -1; i++) {
          warteschlange[i] = warteschlange[i + 1];
        }
        warteschlange[aktuelleAnzahlPatienten - 1] = null;
        aktuelleAnzahlPatienten--;
        return next;
    }
    
    /**
    * Methode um herauszufinfen an welchem index sich ein Patient in der Warteschlange befindet
    * 
    * @param patientennummer Die Patientennummer des Patienten, dessen index ausgegeben werden soll
    * @return PATIENT_NICHT_GEFUNDEN = -1 bedeutet der Patient wurde nicht gefunden
    * @return i Der index, an dem sich der Patient befindet
    */
    public int findePatientenIndex(int patientennummer) {
        for (int i = 0; i < aktuelleAnzahlPatienten; i++) {
          Patient patient = warteschlange[i];
          if (patient.getpatientennummer() == patientennummer) {
            return i;
          }
        }
        return PATIENT_NICHT_GEFUNDEN;
    }
    
    /**
     * Methode zum Ausgeben der ganzen Warteschlange und den Patienten, die sich darin befinden
     * 
     * @return ausgabe die Ausgabe der ganzen Warteschlange und den Patienten, die sich darin befinden als String
     */
    public String toString() {
        String ausgabe = "Warteliste"; // Definition der Variable "ausgabe" als String
        ausgabe = ausgabe + "\n" + String.format("%-15s %-15s %-15s", "Patientennummer", "Vorname", "Nachname");
        // Erweitern der ausgabe in den String
        for (int i = 0; i < warteschlange.length; i++) {
            if (warteschlange[i] != null) {
                ausgabe = ausgabe + "\n" + String.format("%-15s %-15s %-15s", warteschlange[i].getpatientennummer(), warteschlange[i].getvorname(), warteschlange[i].getnachname());
            }
        }
        return ausgabe;
    }
}
