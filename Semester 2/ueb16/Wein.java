
/**
 * Beschreiben Sie hier die Klasse Wasser.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Wein extends AlkoholischesGetraenk {
    public String weingut;
    
    private static final String FALSCHE_DEKLERATION = "Geben sie eine gueltiges Weingut an!";
    
    public Wein(float alkoholgehalt, String weingut) throws FalscheDeklerationException {
        super(alkoholgehalt);
        
        if (weingut.strip().isEmpty() || weingut == null)
            throw new FalscheDeklerationException(FALSCHE_DEKLERATION);
        this.weingut = weingut;
    }
    
    /**
     * Methode zur Rueckgabe des Weinguts eines Weins
     * 
     * @return weingut Die Rueckgabe des Weinguts als String
     */
    public String getWeingut() {
        return weingut;
    }
    
    /**
     * Methode zum ueberschreiben des Weinguts eines Weins
     * 
     * @param weingut Die Uebergabe des Weinguts als String
     */
    public void setWeingut(String weingut) {
        this.weingut = weingut;
    }
    
    /**
     * Methode zum ausgeben eines Weins
     */
    public String toString() {
        String rueckgabe = super.toString() + " Weingut des Weins: " + weingut;
        return rueckgabe;
    }
}
