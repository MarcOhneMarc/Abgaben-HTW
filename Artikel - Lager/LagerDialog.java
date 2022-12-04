import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Bestandsfuehrung.
 *
 * @author Marc Perwark & Jonas Neu
 * @06.11.2022
 */
public class LagerDialog {
    //initialisierung der Attribute
    private Lager lager;
    private Artikel artikel;
    private Scanner input;

    private static final int lager_erstellen = 1;
    private static final int artikel_anlegen = 2;
    private static final int artikel_entfernen = 3;
    private static final int buche_zugang = 4;
    private static final int buche_abgang = 5;
    private static final int aendere_preis_eines_artikels = 6;
    private static final int aendere_preis_aller_artikels = 7;
    private static final int get_artikel = 8;
    private static final int to_string = 9;
    private static final int get_artikel_anzahl = 10;
    private static final int get_lager_groesse = 11;
    private static final int ende = 0;
    
    // Konstanten fuer die Fehlermeldungen.
    private static final String KEIN_LAGER_EXISTIERT = "Es wurde noch kein Lager erstellt";
    
    //Konstruktor zum initialisiern des Scanners
    public LagerDialog() {
        input = new Scanner(System.in);
    }

    /**
     * Hauptschleife des Dialogprogramms.
     */
    public void start() {
        lager = null;
        int funktion = 0;
        do {
            try {
                menu();
                funktion = einlesenFuktion();
                ausfuehrenFunktion(funktion);
            } catch(IllegalArgumentException e) {
                System.out.println(e);
            } catch(InputMismatchException e) {
                System.out.println(e);
                input.nextLine();
            } catch(Exception e) {
                System.out.println(e);
                e.printStackTrace(System.out);
            }
        } while (funktion != ende);
    }

    /**
     * Text des Hauptmenues
     */
    private void menu() {
        System.out.println("Press '1' zum erzeugen eines Lagers");
        System.out.println("Press '2' zum hinzufuegen eines Artikels");
        System.out.println("Press '3' zum entfernen eines Artikels");
        System.out.println("Press '4' zum buchen eines Zugangs für einen Artikel");
        System.out.println("Press '5' zum buchen eines Abgangs für einen Artikel");
        System.out.println("Press '6' zum aendern des Preis eines Artikels");
        System.out.println("Press '7' zum aendern des Preis aller Artikels");
        System.out.println("Press '8' zum ermittlen eines Artikel an einer bestimmten Stelle im Lager");
        System.out.println("Press '9' zum ausgeben des Lagers");
        System.out.println("Press '10' zum ausgeben der aktuellen Anzahl der Artikel im Lager");
        System.out.println("Press '11' zum bestimmen der Anzahl der Artikel, die ins Lager gelegt werden koennen");
        System.out.println("Press '0' zum beenden des Programms");
    }

    /**
     * Einlesen der Funktion
     *
     * @return Auswahl wird im Menu als ganzzahliger Wert zurückgegeben
     */
    private int einlesenFuktion() {
        int funktion = input.nextInt();
        input.nextLine();
        return funktion;
    }

    /**
     * Abfrage welche Funktion ausgeführt werden soll
     *
     * @param funktion gibt die auszufuehrende Funktion als ganze Zahl an
     */
    private void ausfuehrenFunktion(int funktion) {
        switch (funktion) {
        case lager_erstellen: lager = lager_erstellen();
        break;
        case artikel_anlegen: artikel_anlegen();
        break;
        case artikel_entfernen: artikel_entfernen();
        break;
        case get_artikel: artikelAusgeben();
        
        /*        /lager_erstellen();
        } else if (funktion == buche_zugang) {
            //lager_erstellen();
        } else if (funktion == buche_abgang) {
            //lager_erstellen();
        } else if (funktion == aendere_preis_eines_artikels) {
            //lager_erstellen();
        } else if (funktion == aendere_preis_aller_artikels) {
            //lager_erstellen();
        } else if (funktion == get_artikel) {
            //lager_erstellen();
        } else if (funktion == to_string) {
            //lager_erstellen();
        } else if (funktion == get_artikel_anzahl) {
            //lager_erstellen();
        } else if (funktion == get_lager_groesse) {
            //lager_erstellen();
        } else if (funktion == ende) {
            System.out.println("Programmende!");
        } else {
            System.out.println("Falsche Eingabe!");
        }*/
        }
    }
    
    private Lager lager_erstellen() {
        if (lager != null) {
            throw new IllegalArgumentException(KEIN_LAGER_EXISTIERT);
        } else {
            System.out.print("Maximale Lagerkapazität: ");
            int arraylaenge = input.nextInt();
            input.nextLine();
            return new Lager(arraylaenge);
        }
    }
    
    private void artikel_anlegen() {
        if (lager == null) {
            throw new IllegalArgumentException(KEIN_LAGER_EXISTIERT);
        } else {
            System.out.println("Eingabe der ID als Ganzzahl mit 4 Ziffern:");
            int artikelNr = input.nextInt();
            input.nextLine();
            System.out.println("Eingabe der Art als String:");
            String art = input.nextLine();
            System.out.println("Eingabe des Bestandes:");
            int bestand = input.nextInt();
            System.out.println("Eingabe der Preis als Double:");
            double preis = input.nextDouble();
            
            artikel = new Artikel(artikelNr, art, bestand, preis);
            
            lager.legeAnArtikel(artikel);
        }
    }
    
    private void artikel_entfernen() {
        if (lager == null) {
            throw new IllegalArgumentException(KEIN_LAGER_EXISTIERT);
        } else {
            System.out.println("Eingabe der Artikelnummer als Ganzzahl mit 4 Ziffern:");
            int artikelNr = input.nextInt();
            
            lager.entferneArtikel(artikelNr);
        }
    }
    
    private void artikelAusgeben() {
        if (lager == null) {
            throw new IllegalArgumentException(KEIN_LAGER_EXISTIERT);
        } else {
            System.out.println("Index");
            int index = input.nextInt();
            
            System.out.println(lager.getArtikel(index));
        }
    }
    
    public static void main(String[] args) {
        new LagerDialog().start();
    }
}
