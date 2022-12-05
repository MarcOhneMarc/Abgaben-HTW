import java.lang.reflect.Array;

/**
 * Lager
 *
 * @author Marc Perwark & Jonas Neu
 * @06.11.2022
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
       allArtikels = new Artikel[arraylaenge];
       this.arraylaenge = arraylaenge;
    }
    
    /**
    * Starndard-Konstruktor zum initialisiern eines Lagers mit der Lagergroesse 10
    */
    public Lager() {
       allArtikels = new Artikel[10];
    }

    public void legeAnArtikel(Artikel artikel){

       if (artikel == null) {
           throw new IllegalArgumentException("Der Artikel ist null");
       }

       if (arraylaenge == countArtikel) {
           throw new IllegalArgumentException("Die Station ist belegt");
       }

       int artikelNr = artikel.getArtikelNr();
       int index = findeArtikelIndex(artikelNr);

       if (index != ARTIKEL_NICHT_GEFUNDEN) {
           throw new IllegalArgumentException(ERROR_ARTIKEL_EXISTIERT_BEREITS);
       }

       allArtikels[countArtikel] = artikel;
       countArtikel++;

    }
 
    /**
    * Methode zum entfernen eines Artikels
    * @param artikelNr Die Artikelnummer des Artikels der entfernt werden soll.
    * @throws IllegalArgumentException wenn der Artikel nicht gefunden wird.
    */
    public void entferneArtikel(int artikelNr){
        int artikelIndex = findeArtikelIndex(artikelNr);
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

    public int findeArtikelIndex(int artikelNr) {
        for (int i = 0; i < countArtikel; i++) {
          Artikel artikel = allArtikels[i];
          if (artikel.getArtikelNr() == artikelNr) {
            return i;
          }
        }
        return ARTIKEL_NICHT_GEFUNDEN;
    }
    
    public void bucheZugang(int artikelNr, int zugang) {
        //
    }

    public void aenderePreisEinesArtikels(int artikelNr, double prozent) {
        int artikelIndex = findeArtikelIndex(artikelNr);
        
        if (artikelIndex == ARTIKEL_NICHT_GEFUNDEN) {
          throw new IllegalArgumentException("Ein Artikel mit der Id " +
          artikelNr + " exixtiert nicht!");
        }
        double preisAkktuel = allArtikels[artikelIndex].getPreis(); // Aktuelle Preis des artikels an der stelle i des Arrays
        double preisRechnung = (preisAkktuel + (preisAkktuel / 100) * prozent); // Geänderter Preis
        Artikel artikel = allArtikels[artikelIndex];
        artikel.setPreis(preisRechnung);
    }

    /**
     *
     * Methode zum aendern des preises aller Artikel
     *
     * @param prozent uebergebene Prozentzahl als integer
     */
    public void aenderePreisAllerArtikel(double prozent) {
        
        // For schleife zur ermittlung der artikel im Array
        for (int i = 0; i < countArtikel; i++) {
            Artikel artikel = allArtikels[i];
            double preisAkktuel = allArtikels[i].getPreis(); // Aktuelle Preis des artikels an der stelle i des Arrays
            double preisRechnung = (preisAkktuel + (preisAkktuel / 100) * prozent); // Geänderter Preis
            allArtikels[i].setPreis(preisRechnung);
        }
    }
    
    public Artikel getArtikel(int index) {
        if (index < 0){
            throw new IllegalArgumentException("Es gibt keinen negativen Lager Platz");
        } else if (index > arraylaenge) {
            throw new IllegalArgumentException("Diese Speicherstelle existiert nicht");
        } else{
            return allArtikels[index];
        }
    }

    public int getArtikelAnzahl(){
        if (countArtikel == 0)
            throw new IllegalArgumentException("Es Ist noch kein Artikel im Lager");
        else{
            return countArtikel;
        }
    }
    public int getLagerGroesse(){
        if (allArtikels == null)
            throw new IllegalArgumentException("Es existiert noch kein lager");
        else {
            return allArtikels.length;
        }
    }
}