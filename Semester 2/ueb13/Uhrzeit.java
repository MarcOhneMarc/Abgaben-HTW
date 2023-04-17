
/**
 * Beschreiben Sie hier die Klasse Uhrzeit.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Uhrzeit
{
    // Instanzvariablen
    private int stunde;
    private int minute;
    private static final String FALSCHE_UHRZEIT = "Die Uhrzeit wurde falsch angegeben!";

    /**
     * Konstruktor fuer Objekte der Klasse Uhrzeit
     */
    public Uhrzeit(int stunde, int minute)
    {
        if (stunde > 24 || stunde < 0 || minute >= 60 || minute < 0){
            throw new IllegalArgumentException(FALSCHE_UHRZEIT);
        }
        this.stunde = stunde;
        this.minute = minute;
    }

    /**
     * Methode zum ausgeben der Uhrzeit als String
     * 
     * @return uhrzeit Die Ausgabe der Uhrzeit mit Signatur: STUNDE:MINUTE Uhr
     */
    public String toString()
    {
        String uhrzeit = (stunde + ":" + minute + " Uhr");
        return uhrzeit;
    }
    
    /**
     * Methode zur Rueckgabe der Stunde
     * 
     * @return stunde Die R�ckgabe der Stunde als Integer
     */
    public int getStunde()
    {
        return stunde;
    }

    /**
     * Methode zur Rueckgabe der Minute
     * 
     * @return minute Die R�ckgabe der Minute als Integer
     */
    public int getMinute()
    {
        return minute;
    }
    
    
}
