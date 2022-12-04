import java.lang.reflect.Array;

/**
 * Lager
 *
 * @author Marc Perwark & Jonas Neu
 * @06.11.2022
 */
 public class Lager {
   //initialisierung der Attribute

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

       String artikelNr = artikel.getArtikelNr();
       int index = findeRoboterIndex(artikelNr);

       if (index != ROBOTER_NICHT_GEFUNDEN) {
           throw new IllegalArgumentException(ERROR_ROBOTER_BEREITS_REGISTRIERT);
       }

       allArtikels[countArtikel] = artikel;
       countArtikel++;

  }

 }
