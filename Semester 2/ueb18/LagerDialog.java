import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiPredicate;

/**
 * Bestandsfuehrung.
 *
 * @autor Marc Perwark & Jonas Neu
 * 06.11.2022
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
    private static final int get_Artikel_Sorted = 12;
    private static final int ende = 0;
    
    // Konstanten fuer die Fehlermeldungen.
    private static final String KEIN_LAGER_EXISTIERT = "Es wurde noch kein Lager erstellt";
    private static final String FALSCHE_EINGABE = "Falsche Eingabe!";
    
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
        System.out.println("\nPress '1' zum erzeugen eines Lagers");
        System.out.println("Press '2' zum hinzufuegen eines Artikels");
        System.out.println("Press '3' zum entfernen eines Artikels");
        System.out.println("Press '4' zum buchen eines Zugangs für einen Artikel");
        System.out.println("Press '5' zum buchen eines Abgangs für einen Artikel");
        System.out.println("Press '6' zum aendern des Preis eines Artikels");
        System.out.println("Press '7' zum aendern des Preis aller Artikel");
        System.out.println("Press '8' zum ermittlen eines Artikel an einer bestimmten Stelle im Lager");
        System.out.println("Press '9' zum ausgeben des Lagers");
        System.out.println("Press '10' zum ausgeben der aktuellen Anzahl der Artikel im Lager");
        System.out.println("Press '11' zum bestimmen der Anzahl der Artikel, die ins Lager gelegt werden koennen");
        System.out.println("Press '12' getArtikelSortedtest");
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
            case buche_zugang: bucheZugang();
            break;
            case buche_abgang: bucheAbgang();
            break;
            case aendere_preis_eines_artikels: aenderePreisEinesArtikels();
            break;
            case aendere_preis_aller_artikels: aenderePreisAllerArtikel();
            break;
            case get_artikel: getArtikel();
            break;
            case to_string: to_String();
            break;
            case get_artikel_anzahl: getArtikelAnzahl();
            break;
            case get_lager_groesse: getlagergroesse();
            break;
            case get_Artikel_Sorted: getArtikelSorted();
            break;
            case ende: System.out.println("Programmende!");
        }
    }
    
    /**
    * Standart-Konstruktor oder Konstruktor zum initialisiern der Lagergroesse wird aufgerufen
    *
    * @return arraylaenge gibt an wie viele speicherplaetze im Array vergeben werden
    */
    private Lager lager_erstellen() {
        if (lager != null) {
            throw new IllegalArgumentException(KEIN_LAGER_EXISTIERT);
        } else {
            System.out.print("Wollen sie ein Lager mit einer bestimmten Anzahl von Lagerplaetzen [Y/N]: ");
            char choice = input.nextLine().charAt(0);
            if (choice == 'Y') {
                System.out.print("Geben sie die Lagerkapazitaet an (Maximal 10): ");
                int arraylaenge = input.nextInt();
                input.nextLine();
                return new Lager(arraylaenge);
            } else if (choice == 'N') {
                System.out.print("Lager mit der maximalen Lagergroesse 10 wird erstellt!\n");
                return new Lager(10);
            } else {
                throw new IllegalArgumentException(FALSCHE_EINGABE);
            }
        }
    }
    
    /**
    * Methode zum anlegen eines Artikels wird aufgerufen
    */
    private void artikel_anlegen() {
        if (lager == null) {
            throw new IllegalArgumentException(KEIN_LAGER_EXISTIERT);
        } else {

            System.out.println("Eingabe der ID als Ganzzahl mit 4 Ziffern:");
            int artikelNr = input.nextInt();
            input.nextLine();
            System.out.println("Eingabe des Preises als Double:");
            double preis = input.nextDouble();
            input.nextLine();

            System.out.print("Geben Sie bitte an, welchen Artikel sie erzeugen wollen (1-4) \nCD: 1 \nBuch: 2 \nVideo: 3 \nSonstige:4");
            int choiceArtikel = input.nextInt();
            input.nextLine();
            if (choiceArtikel == 4) {
                System.out.println("Eingabe der Art als String:");
                String art = input.nextLine();
                input.nextLine();
                System.out.print("Wollen sie einen Artikel mit Bestand erstellen [Y/N]: ");
                char choice = input.nextLine().charAt(0);
                if (choice == 'Y') {
                    System.out.println("Eingabe des Bestandes:");
                    int bestand = input.nextInt();
                    input.nextLine();
                    artikel = new Artikel(artikelNr, art, bestand, preis);
                } else if (choice == 'N') {
                    artikel = new Artikel(artikelNr, art, preis);
                } else {
                    throw new IllegalArgumentException(FALSCHE_EINGABE);
                }
            } else if (choiceArtikel == 1) {
                cdAnlegen(artikelNr,preis);
            } else if (choiceArtikel == 2) {
                buchAnlegen(artikelNr,preis);
            } else if (choiceArtikel == 3) {
                videoAnlegen(artikelNr,preis);
            }
            lager.legeAnArtikel(artikel);
        }
    }

    /**
     * Methode zum Anlegen eines CD Artikels
     * @param artikelNr uebergeben artikel nummer
     * @param preis uebergebener Preis
     */
    public void cdAnlegen(int artikelNr, double preis){
        System.out.println("Geben Sie den Interpreten an");
        String interpret = input.nextLine();
        input.nextLine();
        System.out.println("Geben Sie den Titel an");
        String titel = input.nextLine();
        System.out.println("Geben Sie die Anzahl der Titel an");
        int anzahlTitel = input.nextInt();
        input.nextLine();
        System.out.println("Geben Sie den Bestand an:");
        int bestand = input.nextInt();

        artikel = new CD(artikelNr, bestand, preis, interpret, titel, anzahlTitel);
    }

    /**
     * Methode zum Anlegen eines Buch Artikels
     * @param artikelNr uebergeben artikel nummer
     * @param preis uebergebener Preis
     */
    public void buchAnlegen(int artikelNr, double preis){
        System.out.println("Geben Sie den Interpreten an");
        String verlag = input.nextLine();
        input.nextLine();
        System.out.println("Geben Sie den Titel an");
        String titel = input.nextLine();
        input.nextLine();
        System.out.println("Geben Sie den Autor an");
        String autor = input.nextLine();
        input.nextLine();
        System.out.println("Geben Sie den Bestand an:");
        int bestand = input.nextInt();
        input.nextLine();

        artikel = new Buch(artikelNr, bestand, preis, verlag, titel, autor);
    }

    /**
     * Methode zum Anlegen eines Video Artikels
     * @param artikelNr uebergeben artikel nummer
     * @param preis uebergebener Preis
     */
    public void videoAnlegen(int artikelNr, double preis){
        System.out.println("Geben Sie den Titel an");
        String titel = input.nextLine();
        input.nextLine();
        System.out.println("Geben Sie die Spieldauer in Minuten ein");
        int spieldauer = input.nextInt();
        input.nextLine();
        System.out.println("Geben Sie das Erscheinungsjahr ein");
        int jahr = input.nextInt();
        input.nextLine();
        System.out.println("Geben Sie den Bestand an:");
        int bestand = input.nextInt();
        input.nextLine();

        artikel = new Video(artikelNr, bestand, preis, titel, spieldauer, jahr);
    }
    
    /**
    * Methode zum entfernen eines Artikels wird aufgerufen
    */
    private void artikel_entfernen() {
        if (lager == null) {
            throw new IllegalArgumentException(KEIN_LAGER_EXISTIERT);
        } else {
            System.out.println("Eingabe der Artikelnummer als Ganzzahl mit 4 Ziffern:");
            int artikelNr = input.nextInt();
            
            lager.entferneArtikel(artikelNr);
        }
    }

    /**
    * Methode zum buchen einer Bestandserhoehung eines Artikels
    */
    private void bucheZugang() {
        if (lager == null) {
            throw new IllegalArgumentException(KEIN_LAGER_EXISTIERT);
        } else {
            System.out.println("ArtikelNr:");
            int artikelNr = input.nextInt();
            System.out.println("Zugang:");
            int zugang = input.nextInt();
            lager.bucheZugang(artikelNr, zugang);
        }
    }
    
    /**
    * Methode zum buchen einer Bestandsverminderung eines Artikels    
    */
    private void bucheAbgang() {
        if (lager == null) {
            throw new IllegalArgumentException(KEIN_LAGER_EXISTIERT);
        } else {
            System.out.println("ArtikelNr:");
            int artikelNr = input.nextInt();
            System.out.println("Abgang:");
            int abgang = input.nextInt();
            lager.bucheAbgang(artikelNr, abgang);
        }
    }
    
    /**
    * Methode zum aendern des preises eines Artikel
    */
    private void aenderePreisEinesArtikels(){
        if (lager == null) {
            throw new IllegalArgumentException(KEIN_LAGER_EXISTIERT);
        } else {
            System.out.println("Geben sie die ArtikelNr ein, dessen Preis geaendert werden soll: ");
            int artikelNr = input.nextInt();
            System.out.println("Geben sie ein, um wie viel Prozent der Preis des Artikels geaendert werden soll:");
            int procent = input.nextInt();
    
            lager.aenderePreisEinesArtikels(artikelNr,procent);
        }
    }
    
    /**
     * Methode zum aendern des preises aller Artikel
     */
    private void aenderePreisAllerArtikel(){
        if (lager == null) {
            throw new IllegalArgumentException(KEIN_LAGER_EXISTIERT);
        } else {
            System.out.println("Geben sie ein, um wie viel Prozent der Preis aller Artikel geaendert werden soll: ");
            int procent = input.nextInt();
    
            lager.aenderePreisAllerArtikel(procent);
        }
    }

    /**
     * Methode zum ausgeben des ganzen Lagers und den Artikeln, die sich darin befinden
     */
    private void to_String() {
        if (lager == null) {
            throw new IllegalArgumentException(KEIN_LAGER_EXISTIERT);
        } else {
            System.out.println(lager.toString());
        }
    }
    
    /**
     * Methode zum ausgeben eines Artikels anhand seines Index
     */
    private void getArtikel() {
        if (lager == null) {
            throw new IllegalArgumentException(KEIN_LAGER_EXISTIERT);
        } else {
            System.out.println("Index:");
            int index = input.nextInt();
            
            System.out.println(lager.getArtikel(index));
        }
    }
    
    /**
     * Methode zum ausgeben der Anzahl aller Artikel
     */
    private void getArtikelAnzahl(){
        if (lager == null) {
            throw new IllegalArgumentException(KEIN_LAGER_EXISTIERT);
        } else {
            System.out.println("Es befinden sich: " + lager.getArtikelAnzahl() + " im Lager");
        }
    }
    
    /**
     * Methode zum ausgeben der Anzahl aller Artikel
     */
    private void getArtikelSorted(){
        if (lager == null) {
            throw new IllegalArgumentException(KEIN_LAGER_EXISTIERT);
        } else {
            // Sortieren nach Artikelnummer
            Comparator<Artikel> artikelnummerComparator = Comparator.comparingInt(Artikel::getArtikelNr);
            Artikel[] sortedByArtikelnummer = lager.getSorted(artikelnummerComparator);
            System.out.println("1: " + sortedByArtikelnummer);
            // Sortieren nach Beschreibung
            Comparator<Artikel> beschreibungComparator = Comparator.comparing(Artikel::getBeschreibung);
            Artikel[] sortedByBeschreibung = lager.getSorted(beschreibungComparator);
            System.out.println("2: " + sortedByArtikelnummer);
        }
    }

    /**
     * Get Methode zur ausgabe der Lagergroesse als Ganzzahl
     */
    private void getlagergroesse(){
        if (lager == null) {
            throw new IllegalArgumentException(KEIN_LAGER_EXISTIERT);
        } else {
            System.out.println("Die groesse des Lagers betraegt: " + lager.getLagerGroesse() + " Plaetze");
        }
    }
    
    public static void main(String[] args) {
        new LagerDialog().start();
    }
}
