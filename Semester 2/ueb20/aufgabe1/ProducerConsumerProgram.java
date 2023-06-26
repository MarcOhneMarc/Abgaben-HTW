import java.util.*;

public class ProducerConsumerProgram {
    public static void main(String[] args) {
        // Parameter für die Collection- und Sortierungsart
        boolean useFIFO = true; // true für FIFO-Ordnung, false für natürliche Sortierung

        // Erstellen von Producer und Consumer
        Collection<Integer> collection;
        if (useFIFO) {
            collection = new LinkedList<>();
        } else {
            collection = new TreeSet<>();
        }

        // Producer und Consumer initialisieren
        Producer producer = new Producer(collection);
        Consumer consumer = new Consumer(collection);

        // Threads für Producer und Consumer erstellen
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        // Threads starten
        producerThread.start();
        consumerThread.start();

        try {
            // Warten, bis die Threads ihre Arbeit beenden
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
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