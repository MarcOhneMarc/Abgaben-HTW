
/**
 * Abstrakte Klasse AlkoholfreiesGetraenk, erbt von Getraenk.
 * 
 * @Jonas_Neu_&_Marc_Perwak
 */
public abstract class AlkoholfreiesGetraenk extends Getraenk {
    public String hersteller;
    
    private static final String FALSCHE_DEKLERATION = "Geben sie einen gueltigen Hersteller an!";
    
    public AlkoholfreiesGetraenk(String hersteller) throws FalscheDeklerationException {
        if (hersteller.strip().isEmpty() || hersteller == null)
            throw new FalscheDeklerationException(FALSCHE_DEKLERATION);
        this.hersteller = hersteller;
    }
    
    /**
     * Methode zur Rueckgabe des Herstellers eines Getraenks
     * 
     * @return hersteller Die Rueckgabe des Herstellers als String
     */
    public String getHersteller() {
        return hersteller;
    }
    
    /**
     * Methode zum ueberschreiben des Herstellers eines alkohlfreien Getraenks
     * 
     * @param hersteller Die uebergabe des Herstellers als String
     */
    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }
    
    /**
     * Methode zum ausgeben eines alkoholfreien Getraenks
     */
    public String toString() {
        String rueckgabe = "Hersteller des alkoholfreien Getraenks: " + hersteller;
        return rueckgabe;
    }
}
