/**
 * Klasse zum erstellen eines Lagers, in dem man mehrere Artikel der funktion Artikel.java speichern kann.
 *
 * @author Marc Perwark & Jonas Neu
 * 06.11.2022
 */
 public class Lager {
    //initialisierung der Attribute
    private static final int ARTIKEL_NICHT_GEFUNDEN = -1;
    
    private static final String ERROR_ARTIKEL_EXISTIERT_BEREITS = "Dieser Artikel ist bereits im Lager!";
    private static final String MINIMAL_MAXIMAL_LAGER = "Das Lager darf minimal 1 und maximal 10 einheiten groß sein!";
    private static final String ARTIKEL_EXISTIERT_NICHT = "Dieser Artikel existiert noch nicht!";
    private static final String LAGER_VOLL = "Das Lager ist Voll!";
    
    private int arraylaenge;
    private Artikel[] allArtikels;
    
    private int countArtikel;
    
    /**
    * Konstruktor zum initialisiern der Lagergroesse
    *
    * @param arraylaenge gibt an wie viele speicherplaetze im Array vergeben werden
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
    * Standart-Konstruktor zum initialisiern der maximalen Lagergroesse = 10
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
        
        int artikelNr = artikel.getArtikelNr(); // Abspeichern der Artikelnummer, die von getArtikelNr() uebergeben wird
        int index = findeArtikelIndex(artikelNr); // Abspeichern des Index an dem sich der Artikel befindet
        
        // Ueberpruefung ob sich der Artikel noch nicht im Lager befindet
        if (index != ARTIKEL_NICHT_GEFUNDEN) {
           throw new IllegalArgumentException(ERROR_ARTIKEL_EXISTIERT_BEREITS);
        }
        
        allArtikels[countArtikel] = artikel;
        countArtikel++;

    }

    /**
    * Methode zum Entfernen eines Artikels
    * 
    * @param artikelNr Die Artikelnummer des Artikels der entfernt werden soll.
    * @throws IllegalArgumentException wenn der Artikel nicht gefunden wird.
    */
    public void entferneArtikel(int artikelNr){
        int artikelIndex = findeArtikelIndex(artikelNr); // Abspeichern des Index an dem sich der Artikel befindet

        // Ueberpruefung ob sich der Artikel bereits im Lager befindet
        if (artikelIndex == ARTIKEL_NICHT_GEFUNDEN) {
          throw new IllegalArgumentException("Ein Artikel mit der Id " +
          artikelIndex + " exixtiert nicht!");
        }

        for (int i = artikelIndex; i < countArtikel -1; i++) {
          allArtikels[i] = allArtikels[i + 1];
        }
        allArtikels[countArtikel - 1] = null;
        countArtikel--;
    }

    /**
    * Methode zum Finden des Index im Lager eines Artikels anhand der artikelNr
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
          throw new IllegalArgumentException("Ein Artikel mit der Id " +
          artikelNr + " exixtiert nicht!");
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
          throw new IllegalArgumentException("Ein Artikel mit der Id " +
          artikelNr + " exixtiert nicht!");
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
          throw new IllegalArgumentException("Ein Artikel mit der Id " +
          artikelNr + " exixtiert nicht!");
        } else {
            double preisAkktuel = allArtikels[artikelIndex].getPreis(); // Der aktuelle Preis des Artikels wird abgespeichert
            double preisRechnung = (preisAkktuel + (preisAkktuel / 100) * prozent); // Geaenderter Preis wird abgespeichert
            Artikel artikel = allArtikels[artikelIndex];
            artikel.setPreis(preisRechnung);
        }
    }

    /**
     *
     * Methode zum aendern des preises aller Artikel
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
     * Methode zum Ausgeben des ganzen Lagers und den Artikeln, die sich darin befinden
     * 
     * @return ausgabe die Ausgabe des ganzen Lagers und den Artikeln, die sich darin befinden als String
     */
    public String toString() {
        String ausgabe = ""; // Definition der Variable "ausgabe" als String
        ausgabe = String.format("%-10s %-40s %8s %10s %9", "ArtikelNr", "Beschreibung", "Preis", "Bestand", "Gesamt");
        ausgabe = ausgabe + "\n---------------------------------------------------------------------------------";
        // Erweitern der ausgabe in den String
        for (int i = 0; i < allArtikels.length; i++) {
            if (allArtikels[i] != null) {
                double gesamt = getGesamt(allArtikels[i]);
                ausgabe = ausgabe + "\n" + allArtikels[i].toString() + String.format("%10.2f", gesamt);
            }
        }
        return ausgabe;
    }
    
    /**
     * Methode zum ausgeben eines Artikels anhand seines Index
     * 
     * @param index der index als ganze zahl von 1 bis 10
     * @return Artikel der Artikel and der stelle Index
     */
    public Artikel getArtikel(int index) {
        // Pruefung ob index == null und ob index groeser ist als die eigentliche array laenge
        if (index < 0){
            throw new IllegalArgumentException("Es gibt keinen negativen Lager Platz");
        } else if (index > arraylaenge) {
            throw new IllegalArgumentException("Diese Speicherstelle existiert nicht");
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
            throw new IllegalArgumentException("Es Ist noch kein Artikel im Lager");
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
            throw new IllegalArgumentException("Es existiert noch kein lager");
        else {
            return allArtikels.length;
        }
    }
}