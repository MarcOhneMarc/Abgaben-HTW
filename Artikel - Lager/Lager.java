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
    private int id;
    private String name;
    private int bestand;
    private Artikel[] allArtikels;
    
    private int countArtikel;
    
    /**
    * Konstruktor zum initialisiern der Lagergroesse
    *
    * @param arraylaenge gibt an wie viele speicherplaetze im Array vergeben werden
    */
    public Lager(int id, String name, int bestand, int arraylaenge) {
       allArtikels = new Artikel[arraylaenge];
       this.id = id;
       this.name = name;
       this.bestand = bestand;
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

    private int findeArtikelIndex(int artikelNr) {
        for (int i = 0; i < countArtikel; i++) {
          Artikel artikel = allArtikels[i];
          if (artikel.getArtikelNr() == artikelNr) {
            return i;
          }
        }
        return ARTIKEL_NICHT_GEFUNDEN;
    }

    private void aenderePreisEinesArtikels(int artikelNr, double prozent) {
    int artikelIndex = findeArtikelIndex(artikelNr);
    
    if (artikelIndex == ARTIKEL_NICHT_GEFUNDEN) {
      throw new IllegalArgumentException("Ein Artikel mit der Id " +
      artikelNr + " exixtiert nicht!");
    }
    Artikel artikel = allArtikels[artikelIndex];
    artikel.setPreis(artikel.getPreis()*prozent);
    }
}