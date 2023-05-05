
/**
 * Beschreiben Sie hier die Klasse Flasche.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Flasche <T extends Getraenk>{
    private T inhalt;
    
    public void fuellen(T object) {
        this.inhalt = object;
    }
    
    public void leeren(T object) {
        this.inhalt = null;
    }
    
    public T getInhalt() {
        return inhalt;
    }
    
    //TOSTRING ??????????????????????????????????
    
}
