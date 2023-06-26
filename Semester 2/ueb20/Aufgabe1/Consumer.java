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
    
    /**
     * Diese Methode nimmt einen Integer entgegen und 
     * berechnet die Quersumme mit Zeitangabe.
     * 
     * @param number Die Zahl, dessen Quersumme berechnet werden soll.
     */
    public void consume(int zahl) {
        //quersumme berechnen
        int quersumme = berechneQuersumme(zahl);

        //zeitstempel
        long zeitstempel = System.nanoTime();
        List<Long> alleZeitstempel = quersummenMap.getOrDefault(quersumme, new ArrayList<>());
        alleZeitstempel.add(zeitstempel);
        quersummenMap.put(quersumme, alleZeitstempel);

        //anzahl der Vorkommen aktualisieren
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

    /**
     *  gibt an, wie viele unterschiedliche Quersummen berechnet wurden
     */
    public int numberOfDifferentResults() {
        return quersummenMap.size();
    }

    /**
     *  gibt für einen gegebenen Integer an, wie häufig dieser als Ergebnis einer Berechnung vorkam
     */
    public int numberOfOccurrences(int zahl) {
        return heufigkeitenMap.getOrDefault(zahl, 0);
    }

    /**
     *  gibt eine Collection zurück, welche die berechneten Quersummen in aufsteigender Reihenfolge enthält
     */
    public Collection<Integer> getCrossTotalsAscending() {
        return new TreeSet<>(quersummenMap.keySet());
    }

    /**
     *  gibt eine Collection zurück, welche die berechneten Quersummen in absteigender Reihenfolge enthält.
     */
    public Collection<Integer> getCrossTotalsDescending() {
        TreeSet<Integer> absteigendeListe = new TreeSet<>(Collections.reverseOrder());
        absteigendeListe.addAll(quersummenMap.keySet());
        return absteigendeListe;
    }

    /**
     *  nimmt einen Integer entgegen und gibt eine Collection zurück,
     *  welche alle zugehörigen Zeitstempel enthält. D.h. die Zeitstempel der Berechnungen, die
     *  zu dem gegebenen Ergebnis geführt haben.
     */
    public Collection<Long> getTimestampsForResult(int zahl) {
        return quersummenMap.getOrDefault(zahl, new ArrayList<>());
    }
}