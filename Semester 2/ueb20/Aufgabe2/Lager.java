import static java.lang.String.format;
import static java.lang.String.valueOf;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Klasse zum erstellen eines Lagers, in dem man mehrere Artikel der klasse Artikel.java speichern kann.
 *
 * @Marc_Perwark_&_Jonas_Neu
 */
 public class Lager {
    //initialisierung der Attribute
    private static final Artikel ARTIKEL_NICHT_GEFUNDEN = null;
    private static final String ERROR_ARTIKEL_EXISTIERT_BEREITS = "Dieser Artikel ist bereits im Lager!";
    private static final String MINIMAL_MAXIMAL_LAGER = "Das Lager darf minimal 1 und maximal 10 einheiten groß sein!";
    private static final String ARTIKEL_EXISTIERT_NICHT = "Dieser Artikel existiert noch nicht!";
    private static final String LAGER_VOLL = "Das Lager ist voll!";
    private static final String KEIN_LAGER = "Es existiert noch kein Lager!";
    private static final String LAGER_LEER = "Es existiert noch kein Artikel im Lager!";
    private static final String SPEICHERSTELLE_NICHT_VORHANDEN = "Diese Speicherstelle existiert nicht!";
    private static final String KEIN_NEGATIVER_LAGERPLATZ = "Es gibt keinen negativen Lagerplatz!";
    private static final String PREIS_KLEINER_NULL = "Der Preis darf nicht negativ werden!";
    
    
    private Map<Integer, Artikel> allArtikels;
    private Artikel artikels;
    
    /**
    * Konstruktor zum initialisiern der maximalen Lagergroesse 10
    */
    public Lager() {
        allArtikels = new LinkedHashMap<>();
    }
    

    public void applyToArticles(Consumer<Artikel> operation) {
        allArtikels.values().stream()
                .forEach(operation::accept);
    }

    /**
     * Methode zum Sortieren der Artikel im Lager.
     * 
     * @param kriterium Das Sortierkriterium als Comparator<Artikel>.
     * @return sortedArray Ein sortiertes Array der Artikel im Lager.
     */
    public List<Artikel> getSorted(Comparator<Artikel> kriterium) {
        return allArtikels.values().stream()
                .sorted(kriterium)
                .collect(Collectors.toList());
    }

    /**
    * Methode zum Anlegen eines Artikels
    * 
    * @param artikel artikel ist der Artikel der hinzugefuegt werden soll
    * @throws IllegalArgumentException wenn der Artikel null ist
    * @throws IllegalArgumentException wenn der Lagerplatz belegt ist
    * @throws IllegalArgumentException wenn der Artikel bereits existiert
    */
    public void legeAnArtikel(Artikel artikel){
        // Pruefen ob der Artikel existiert
        if (artikel == null) {
           throw new IllegalArgumentException(ARTIKEL_EXISTIERT_NICHT);
        }

        int artikelNr = artikel.getArtikelNr(); // Abspeichern der Artikelnummer

        // Ueberpruefung ob sich der Artikel noch nicht im Lager befindet
        if (allArtikels.get(artikelNr) != null) {
           throw new IllegalArgumentException(ERROR_ARTIKEL_EXISTIERT_BEREITS);
        }
        
        allArtikels.put(artikelNr, artikel);
    }

    /**
    * Methode zum entfernen eines Artikels
    * 
    * @param artikelNr die Artikelnummer des Artikels, der entfernt werden soll.
    * @throws IllegalArgumentException wenn der Artikel nicht gefunden wird.
    */
    public void entferneArtikel(int artikelNr){

        // Ueberpruefung ob sich der Artikel bereits im Lager befindet
        if (allArtikels.get(artikelNr) == ARTIKEL_NICHT_GEFUNDEN) {
          throw new IllegalArgumentException(ARTIKEL_EXISTIERT_NICHT);
        }
        allArtikels.remove(artikelNr);
    }

    /**
    * Methode zum finden des Index im Lager eines Artikels anhand der artikelNr
    * 
    * @param artikelNr Die Artikelnummer des Artikels, dessen index ausgegeben werden soll
    * @return ARTIKEL_NICHT_GEFUNDEN = -1 bedeutet der Artikel befindet sich nicht im Lager oder i wenn die Artikelnummer gefunden wurde
    */
/*    public int findeArtikelIndex(int artikelNr) {
        for (int i = 0; i < countArtikel; i++) {
          Artikel artikel = allArtikels[i];
          if (artikel.getArtikelNr() == artikelNr) {
            return i;
          }
        }
        return ARTIKEL_NICHT_GEFUNDEN;
    }*/
    
    /**
    * Methode zum buchen einer Bestandserhoehung eines Artikels
    * 
    * @param artikelNr Die Artikelnummer des Artikels, dessen Bestand erhoeht werden soll
    * @param zugang Der Zugang als Ganzzahl
    */
    public void bucheZugang(int artikelNr, int zugang) {

        // Ueberpruefung ob sich der Artikel bereits im Lager befindet
        if (allArtikels.get(artikelNr) == ARTIKEL_NICHT_GEFUNDEN) {
          throw new IllegalArgumentException(ARTIKEL_EXISTIERT_NICHT);
        }
        allArtikels.values().stream().forEach(value -> value.bucheZugang(zugang));
    }
    
    /**
    * Methode zum buchen einer Bestandsverminderung eines Artikels
    * 
    * @param artikelNr Die Artikelnummer des Artikels, dessen Bestand erhoeht werden soll
    * @param abgang Der Abgang als Ganzzahl
    */
    public void bucheAbgang(int artikelNr, int abgang) {

        // Ueberpruefung ob sich der Artikel bereits im Lager befindet
        if (allArtikels.get(artikelNr) == ARTIKEL_NICHT_GEFUNDEN) {
          throw new IllegalArgumentException(ARTIKEL_EXISTIERT_NICHT);
        }
        allArtikels.values().stream().forEach(value -> value.bucheAbgang(abgang));
    }

    /**
     *
     * Methode zum aendern des preises eines Artikel
     *
     * @param artikelNr ist die Artikelnummer des zu aendernden Artikels als Ganzzahl
     * @param prozent uebergebene Prozentzahl als double
     */
    public void aenderePreisEinesArtikels(int artikelNr, double prozent) {
        // Ueberpruefung ob sich der Artikel bereits im Lager befindet
        if (allArtikels.get(artikelNr) == ARTIKEL_NICHT_GEFUNDEN) {
          throw new IllegalArgumentException(ARTIKEL_EXISTIERT_NICHT);
        }
        double preisAkktuel = allArtikels.get(artikelNr).getPreis(); // Der aktuelle Preis des Artikels wird abgespeichert
        double preisRechnung = (preisAkktuel + (preisAkktuel / 100) * prozent); // Geaenderter Preis wird abgespeichert
        
        if (preisRechnung < 0) {
          throw new IllegalArgumentException(PREIS_KLEINER_NULL);
        }
        allArtikels.get(artikelNr).setPreis(preisRechnung);
    }

    /**
     *
     * Methode zum aendern des Preises aller Artikel
     *
     * @param prozent uebergebene Prozentzahl als double
     */
    public void aenderePreisAllerArtikel(double prozent) {
        allArtikels.values().stream()
                .forEach(value -> value.setPreis(value.getPreis() + (value.getPreis() / 100) * prozent));
    }
   
    /**
     * Methode zum ausgeben des ganzen Lagers und den Artikeln, die sich darin befinden mir dem Gesamtpreis
     * 
     * @return ausgabe die Ausgabe des ganzen Lagers und den Artikeln, die sich darin befinden als String
     */
    public String ausgebenBestandsListe() {
        double warenwertLager = 0;
        StringBuilder ausgabe = new StringBuilder(); // Verwendung von StringBuilder anstelle von String für effiziente Zeichenkettenmanipulation

        ausgabe.append(String.format("%-10s %-60s %8s %10s %9s", "ArtikelNr", "Beschreibung", "Preis", "Bestand", "Gesamt"));
        ausgabe.append("\n-----------------------------------------------------------------------------------------------------\n");

        warenwertLager = allArtikels.entrySet().stream()
                .filter(entry -> entry.getValue() != null)
                .mapToDouble(entry -> {
                    Artikel artikel = entry.getValue();
                    double gesamt = getGesamt(artikel);
                    ausgabe.append(artikel.toString()).append(String.format("%10.2f", gesamt)).append("\n");
                    return gesamt;
                })
                .sum();

        ausgabe.append("-----------------------------------------------------------------------------------------------------\n");
        ausgabe.append(String.format("%s %89.2f", "Gesamtwert:", warenwertLager));

        return ausgabe.toString();
    }
    
    /**
     * Methode zum ausgeben des ganzen Lagers und den Artikeln, die sich darin befinden
     * 
     * @return ausgabe die Ausgabe des ganzen Lagers und den Artikeln, die sich darin befinden als String
     */
    public String toString() {
        String ausgabe = ""; // Definition der Variable "ausgabe" als String
        ausgabe = format("\n%-10s %-60s %8s %10s", "ArtikelNr", "Beschreibung", "Preis", "Bestand");
        ausgabe = ausgabe + "\n-------------------------------------------------------------------------------------------\n";
        // Erweitern der ausgabe in den String
        ausgabe = allArtikels.values().stream()
                .map(Artikel::toString)
                .collect(Collectors.joining("\n"));
        ausgabe += "\n";


        return ausgabe;
    }
    
    /**
     * Methode zum ausgeben eines Artikels anhand seines index
     * 
     * @param artikelNr der index als Ganzzahl von 1 bis 10
     * @return Artikel der Artikel and der stelle Index
     */
    public Artikel getArtikel(int artikelNr) {
        return allArtikels.get(artikelNr);
    }

    /**
     * Methode zum ausgeben der Anzahl aller Artikel
     * 
     * @return countArtikel Die Anzahl der Artikel
     */
    public int getArtikelAnzahl(){
        return allArtikels.size();
    }
    
    /**
     * Methode zum berechnen des Gesamten Wert des Bestands eines Artikels
     * 
     * @param artikel Jeweiliger Artikel, dessen Gesamtwert berechnet werden soll
     * @retrun gesamt Der gesamte, ausgerechnete Wert der Artikel
     */
    public double getGesamt(Artikel artikel){
        return artikel.getPreis() * artikel.getBestand();
    }

    /**
     * Get Methode zur ausgabe der Lagergroesse als Ganzzahl
     *
     * @return rueckgabe Die Groesse des Lagers als Ganzzahl
     */
    public int getLagerGroesse(){
            return allArtikels.size();
    }

    public Artikel filter(Predicate<Object> filter){
        return allArtikels.values().stream()
                .filter(filter)
                .findFirst()
                .orElse(null);
    }
    
    public void applyToSomeArticles(Predicate<Object> filter, Consumer<Artikel> artikelConsumer){
        allArtikels.values().stream()
                .filter(filter)
                .forEach(artikelConsumer::accept);
    }

    public Artikel[] filterAll(Predicate<Artikel> ... filter) {
        return allArtikels.values().stream()
                .filter(artikel -> Arrays.stream(filter).allMatch(f -> f.test(artikel)))
                .toArray(Artikel[]::new);
    }

    public Artikel[] getArticles(Predicate<Object> filter, BiPredicate<Artikel, Artikel> kriterium) {
        Artikel[] filteredArray = allArtikels.values().stream()
                .filter(filter)
                .toArray(Artikel[]::new);

        for (int i = 0; i < filteredArray.length; i++) {
            for (int j = i + 1; j < filteredArray.length; j++) {
                if (kriterium.test(filteredArray[i], filteredArray[j])) {
                    Artikel temp = filteredArray[i];
                    filteredArray[i] = filteredArray[j];
                    filteredArray[j] = temp;
                }
            }
        }

        return filteredArray;
    }
}