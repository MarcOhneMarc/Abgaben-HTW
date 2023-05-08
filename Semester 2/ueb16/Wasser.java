
/**
 * Beschreiben Sie hier die Klasse Wasser.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
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
        String rueckgabe = super.toString() + " Quelle: " + quelle;
        return rueckgabe;
    }
}
