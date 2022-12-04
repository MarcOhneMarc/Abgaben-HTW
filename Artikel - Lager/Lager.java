import java.lang.reflect.Array;

/**
 * Lager
 *
 * @author Marc Perwark & Jonas Neu
 * @06.11.2022
 */

 public class Lager {
   //initialisierung der Attribute

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
 }
