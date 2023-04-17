
/**
 * Diese Klasse dient als Grundgeruest fuer einen Raum.
 * 
 * @jonas_neu_+_marc_perwak
 */
public class Raum {
    // Instanzvariablen
    private int geb;
    private int etage;
    private int raum;
    private Reservierung[] reservierungen;
    private int anzahl;
    private int maxAnzahlReservierungen = 10;

    private static final String GEBAEUDENUMMER_NEGATIV = "Die Gebaeudenummer darf nicht negativ sein!";
    private static final String ETAGENNUMMER_NEGATIV = "Die Etagennummer darf nicht negativ sein!";
    private static final String RAUMNUMMER_NEGATIV = "Die Raumnummer darf nicht negativ sein!";
    
    /**
     * Konstruktor fuer Objekte der Klasse Raum
     */
    public Raum(int geb, int etage, int raum) {
        // Instanzvariablen initialisieren
        if (geb < 0)
            throw new IllegalArgumentException(GEBAEUDENUMMER_NEGATIV);
        if (etage < 0)
            throw new IllegalArgumentException(ETAGENNUMMER_NEGATIV);
        if (raum < 0)
            throw new IllegalArgumentException(RAUMNUMMER_NEGATIV);
            
        this.geb = geb;
        this.etage = etage;
        this.raum = raum;
        
        reservierungen = new Reservierung[maxAnzahlReservierungen];
    }
    
    /**
     * Methode zum ausgeben eines Raumes als String
     * 
     * @return raumausgabe Die Ausgabe einers Raumes mit Signatur: Raum GEB-ETAGE.RAUM
     */
    public String toString() {
        String raumausgabe = ("RAUM " + geb + "-" + etage + "." + raum);
        for (int i = 0; i < anzahl; i++) 
        {
            if (reservierungen[i] != null)
                raumausgabe += ("\n" + reservierungen[i]);
        }
        return raumausgabe;
    }
    
    /**
     * Methode zum hinzufuegen einer Reservierung zu einem Raum
    */    
    public void addReservierung(Reservierung reservierung) {
        if (getAnzahlReservierungen() == reservierungen.length) {
            throw new IllegalArgumentException("Keine Reservierungen mehr verfügbar");
        }
        reservierungen[anzahl] = reservierung;
        anzahl++;
    }
    
    /**
     * Methode zur Rueckgabe der Gebaeudenummer
     * 
     * @return geb Die Gebaeudenummer als Ganzzahl
     */
    public int getGeb() {
        return geb;
    }
    
    /**
     * Methode zur Rueckgabe der Etage
     * 
     * @return etage Die Etage als Ganzzahl
     */
    public int getEtage() {
        return etage;
    }
    
    /**
     * Methode zur Rueckgabe der Raum
     * 
     * @return raum Die Raum als Ganzzahl
     */
    public int getRaum() {
        return raum;
    }
    
    /**
     * Methode zur Rueckgabe einer Reservierung anhand eines Index
     * 
     * @return reservierungen[index] Die Reservierung als Reservierung
     */
    public Reservierung getReservierungen(int index) {
        return reservierungen[index];
    }
    
    /**
     * Methode zur Rueckgabe der Anzahl aller Reservierung
     * 
     * @return anzahl Die Anzahl an Reservierungen als Ganzzahl
     */
    public int getAnzahlReservierungen() {
        return anzahl;
    }
    
    /*Keine Reservierungsueberschneidungen (auskommentiert, da nicht benötigt)
     * Methode zum hinzufuegen einer Resavierung zu einem Raum   
    public void addResavierung(Reservierung reservierung)
    {
        for (int i = 0; i < reservierungen.length; i++) 
        {
            
            Uhrzeit beginn = reservierung.getBeginn();
            Uhrzeit ende = reservierung.getEnde();
            Uhrzeit beginnVGL = reservierungen[i].getBeginn();
            Uhrzeit endeVGL = reservierungen[i].getEnde();
            
            if (beginn.getStunde() <=  endeVGL.getStunde() &&
                beginn.getMinute() <  endeVGL.getMinute()) 
            {   
                System.out.println("BELEGT!!!!!!!");
                
            } else if (ende.getStunde() >=  beginnVGL.getStunde() &&
                        ende.getMinute() >  beginnVGL.getMinute()) 
            {
                System.out.println("BELEGT!!!!!!!");
                
            } else 
            {
                System.out.println("reservierungen[i]");
                
            }
            
            //reservierungen[i] = reservierung;
        }
    }
    */ 
}










