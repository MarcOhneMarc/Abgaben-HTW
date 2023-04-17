
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
     * Methode zum hinzuf�gen einer Resavierung zu einem Raum
    */    
    public void addResavierung(Reservierung reservierung)
    {
        for (int i = 0; i < reservierungen.length; i++) 
        {
            if (reservierungen[i] == null) {
                reservierungen[i] = reservierung;
                break;
            }
        }
    }
    
    
    
    /**
     * Methode zum hinzuf�gen einer Resavierung zu einem Raum   
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










