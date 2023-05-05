
/**
 * Beschreiben Sie hier die Klasse Wasser.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Weisswein extends Wein {
    
    public Weisswein(float alkoholgehalt, String weingut) {
        super(alkoholgehalt, weingut);
    }
    
    /**
     * Methode zum ausgeben eines Rotweins
     */
    public String toString() {
        String rueckgabe = super.toString() + " Weingut des Weissweins: " + weingut;
        return rueckgabe;
    }
}
