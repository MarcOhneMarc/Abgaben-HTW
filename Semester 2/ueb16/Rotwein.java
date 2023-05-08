
/**
 * Klasse Rotwein, erbt von Wein.
 * 
 * @Jonas_Neu_&_Marc_Perwak
 */
public class Rotwein extends Wein {
    
    public Rotwein(float alkoholgehalt, String weingut) throws FalscheDeklerationException {
        super(alkoholgehalt, weingut);
    }
    
    /**
     * Methode zum ausgeben eines Rotweins
     */
    public String toString() {
        String rueckgabe = super.toString() + " Weingut des Rotweins: " + weingut;
        return rueckgabe;
    }
}
