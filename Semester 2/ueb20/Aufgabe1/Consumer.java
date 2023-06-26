import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Collection;
import java.util.Collections;

/**
 * Consumiert integer aus einer Collection
 *
 * @author Marc Perwak und Jonas Neu
 */
class Consumer {
    private Map<Integer, List<Long>> quersummenMap;
    private Map<Integer, Integer> heufigkeitenMap;

    public Consumer() {
        quersummenMap = new HashMap<>();
        heufigkeitenMap = new HashMap<>();
    }

    public void consume(int zahl) {
        // Quersumme berechnen
        int quersumme = berechneQuersumme(zahl);

        // Zeitstempel speichern
        long zeitstempel = System.nanoTime();
        List<Long> alleZeitstempel = quersummenMap.getOrDefault(quersumme, new ArrayList<>());
        alleZeitstempel.add(zeitstempel);
        quersummenMap.put(quersumme, alleZeitstempel);

        // Anzahl der Vorkommen aktualisieren
        int vorkommen = heufigkeitenMap.getOrDefault(zahl, 0);
        heufigkeitenMap.put(zahl, vorkommen + 1);
    }

    private int berechneQuersumme(int zahl) {
        int querSumme = 0;
        while (zahl > 0) {
            querSumme += zahl % 10;
            zahl /= 10;
        }
        return querSumme;
    }

    public int numberOfDifferentResults() {
        return quersummenMap.size();
    }

    public int numberOfOccurrences(int zahl) {
        return heufigkeitenMap.getOrDefault(zahl, 0);
    }

    public Collection<Integer> getCrossTotalsAscending() {
        return new TreeSet<>(quersummenMap.keySet());
    }

    public Collection<Integer> getCrossTotalsDescending() {
        TreeSet<Integer> absteigendeListe = new TreeSet<>(Collections.reverseOrder());
        absteigendeListe.addAll(quersummenMap.keySet());
        return absteigendeListe;
    }

    public Collection<Long> getTimestampsForResult(int zahl) {
        return quersummenMap.getOrDefault(zahl, new ArrayList<>());
    }
}