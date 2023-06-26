import java.util.*;

/**
 * TestProgramm für Producer und Consumer
 *
 * @JonasNeu_MarcPerwak
 */
public class Programm {
    public static void main(String[] args) {
        boolean useFIFO = true;

        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        Collection<Integer> collection;
        if (useFIFO) {
            collection = new LinkedList<>();
        } else {
            collection = new PriorityQueue<>();
        }

        Random random = new Random();
        //gegebene Schleife
        for (int i = 0; i < 10000; i++) {
            if (random.nextInt(2) > 0) {
                int value = producer.produce();
                collection.add(value);
            } else {
                if (!collection.isEmpty()) {
                    int value = collection.iterator().next();
                    collection.remove(value);
                    consumer.consume(value);
                }
            }
        }
        
        System.out.println("ERGEBNISSE:");
        System.out.println("Anzahl unterschiedlicher Quersummen: ");
        System.out.println(consumer.numberOfDifferentResults() + "\n");
        int number = 10;
        System.out.println("Anzahl Vorkommen von " + number + ": " + consumer.numberOfOccurrences(number) + "\n");
        number = 18;
        System.out.println("Anzahl Vorkommen von " + number + ": " + consumer.numberOfOccurrences(number) + "\n");
        System.out.println("Zeiten zur berechnung der Quersummen: " + number + ": " + consumer.getTimestampsForResult(number) + "\n");
        System.out.println("Quersummen absteigend: " + consumer.getCrossTotalsDescending() + "\n");
        System.out.println("Quersummen aufsteigend: " + consumer.getCrossTotalsAscending() + "\n");
    }
}