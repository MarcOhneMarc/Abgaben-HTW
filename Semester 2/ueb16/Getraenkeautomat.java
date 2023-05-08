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
    
    /**
     * Konstruktor zum erstellen eines Getraenkeautomaten, welcher Flaschen
     * abspeichern kann.
     * 
     * @param kapazitaet die Kapazitaet des Automaten
     */
    public Getraenkeautomat(int kapazitaet) {
        if (kapazitaet <= 0)
            throw new IllegalArgumentException(FALSCHE_DEKLERATION);
        this.kapazitaet = kapazitaet;
        flaschenlager = new ArrayList<T>();
    }
    
    /**
     * Methode um eine Flasche in den Automaten zu fuellen
     * 
     * @param flasche Die Flasche, die in den Automaten soll
     */
    public void flascheEinlegen(T flasche) throws LagerVollException {
        if (flaschenlager.size() >= kapazitaet)
            throw new LagerVollException();
        flaschenlager.add(flasche);
    }

    /**
     * Get Methode um die Kapazitaet eines Automaten zu bekommen
     * 
     * @return kapazitaet Die Bleibende Kapazitaet
     */
    public int getKapazitaet() {
        return kapazitaet;
    }
    
    /**
     * Methode um die erste Flasche aus dem Automaten zu entnehmen
     * 
     * @return T Die Flasche, die entnommen werden soll
     */
    public T flascheAusgeben() {
        if (flaschenlager.isEmpty()) {
            return null;
        }
        return flaschenlager.remove(0);
    }
    
   /**
     * Diese Methode gibt einen Automaten mit Inhalt als String zurueck
     */
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
