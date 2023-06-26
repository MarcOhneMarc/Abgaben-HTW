import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Collection;
import java.util.Collections;

/**
 * Beschreiben Sie hier die Klasse Consumer.
 *
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
class Consumer {
    private Map<Integer, List<Long>> timestampMap;
    private Map<Integer, Integer> occurrenceMap;

    public Consumer() {
        timestampMap = new HashMap<>();
        occurrenceMap = new HashMap<>();
    }

    public void consume(int number) {
        // Quersumme berechnen
        int crossTotal = calculateCrossTotal(number);

        // Zeitstempel speichern
        long timestamp = System.currentTimeMillis();
        List<Long> timestamps = timestampMap.getOrDefault(crossTotal, new ArrayList<>());
        timestamps.add(timestamp);
        timestampMap.put(crossTotal, timestamps);

        // Anzahl der Vorkommen aktualisieren
        int vorkommen = occurrenceMap.getOrDefault(number, 0);
        occurrenceMap.put(number, vorkommen + 1);
    }

    private int calculateCrossTotal(int number) {
        int crossTotal = 0;
        while (number > 0) {
            crossTotal += number % 10;
            number /= 10;
        }
        return crossTotal;
    }

    public int numberOfDifferentResults() {
        return timestampMap.size();
    }

    public int numberOfOccurrences(int number) {
        return occurrenceMap.getOrDefault(number, 0);
    }

    public Collection<Integer> getCrossTotalsAscending() {
        return new TreeSet<>(timestampMap.keySet());
    }

    public Collection<Integer> getCrossTotalsDescending() {
        TreeSet<Integer> descendingSet = new TreeSet<>(Collections.reverseOrder());
        descendingSet.addAll(timestampMap.keySet());
        return descendingSet;
    }

    public Collection<Long> getTimestampsForResult(int number) {
        return timestampMap.getOrDefault(number, new ArrayList<>());
    }
}