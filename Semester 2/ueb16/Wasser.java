
/**
 * Abstrakte Klasse Wasser, erbt von AlkoholfreiesGetraenk.
 * 
 * @Jonas_Neu_&_Marc_Perwak
 */
public class Wasser extends AlkoholfreiesGetraenk {
    public String quelle;
    
    private static final String FALSCHE_DEKLERATION = "Geben sie eine gueltige Quelle an!";
    
    public Wasser(String hersteller, String quelle) throws FalscheDeklerationException {
        super(hersteller);
        
        if (quelle.strip().isEmpty() || quelle == null)
            throw new FalscheDeklerationException(FALSCHE_DEKLERATION);
        this.quelle = quelle;
    }
    
    /**
     * Methode zur Rueckgabe der Quelle eines Wassers
     * 
     * @return quelle Die Rueckgabe der Quelle als String
     */
    public String getQuelle() {
        return quelle;
    }
    
    /**
     * Methode zum ueberschreiben der Quelle eines Wassers
     * 
     * @param quelle Die Uebergabe der Quelle als String
     */
    public void setQuelle(String quelle) {
        this.quelle = quelle;
    }
    
    /**
     * Methode zum ausgeben eines Wassers
     */
    public String toString() {
        String rueckgabe = "Wasser aus der Quelle: " + quelle + super.toString();
        return rueckgabe;
    }
}
