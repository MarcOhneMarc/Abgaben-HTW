import java.util.Random;

/**
 * Producer
 *
 * @JonasNeu_MarcPerwak
 */
class Producer {
    /**
     * Erstellt Zufallszahl zwischen 1 und 1000.
     * 
     * @return Die Zufallszahl
     */
    public int produce() {
        Random random = new Random();
        return random.nextInt(1, 1000);
    }
}