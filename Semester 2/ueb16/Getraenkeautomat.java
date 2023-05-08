import java.util.ArrayList;
/**
 * Beschreiben Sie hier die Klasse Flasche.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Getraenkeautomat <T extends Flasche>{
    private ArrayList<T> flaschenlager;
    private int kapazitaet;
    
    private static final String FALSCHE_DEKLERATION = "Geben sie einen gueltige Katazitaet an!";
    
    
    public Getraenkeautomat(int kapazitaet) {
        if (kapazitaet <= 0)
            throw new IllegalArgumentException(FALSCHE_DEKLERATION);
        this.kapazitaet = kapazitaet;
        flaschenlager = new ArrayList<T>();
    }
    
    public void flascheEinlegen(T flasche) throws LagerVollException {
        if (flaschenlager.size() >= kapazitaet)
            throw new LagerVollException();
        flaschenlager.add(flasche);
    }
    
    public int getKapazitaet() {
        return kapazitaet;
    }
    
    public T flascheAusgeben() {
        if (flaschenlager.isEmpty()) {
            return null;
        }
        return flaschenlager.remove(0);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Getränkeautomat mit ").append(flaschenlager.size()).append(" Flaschen:\n");
        for (T flasche : flaschenlager) {
            sb.append(flasche.toString()).append("\n");
        }
        return sb.toString();
    }

}
