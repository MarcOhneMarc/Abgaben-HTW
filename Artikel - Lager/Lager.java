/**
 * Lager
 *
 * @author Marc Perwark & Jonas Neu
 * @06.11.2022
 */

 public class Lager {
   //initialisierung der Attribute
   private int arraylaenge;

   /**
   * Konstruktor zum initialisiern der Lagergroesse
   *
   * @param arraylaenge gibt an wie viele speicherplaetze im Array vergeben werden
   */
   public Lager(int arraylaenge) {
     this.arraylaenge = arraylaenge;
   }

   /**
   * Starndard-Konstruktor zum initialisiern eines Lagers mit der Lagergroesse 10
   */
   public Lager() {
     this.arraylaenge = 10;
   }
 }
