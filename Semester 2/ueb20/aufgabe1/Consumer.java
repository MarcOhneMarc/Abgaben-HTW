import java.util.*;

public class Consumer implements Runnable{
    private HashMap<Integer, List<Long>> quersummenMap;
    private List<Long> time;
    private Collection<Integer> queue;

    public Consumer(Collection<Integer> queue) {
        this.queue = queue;
        this.quersummenMap = new HashMap<>();
    }

    public void run() {
        try {
            consume();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private void consume() throws InterruptedException {
        synchronized (queue) {
            System.out.println("-");
            while (queue.isEmpty()) {
                try {
                    queue.wait();
                    System.out.println("-");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("--");
                }
            }
            System.out.println("-");
            int value = getFromQueue();
            System.out.println("-");
            berechneQuersumme(value);
            System.out.println("-");
        }
    }

    private int getFromQueue() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Iterator<Integer> iterator = queue.iterator();
            int value = iterator.next();
            iterator.remove();
            return value;
        }
    }

    public int numberOfDifferentResults() {
        return quersummenMap.size();
    }


    public int numberOfOccurrences(int zahl) {
        if (quersummenMap.containsKey(zahl)) {
            int ergebnis = quersummenMap.get(zahl).size();
            return ergebnis;
        } else {
            return 0;
        }
    }

    public List<Integer> getCrossTotalsAscending() {
        List<Integer> totalAscending = new ArrayList<>();
        for (int key : quersummenMap.keySet()) {
            totalAscending.add(key);
        }

        totalAscending.sort(Comparator.naturalOrder());

        return totalAscending;
    }

    public List<Integer> getCrossTotalsDescending() {
        List<Integer> totalDescending = new ArrayList<>();
        for (int key : quersummenMap.keySet()) {
            totalDescending.add(key);
        }

        totalDescending.sort(Comparator.reverseOrder());

        return totalDescending;
    }

    public List<Long> getTimestampsForResult(int zahl) {
        if (!quersummenMap.containsKey(zahl)) {
            throw new IllegalArgumentException("Die Quersumme ist nicht enthalten");
        }
        List<Long> timeStampsForResult = new ArrayList<>();
        timeStampsForResult = quersummenMap.get(zahl);

        return timeStampsForResult;
    }

    public int berechneQuersumme(int zahl) {
        long STZeitStempel = System.nanoTime();
        if (zahl < 0) {
            throw new IllegalArgumentException("Die Zahl darf nicht negativ sein");
        }
        int ergebnis = 0;
        while (zahl > 0) {
            int ziffer = zahl % 10;
            ergebnis += ziffer;
            zahl = zahl / 10;
        }
        long EndeZeitStempel = System.nanoTime();

        if (quersummenMap.containsKey(zahl)){
            quersummenMap.get(zahl).add(EndeZeitStempel - STZeitStempel);
        } else {
            time = new ArrayList<Long>();
            time.add(EndeZeitStempel - STZeitStempel);
            quersummenMap.put(zahl,time);
        }
        return ergebnis;
    }
}
