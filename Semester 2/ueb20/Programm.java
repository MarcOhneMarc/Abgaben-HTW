import java.util.Map;
import java.util.LinkedHashMap;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Random;

/**
 * Beschreiben Sie hier die Klasse Programm.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Programm {
public static void main(String[] args) {
        // Parameter für die Collection- und Sortierungsart
        boolean useFIFO = true; // true für FIFO-Ordnung, false für natürliche Sortierung

        // Erstellen von Producer und Consumer
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        // Collection abhängig von der gewählten Sortierung erstellen
        Collection<Integer> collection;
        if (useFIFO) {
            collection = new LinkedList<>();
        } else {
            collection = new TreeSet<>();
        }

        // Random-Objekt für die zufällige Auswahl von Producer oder Consumer
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            if (random.nextInt(2) > 0) {
                // Producer erzeugt einen neuen Integer und speichert ihn in der Collection
                int value = producer.produce();
                collection.add(value);
            } else {
                // Consumer entnimmt einen Integer aus der Collection und berechnet die Quersumme
                if (!collection.isEmpty()) {
                    int value = collection.iterator().next();
                    collection.remove(value);
                    consumer.consume(value);
                }
            }
        }

        // Testen der Consumer-Methoden
        System.out.println("Anzahl unterschiedlicher Quersummen: " + consumer.numberOfDifferentResults());
        int number = 5; // Beispielzahl
        System.out.println("Anzahl Vorkommen von " + number + ": " + consumer.numberOfOccurrences(number));
        System.out.println("Quersummen in aufsteigender Reihenfolge: " + consumer.getCrossTotalsAscending());
        System.out.println("Quersummen in absteigender Reihenfolge: " + consumer.getCrossTotalsDescending());
        System.out.println("Zeitstempel für Quersumme " + number + ": " + consumer.getTimestampsForResult(number));
    }
}
