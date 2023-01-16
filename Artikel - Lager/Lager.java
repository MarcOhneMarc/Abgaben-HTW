import static java.lang.String.format;

/**
 * Klasse zum erstellen eines Lagers, in dem man mehrere Artikel der klasse Artikel.java speichern kann.
 *
 * @Marc_Perwark_&_Jonas_Neu
 */
 public class Lager {
    //initialisierung der Attribute
    private static final int ARTIKEL_NICHT_GEFUNDEN = -1;
    private static final String ERROR_ARTIKEL_EXISTIERT_BEREITS = "Dieser Artikel ist bereits im Lager!";
    private static final String MINIMAL_MAXIMAL_LAGER = "Das Lager darf minimal 1 und maximal 10 einheiten groß sein!";
    private static final String ARTIKEL_EXISTIERT_NICHT = "Dieser Artikel existiert noch nicht!";
    private static final String LAGER_VOLL = "Das Lager ist voll!";
    private static final String KEIN_LAGER = "Es existiert noch kein Lager!";
    private static final String LAGER_LEER = "Es existiert noch kein Artikel im Lager!";
    private static final String SPEICHERSTELLE_NICHT_VORHANDEN = "Diese Speicherstelle existiert nicht!";
    private static final String KEIN_NEGATIVER_LAGERPLATZ = "Es gibt keinen negativen Lagerplatz!";
    
    private Artikel[] allArtikels;
    private int countArtikel;
    private int arraylaenge;
    
    /**
    * Konstruktor zum initialisiern der Lagergroesse
    *
    * @param arraylaenge gibt an wie viele Speicherplaetze im Array vergeben werden
    */
    public Lager(int arraylaenge) {
        if (arraylaenge > 10 || arraylaenge <= 0) {
            throw new IllegalArgumentException(MINIMAL_MAXIMAL_LAGER);
        } else {
           allArtikels = new Artikel[arraylaenge];
           this.arraylaenge = arraylaenge;
        }
    }
    
    /**
    * Konstruktor zum initialisiern der maximalen Lagergroesse 10
    */
    public Lager() {
        allArtikels = new Artikel[10];
        this.arraylaenge = 10;
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
        
        // Pruefen ob das Lager schon voll ist
        if (arraylaenge == countArtikel) {
           throw new IllegalArgumentException(LAGER_VOLL);
        }
        
        int artikelNr = artikel.getArtikelNr(); // Abspeichern der Artikelnummer
        int index = findeArtikelIndex(artikelNr); // Abspeichern des Index eines Artikels
        
        // Ueberpruefung ob sich der Artikel noch nicht im Lager befindet
        if (index != ARTIKEL_NICHT_GEFUNDEN) {
           throw new IllegalArgumentException(ERROR_ARTIKEL_EXISTIERT_BEREITS);
        }
        
        allArtikels[countArtikel] = artikel;
        countArtikel++;
    }

    /**
    * Methode zum entfernen eines Artikels
    * 
    * @param artikelNr die Artikelnummer des Artikels, der entfernt werden soll.
    * @throws IllegalArgumentException wenn der Artikel nicht gefunden wird.
    */
    public void entferneArtikel(int artikelNr){
        int artikelIndex = findeArtikelIndex(artikelNr); // Abspeichern des Index an dem sich der Artikel befindet

        // Ueberpruefung ob sich der Artikel bereits im Lager befindet
        if (artikelIndex == ARTIKEL_NICHT_GEFUNDEN) {
          throw new IllegalArgumentException(ARTIKEL_EXISTIERT_NICHT);
        }

        for (int i = artikelIndex; i < countArtikel -1; i++) {
          allArtikels[i] = allArtikels[i + 1];
        }
        allArtikels[countArtikel - 1] = null;
        countArtikel--;
    }

    /**
    * Methode zum finden des Index im Lager eines Artikels anhand der artikelNr
    * 
    * @param artikelNr Die Artikelnummer des Artikels, dessen index ausgegeben werden soll
    * @return ARTIKEL_NICHT_GEFUNDEN = -1 bedeutet der Artikel befindet sich nicht im Lager oder i wenn die Artikelnummer gefunden wurde
    */
    public int findeArtikelIndex(int artikelNr) {
        for (int i = 0; i < countArtikel; i++) {
          Artikel artikel = allArtikels[i];
          if (artikel.getArtikelNr() == artikelNr) {
            return i;
          }
        }
        return ARTIKEL_NICHT_GEFUNDEN;
    }
    
    /**
    * Methode zum buchen einer Bestandserhoehung eines Artikels
    * 
    * @param artikelNr Die Artikelnummer des Artikels, dessen Bestand erhoeht werden soll
    * @param zugang Der Zugang als Ganzzahl
    */
    public void bucheZugang(int artikelNr, int zugang) {
        int artikelIndex = findeArtikelIndex(artikelNr); // Abspeichern des Index an dem sich der Artikel befindet
        
        // Ueberpruefung ob sich der Artikel bereits im Lager befindet
        if (artikelIndex == ARTIKEL_NICHT_GEFUNDEN) {
          throw new IllegalArgumentException(ARTIKEL_EXISTIERT_NICHT);
        } else {
            allArtikels[artikelIndex].bucheZugang(zugang);
        }
    }
    
    /**
    * Methode zum buchen einer Bestandsverminderung eines Artikels
    * 
    * @param artikelNr Die Artikelnummer des Artikels, dessen Bestand erhoeht werden soll
    * @param abgang Der Abgang als Ganzzahl
    */
    public void bucheAbgang(int artikelNr, int abgang) {
        int artikelIndex = findeArtikelIndex(artikelNr); // Abspeichern des Index an dem sich der Artikel befindet

        // Ueberpruefung ob sich der Artikel bereits im Lager befindet
        if (artikelIndex == ARTIKEL_NICHT_GEFUNDEN) {
          throw new IllegalArgumentException(ARTIKEL_EXISTIERT_NICHT);
        } else {
            allArtikels[artikelIndex].bucheAbgang(abgang);
        }
    }

    /**
     *
     * Methode zum aendern des preises eines Artikel
     *
     * @param artikelNr ist die Artikelnummer des zu aendernden Artikels als Ganzzahl
     * @param prozent uebergebene Prozentzahl als double
     */
    public void aenderePreisEinesArtikels(int artikelNr, double prozent) {
        int artikelIndex = findeArtikelIndex(artikelNr); // Abspeichern des Index an dem sich der Artikel befindet

        // Ueberpruefung ob sich der Artikel bereits im Lager befindet
        if (artikelIndex == ARTIKEL_NICHT_GEFUNDEN) {
          throw new IllegalArgumentException(ARTIKEL_EXISTIERT_NICHT);
        } else {
            double preisAkktuel = allArtikels[artikelIndex].getPreis(); // Der aktuelle Preis des Artikels wird abgespeichert
            double preisRechnung = (preisAkktuel + (preisAkktuel / 100) * prozent); // Geaenderter Preis wird abgespeichert
            Artikel artikel = allArtikels[artikelIndex];
            artikel.setPreis(preisRechnung);
        }
    }

    /**
     *
     * Methode zum aendern des Preises aller Artikel
     *
     * @param prozent uebergebene Prozentzahl als double
     */
    public void aenderePreisAllerArtikel(double prozent) {
        // For-Schleife zur Ermittlung der Artikel im Array
        for (int i = 0; i < countArtikel; i++) {
            double preisAkktuel = allArtikels[i].getPreis(); // Der aktuelle Preis des Artikels an der stelle i des Arrays
            double preisRechnung = (preisAkktuel + (preisAkktuel / 100) * prozent); // Geaenderter Preis
            allArtikels[i].setPreis(preisRechnung);
        }
    }
   
    /**
     * Methode zum ausgeben des ganzen Lagers und den Artikeln, die sich darin befinden mir dem Gesamtpreis
     * 
     * @return ausgabe die Ausgabe des ganzen Lagers und den Artikeln, die sich darin befinden als String
     */
    public String ausgebenBestandsListe() {
        double warenwertLager = 0;
        double gesamt = 0;
        String ausgabe = ""; // Definition der Variable "ausgabe" als String
        ausgabe = format("\n%-10s %-60s %8s %10s %9s", "ArtikelNr", "Beschreibung", "Preis", "Bestand", "Gesamt");
        ausgabe = ausgabe + "\n-----------------------------------------------------------------------------------------------------\n";
        // Erweitern der ausgabe in den String
        for (int i = 0; i < allArtikels.length; i++) {
            if (allArtikels[i] != null) {
                gesamt = getGesamt(allArtikels[i]);
                warenwertLager += gesamt;
                ausgabe = ausgabe + allArtikels[i].toString() + format("%10.2f", gesamt) + "\n";
            }
        }
        ausgabe = ausgabe + "-----------------------------------------------------------------------------------------------------\n";
        ausgabe = ausgabe + format("%s %89.2f", "Gesamtwert:", warenwertLager);
        return ausgabe;
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
        for (int i = 0; i < allArtikels.length; i++) {
            if (allArtikels[i] != null) {
                ausgabe = ausgabe + allArtikels[i].toString() + "\n";
            }
        }
        return ausgabe;
    }
    
    /**
     * Methode zum ausgeben eines Artikels anhand seines index
     * 
     * @param index der index als Ganzzahl von 1 bis 10
     * @return Artikel der Artikel and der stelle Index
     */
    public Artikel getArtikel(int index) {
        // Pruefung ob index == null und ob index groeser ist als die eigentliche array laenge
        if (index < 0){
            throw new IllegalArgumentException(KEIN_NEGATIVER_LAGERPLATZ);
        } else if (index > arraylaenge) {
            throw new IllegalArgumentException(SPEICHERSTELLE_NICHT_VORHANDEN);
        } else{
            return allArtikels[index];
        }
    }

    /**
     * Methode zum ausgeben der Anzahl aller Artikel
     * 
     * @return countArtikel Die Anzahl der Artikel
     */
    public int getArtikelAnzahl(){
        // pruefen, ob es countArtikel nicht null ist
        if (countArtikel == 0)
            throw new IllegalArgumentException(LAGER_LEER);
        else{
            return countArtikel;
        }
    }
    
    /**
     * Methode zum berechnen des Gesamten Wert des Bestands eines Artikels
     * 
     * @param artikel Jeweiliger Artikel, dessen Gesamtwert berechnet werden soll
     * @retrun gesamt Der gesamte, ausgerechnete Wert der Artikel
     */
    public double getGesamt(Artikel artikel){
        double gesamt = artikel.getPreis() * artikel.getBestand();
        return gesamt;
    }

    /**
     * Get Methode zur ausgabe der Lagergroesse als Ganzzahl
     *
     * @return rueckgabe Die Groesse des Lagers als Ganzzahl
     */
    public int getLagerGroesse(){
        // pruefen, ob es countArtikel nicht null ist
        if (allArtikels == null)
            throw new IllegalArgumentException(KEIN_LAGER);
        else {
            return allArtikels.length;
        }
    }
}