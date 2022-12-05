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
    * Methode zum anlegen eines Artikels
    * 
    * @param Artikel artikel ist der Artikel der hinzugefuegt werden soll
    * @throws IllegalArgumentException wenn der Artikel null ist
    * @throws IllegalArgumentException wenn der Lagerplatz belegt ist
    * @throws IllegalArgumentException wenn der Artikel bereits existiert
    */
    public void legeAnArtikel(Artikel artikel){

       if (artikel == null) {
           throw new IllegalArgumentException("Der Artikel ist null");
       }

       if (arraylaenge == countArtikel) {
           throw new IllegalArgumentException("Die Lagerplatz ist belegt");
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
    * 
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

    /**
    * Methode zum finden des Index im Lager eines Artikels anhand der artikelNr
    * 
    * @param artikelNr Die Artikelnummer des Artikels, dessen index ausgegeben werden soll
    * @return i Ist der gefundene Index
    * @return ARTIKEL_NICHT_GEFUNDEN = -1 bedeutet der Artikel befindet sich nicht im Lager
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
    * Methode zum buchen einer bestandserhoehung eines Artikels
    * 
    * @param artikelNr Die Artikelnummer des Artikels, dessen Bestand erhoeht werden soll
    * @param zugang Der Zugang als Ganzzahl
    */
    public void bucheZugang(int artikelNr, int zugang) {
        int artikelIndex = findeArtikelIndex(artikelNr);
                
        if (artikelIndex == ARTIKEL_NICHT_GEFUNDEN) {
          throw new IllegalArgumentException("Ein Artikel mit der Id " +
          artikelNr + " exixtiert nicht!");
        } else {
            allArtikels[artikelIndex].bucheZugang(zugang);
        }
    }
    
    /**
    * Methode zum buchen einer bestandsverminderung eines Artikels
    * 
    * @param artikelNr Die Artikelnummer des Artikels, dessen Bestand erhoeht werden soll
    * @param zugang Der Abgang als Ganzzahl
    */
    public void bucheAbgang(int artikelNr, int abgang) {
        int artikelIndex = findeArtikelIndex(artikelNr);
        
        if (artikelIndex == ARTIKEL_NICHT_GEFUNDEN) {
          throw new IllegalArgumentException("Ein Artikel mit der Id " +
          artikelNr + " exixtiert nicht!");
        } else {
            allArtikels[artikelIndex].bucheAbgang(abgang);
        }
    }

    public void aenderePreisEinesArtikels(int artikelNr, double prozent) {
        int artikelIndex = findeArtikelIndex(artikelNr);
        
        if (artikelIndex == ARTIKEL_NICHT_GEFUNDEN) {
          throw new IllegalArgumentException("Ein Artikel mit der Id " +
          artikelNr + " exixtiert nicht!");
        }
        Artikel artikel = allArtikels[artikelIndex];
        artikel.setPreis(artikel.getPreis()*(prozent/100));
    }
    
    public String toString() {
        String ausgabe = "";
        
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
    
    public Artikel getArtikel(int index) {
        return allArtikels[index];
    }
}