
/**
 * Beschreiben Sie hier die Klasse Raum.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Raum
{
    // Instanzvariablen
    private int geb;
    private int etage;
    private int raum;
    private Reservierung[] reservierungen;
    private int anzahl;

    /**
     * Konstruktor fuer Objekte der Klasse Raum
     */
    public Raum(int geb, int etage, int raum)
    {
        // Instanzvariablen initialisieren
        this.geb = geb;
        this.etage = etage;
        this.raum = raum;
        reservierungen = new Reservierung[10];
    }
    
    /**
     * Methode zum ausgeben eines Raumes als String
     * 
     * @return raumausgabe Die Ausgabe einers Raumes mit Signatur: Raum GEB-ETAGE.RAUM
     */
    public String toString()
    {
        String raumausgabe = ("RAUM " + geb + "-" + etage + "." + raum);
        for (int i = 0; i < reservierungen.length; i++) 
        {
            if (reservierungen[i] != null) {
                raumausgabe += ("\n" + reservierungen[i]);
            }
        }
        return raumausgabe;
    }
    
    /**
     * Methode zum hinzufuegen einer Reservierung zu einem Raum
    */    
    public void addResavierung(Reservierung reservierung)
    {
        if (getAnzahlReservierungen() == reservierungen.length) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < getAnzahlReservierungen(); i++) 
        {
            if (reservierungen[i] == null) {
                reservierungen[i] = reservierung;
                anzahl++;
                break;
            }
        }
    }
    
    /**
     * Methode zur Rueckgabe der Gebaeudenummer
     * 
     * @return geb Die Gebaeudenummer als Ganzzahl
     */
    public int getGeb()
    {
        return geb;
    }
    
    /**
     * Methode zur Rueckgabe der Etage
     * 
     * @return etage Die Etage als Ganzzahl
     */
    public int getEtage()
    {
        return etage;
    }
    
    /**
     * Methode zur Rueckgabe der Raum
     * 
     * @return raum Die Raum als Ganzzahl
     */
    public int getRaum()
    {
        return raum;
    }
    
    /**
     * Methode zur Rueckgabe einer Reservierung anhand eines Index
     * 
     * @return reservierungen[index] Die Reservierung als Reservierung
     */
    public Reservierung getReservierungen(int index)
    {
        return reservierungen[index];
    }
    
    /**
     * Methode zur Rueckgabe der Anzahl aller Reservierung
     * 
     * @return anzahl Die Anzahl an Reservierungen als Ganzzahl
     */
    public int getAnzahlReservierungen()
    {
        return anzahl;
    }
    
    
    /**
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










