
/**
 * Abstrakte Klasse Softdrink, erbt von AlkoholfreiesGetraenk.
 * 
 * @Jonas_Neu_&_Marc_Perwak
 */
public class Softdrink extends AlkoholfreiesGetraenk {
    public float zuckergehalt;
    
    private static final String FALSCHE_DEKLERATION = "Geben sie eine gueltige Quelle an!";
    
    public Softdrink(String hersteller, float zuckergehalt) throws FalscheDeklerationException {
        super(hersteller);
        
        if (zuckergehalt <= 0)
            throw new FalscheDeklerationException(FALSCHE_DEKLERATION);
        this.zuckergehalt = zuckergehalt;
    }
    
    /**
     * Methode zur Rueckgabe des Zuckergehalts eines Softdrinks
     * 
     * @return zuckergehalt Die Rueckgabe des Zuckergehalts als String
     */
    public float getZuckergehalt() {
        return zuckergehalt;
    }
    
    /**
     * Methode zum ueberschreiben des Zuckergehalts eines Softdrinks
     * 
     * @param zuckergehalt Die Uebergabe des Zuckergehalts als String
     */
    public void getZuckergehalt(float zuckergehalt) {
        this.zuckergehalt = zuckergehalt;
    }
    
    /**
     * Methode zum ausgeben eines Softdrinks
     */
    public String toString() {
        String rueckgabe = super.toString() + " Zuckergehalt: " + zuckergehalt;
        return rueckgabe;
    }
}
