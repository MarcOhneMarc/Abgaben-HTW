
/**
 * Klasse Weisswein, erbt von Wein
 * 
 * @Jonas_Neu_&_Marc_Perwak
 */
public class Weisswein extends Wein {
    
    public Weisswein(float alkoholgehalt, String weingut) throws FalscheDeklerationException {
        super(alkoholgehalt, weingut);
    }
    
    /**
     * Methode zum ausgeben eines Rotweins
     */
    public String toString() {
        String rueckgabe = "(Weiss)" + super.toString();
        return rueckgabe;
    }
}
