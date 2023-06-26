import java.util.*;


public class Main {
    public static void main(String[] args) {
        String argumets = Arrays.toString(args);

        System.out.println(",");

        Collection<Integer> collection;
        if (argumets.equals("fifo") || argumets.equals("FIFO")) {
            collection = new LinkedList<>();
        } else  {
            collection = new PriorityQueue<>();
        }

        System.out.println(",");

        Producer producer = new Producer(collection);
        Consumer consumer = new Consumer(collection);

        System.out.println(",");
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();


        System.out.println(",");
        try {
            Thread.sleep(1000); // Warten bis alle threds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(",");
        System.out.println("Number of different results: " + consumer.numberOfDifferentResults());
        //System.out.println("Occurrences of 123: " + consumer.numberOfOccurrences(123));
        System.out.println("Cross totals (ascending): " + consumer.getCrossTotalsAscending());
        System.out.println("Cross totals (descending): " + consumer.getCrossTotalsDescending());
        //System.out.println("Timestamps for result 123: " + consumer.getTimestampsForResult(123));
    }
}