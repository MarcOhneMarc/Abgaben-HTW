/**
 * Lager
 *
 * @author Marc Perwark & Jonas Neu
 * 06.11.2022
 */
 public class Lager {
    //initialisierung der Attribute
    private static final int ARTIKEL_NICHT_GEFUNDEN = -1;
    
    private static final String ERROR_ARTIKEL_EXISTIERT_BEREITS = "Dieser Artikel ist bereits im Lager.";
    
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
            throw new IllegalArgumentException("Das Lager darf minimal 1 und maximal 10 einheiten groß sein!");
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

        // Pruefen ob null
       if (artikel == null) {
           throw new IllegalArgumentException("Der Artikel ist null");
       }

       // Pruefen ob die arraylaenge gleich countArtikel
       if (arraylaenge == countArtikel) {
           throw new IllegalArgumentException("Die Lagerplatz ist belegt");
       }

       int artikelNr = artikel.getArtikelNr(); // Abspeichen der artikel nummer die von getArtikelNr uebergeben wird
       int index = findeArtikelIndex(artikelNr); // Wir speichen den rueckgabe wert der findeArtikelIndex Methonde in die variable rein

       // Ueberpruefung, ob was gefunden wird unter der artikel nummer
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
        int artikelIndex = findeArtikelIndex(artikelNr); // Wir speichen den rueckgabe wert der findeArtikelIndex Methonde in die variable rein

        // Ueberpruefung, ob was gefunden wird unter der artikel nummer
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
    * Methode zum Buchen einer bestandserhoehung eines Artikels
    * 
    * @param artikelNr Die Artikelnummer des Artikels, dessen Bestand erhoeht werden soll
    * @param zugang Der Zugang als Ganzzahl
    */
    public void bucheZugang(int artikelNr, int zugang) {
        int artikelIndex = findeArtikelIndex(artikelNr); // Wir speichen den rueckgabe wert der findeArtikelIndex Methonde in die variable rein

        // Ueberpruefung, ob was gefunden wird unter der artikel nummer
        if (artikelIndex == ARTIKEL_NICHT_GEFUNDEN) {
          throw new IllegalArgumentException("Ein Artikel mit der Id " +
          artikelNr + " exixtiert nicht!");
        } else {
            allArtikels[artikelIndex].bucheZugang(zugang);
        }
    }
    
    /**
    * Methode zum Buchen einer bestandsverminderung eines Artikels
    * 
    * @param artikelNr Die Artikelnummer des Artikels, dessen Bestand erhoeht werden soll
    * @param abgang Der Abgang als Ganzzahl
    */
    public void bucheAbgang(int artikelNr, int abgang) {
        int artikelIndex = findeArtikelIndex(artikelNr); // Wir speichen den rueckgabe wert der findeArtikelIndex Methonde in die variable rein

        // Ueberpruefung, ob was gefunden wird unter der artikel nummer
        if (artikelIndex == ARTIKEL_NICHT_GEFUNDEN) {
          throw new IllegalArgumentException("Ein Artikel mit der Id " +
          artikelNr + " exixtiert nicht!");
        } else {
            allArtikels[artikelIndex].bucheAbgang(abgang);
        }
    }

    /**
     *
     * @param artikelNr ist die uebergebene artikelnummer als Integer
     * @param prozent uebergebene Prozentzahl als double
     */
    public void aenderePreisEinesArtikels(int artikelNr, double prozent) {
        int artikelIndex = findeArtikelIndex(artikelNr); // Wir speichen den rueckgabe wert der findeArtikelIndex Methonde in die variable rein

        // Ueberpruefung, ob was gefunden wird unter der artikel nummer
        if (artikelIndex == ARTIKEL_NICHT_GEFUNDEN) {
          throw new IllegalArgumentException("Ein Artikel mit der Id " +
          artikelNr + " exixtiert nicht!");
        }

        double preisAkktuel = allArtikels[artikelIndex].getPreis(); // Der aktuelle Preis des artikels
        double preisRechnung = (preisAkktuel + (preisAkktuel / 100) * prozent); // Geänderter Preis
        Artikel artikel = allArtikels[artikelIndex];
        artikel.setPreis(preisRechnung);
    }

    /**
     *
     * Methode zum aendern des preises aller Artikel
     *
     * @param prozent uebergebene Prozentzahl als double
     */
    public void aenderePreisAllerArtikel(double prozent) {

        // For schleife zur ermittlung der artikel im Array
        for (int i = 0; i < countArtikel; i++) {
            double preisAkktuel = allArtikels[i].getPreis(); // Der aktuelle Preis des artikels an der stelle i des Arrays
            double preisRechnung = (preisAkktuel + (preisAkktuel / 100) * prozent); // Geänderter Preis
            allArtikels[i].setPreis(preisRechnung);
        }
    }


    /**
     * Methode zum Ausgeben des ganzen Lagers und den Artikeln, die sich darin befinden
     * 
     * @return ausgabe die Ausgabe des ganzen Lagers und den Artikeln, die sich darin befinden als String
     */
    public String toString() {
        String ausgabe = ""; // Definition der ausgebe Variable als String

        // Umformatirung der Lagerstaeten
        for (int i = 0; i < allArtikels.length; i++) {
            ausgabe = ausgabe + "[Lagerplatz " + i + ": ";
            if (allArtikels[i] == null) {
                ausgabe = ausgabe + "NULL" + "] ";
            } else {
                ausgabe = ausgabe + allArtikels[i].toString() + "] ";
            }
        }
        return ausgabe;
    }
    
    /**
     * Methode zum Ausgeben eines Artikels anhand des Indexes
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
     * Methode zur rueckgabe der anzahl aller existirenden Artikel im Lager
     *
     * @return Rueckgabe der anzahl artikel als integer
     */
    public int getArtikelAnzahl(){
        // pruefen, ob es die zahl nicht null ist
        if (countArtikel == 0)
            throw new IllegalArgumentException("Es Ist noch kein Artikel im Lager");
        else{
            return countArtikel;
        }
    }

    /**
     * Methode zur rueckgabe der Lagergroese
     *
     * @return rueckgabe der lager groese als integer
     */
    public int getLagerGroesse(){
        // pruefen, ob es das lager nicht null ist
        if (allArtikels == null)
            throw new IllegalArgumentException("Es existiert noch kein lager");
        else {
            return allArtikels.length;
        }
    }
}