
/**
 * Abstrakte Klasse AlkoholischesGetraenk, erbt von Getraenk.
 * 
 * @Jonas_Neu_&_Marc_Perwak
 */
public abstract class AlkoholischesGetraenk extends Getraenk {
    public float alkoholgehalt;
    
    private static final String FALSCHE_DEKLERATION = "Geben sie einen gueltigen Alkoholgehalt an!";
    
    public AlkoholischesGetraenk(float alkoholgehalt) throws FalscheDeklerationException {
        if (alkoholgehalt <= 0)
            throw new FalscheDeklerationException(FALSCHE_DEKLERATION);
        this.alkoholgehalt = alkoholgehalt;
    }
    
    /**
     * Methode zur Rueckgabe des Alkoholgehalts eines alkoholischen Getraenks
     * 
     * @return alkoholgehalt Die Rueckgabe des Alkoholgehalts als String
     */
    public float getAlkoholgehalt() {
        return alkoholgehalt;
    }
    
    /**
     * Methode zum ueberschreiben des Alkoholgehalts eines alkoholischen Getraenks
     * 
     * @param alkoholgehalt Die Uebergabe des Alkoholgehalts als String
     */
    public void setAlkoholgehalt(float alkoholgehalt) {
        this.alkoholgehalt = alkoholgehalt;
    }
    
    /**
     * Methode zum ausgeben eines alkoholischen Getraenks
     */
    public String toString() {
        String rueckgabe = "Alkoholgehalt des alkoholischen Getraenks: " + alkoholgehalt;
        return rueckgabe;
    }
}
