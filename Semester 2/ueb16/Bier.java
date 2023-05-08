
/**
 * Klasse Bier, erbt von AlkoholischesGetraenk.
 * 
 * @Jonas_Neu_&_Marc_Perwak
 */
public class Bier extends AlkoholischesGetraenk {
    public String brauerei;
    
    private static final String FALSCHE_DEKLERATION = "Geben sie eine gueltige Brauerei an!";
    
    public Bier(float alkoholgehalt, String brauerei) throws FalscheDeklerationException{
        super(alkoholgehalt);
        
        if (brauerei.strip().isEmpty() || brauerei == null)
            throw new FalscheDeklerationException(FALSCHE_DEKLERATION);
        /*if (brauerei == "Bitburger")
            throw new IllegalArgumentException(FALSCHE_DEKLERATION);*/
        this.brauerei = brauerei;
    }
    
    /**
     * Methode zur Rueckgabe der Brauerei eines Biers
     * 
     * @return brauerei Die Rueckgabe der Brauerei als String
     */
    public String getBrauerei() {
        return brauerei;
    }
    
    /**
     * Methode zum ueberschreiben der Brauerei eines Biers
     * 
     * @param brauerei Die Uebergabe der Brauerei als String
     */
    public void setBrauerei(String brauerei) {
        this.brauerei = brauerei;
    }
    
    /**
     * Methode zum ausgeben eines Hopfenfeingetraenks
     */
    public String toString() {
        String rueckgabe = super.toString() + " Quelle: " + brauerei;
        return rueckgabe;
    }
}
