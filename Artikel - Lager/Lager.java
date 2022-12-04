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

   private Artikel[] allArtikels;

   /**
   * Konstruktor zum initialisiern der Lagergroesse
   *
   * @param arraylaenge gibt an wie viele speicherplaetze im Array vergeben werden
   */
   public Lager(int arraylaenge) {
       allArtikels = new Artikel[arraylaenge];
   }

   /**
   * Starndard-Konstruktor zum initialisiern eines Lagers mit der Lagergroesse 10
   */
   public Lager() {
       allArtikels = new Artikel[10];
   }

   public void legeAnArtikel(Artikel artikel){

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
      roboterId + " exixtiert nicht!");
    }

    if (int i = artikelIndex; i < countArtikel -1; i++) {
      allArtikels[i] = allArtikels[i + 1];
    }
    allArtikels[countArtikel - 1] = null;
    countArtikel--;
  }

  private int findeArtikelIndex(String artikelNr) {
    for (int i = 0; i < countArtikel; i++) {
      Artikel artikel = allArtikels;
      if (artikel.getArtikelNr().equals(artikelNr)) {
        return i;
      }
    }
  }
}
