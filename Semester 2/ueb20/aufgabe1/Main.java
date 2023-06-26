import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Collection<Integer> collection;
        if (args == "fifo") {
            collection = new LinkedList<>();
        } else {
            collection = new PriorityQueue<>();
        }

        Producer producer = new Producer(collection);
        Consumer consumer = new Consumer(collection);

        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            if (random.nextInt(2) > 0) {
                Thread producerThread = new Thread(producer);
                producerThread.start();
            } else {
                Thread consumerThread = new Thread(consumer);
                consumerThread.start();
            }
        }

        try {
            Thread.sleep(1000); // Warten bis alle threds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Number of different results: " + consumer.numberOfDifferentResults());
        //System.out.println("Occurrences of 123: " + consumer.numberOfOccurrences(123));
        System.out.println("Cross totals (ascending): " + consumer.getCrossTotalsAscending());
        System.out.println("Cross totals (descending): " + consumer.getCrossTotalsDescending());
        System.out.println("Timestamps for result 123: " + consumer.getTimestampsForResult(123));
    }
}