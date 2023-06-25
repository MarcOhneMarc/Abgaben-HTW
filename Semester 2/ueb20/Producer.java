import java.util.Random;

/**
 * Beschreiben Sie hier die Klasse Producer.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
class Producer {
    public int produce() {
        Random random = new Random();
        return random.nextInt(1001);
    }
}
