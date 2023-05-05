
/**
 * Beschreiben Sie hier die Klasse Wasser.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Softdrink extends AlkoholfreiesGetraenk {
    public float zuckergehalt;
    
    private static final String FALSCHE_DEKLERATION = "Geben sie eine gueltige Quelle an!";
    
    public Softdrink(String hersteller, float zuckergehalt) {
        super(hersteller);
        
        if (zuckergehalt <= 0)
            throw new IllegalArgumentException(FALSCHE_DEKLERATION);
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
