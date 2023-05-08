
/**
 * Generische Klasse Flasche, welche Getraenke beinhalten kann.
 * 
 * @Jonas_Neu_&_Marc_Perwak
 */
public class Flasche <T extends Getraenk>{
    private T inhalt;

    /**
     * Diese Methode fuellt eine Flassche mit einem Inhalt 
     * aus dem Erbbaum Getraenk
     * 
     * @param object Ein Objekt aus dem Erbbaum Getraenk
     */
    public void fuellen(T object) {
        this.inhalt = object;
    }

    /**
     * Diese Methode leert eine Flassche
     * 
     * @param object Ein Objekt aus dem Erbbaum Getraenk
     */
    public void leeren() {
        this.inhalt = null;
    }
    
    /**
     * Diese Methode gibt den Inhalt einer Flasche zurueck.
     */
    public T getInhalt() {
        return inhalt;
    }
    
    /**
     * Diese Methode gibt eine Flasche mit Inhalt als String zurueck
     */
    public String toString() {
        return "Flasche mit Inhalt: " + inhalt;
    }
}
