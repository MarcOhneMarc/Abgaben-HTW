import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Bestandsfuehrung.
 * 
 * @Marc Perwark & Jonas Neu
 * @06.11.2022
 */
public class ArtikelDialog {
    //initialisierung der Attribute
    private Artikel artikel;
    private Scanner input;
    
    private static final int artikel_mit_bestand = 1;
    private static final int artikel_ohne_bestand = 2;
    private static final int zugang_eines_artikel = 3;
    private static final int abgang_eines_artikel = 4;
    private static final int artikel_als_string = 5;
    private static final int art_aendern = 6;
    private static final int bestand_aendern = 7;
    private static final int ende = 0;
    
    //Konstruktor zum initialisiern des Scanners
    public ArtikelDialog() {
        input = new Scanner(System.in);
    }
    
    /**
     * Hauptschleife des Dialogprogramms.
     */
    public void start() {
        artikel = null;
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
        System.out.println("Press '1' zum erzeugen eines Artikels mit Bestand");
        System.out.println("Press '2' zum erzeugen eines Artikels ohne Bestand");
        System.out.println("Press '3' zum buchen einer Bestandserhoehung");
        System.out.println("Press '4' zum buchen einer Bestandsverminderung");
        System.out.println("Press '5' zum ausgeben der aktuellen Werte");
        System.out.println("Press '6' zum ueberschreiben der Art eines Artikels");
        System.out.println("Press '7' zum ueberschreiben des bestands eines Artikels");
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
        if (funktion == artikel_mit_bestand) {
            artikelmitbestand();
        } else if (funktion == artikel_ohne_bestand) {
            artikelOhneBestand();
        } else if (funktion == zugang_eines_artikel) {
            bucheZugang();
        } else if (funktion == abgang_eines_artikel) {
            bucheAbgang();
        } else if (funktion == artikel_als_string) {
            tostring();
        } else if (funktion == art_aendern) {
            setArt();
        } else if (funktion == bestand_aendern) {
            setBestand();
        } else if (funktion == ende) {
            System.out.println("Programmende!");
        } else {
            System.out.println("Falsche Eingabe!");  
        }
    }
    
     /**
     * Aufruf Konstruktor zum initialisiern eines Artikel mit Bestand
     * 
     * @param artikelNr gibt die Artikelnummer als vierstellige ganzzahl an
     * @param art gibt als Zeichenkette an was der Artikel ist
     * @param bestand gibt den wahrenbestand als ganzzahl an
     */
    private void artikelmitbestand() {
        if (artikel != null) {
            System.out.println("Der Artikel existiert schon!"); 
        } else {
            System.out.println("Eingabe der ID als Ganzzahl mit 4 Ziffern:"); 
            int artikelNr = input.nextInt();
            input.nextLine();
            System.out.println("Eingabe der Art als String:"); 
            String art = input.nextLine();
            System.out.println("Eingabe des Bestandes:"); 
            int bestand = input.nextInt();
            artikel = new Artikel(artikelNr, art, bestand);
            System.out.println("Der artikel wurde erstellt. \nArtikel Nummer: " + artikelNr + "\nArt des artikels: " + art + "\nBestand im lager: " + bestand);

        }
    }
    
    /**
     * Aufruf Konstruktor zum initialisiern eines Artikel ohne Bestand
     * 
     * @param artikelNr gibt die Artikelnummer als vierstellige ganzzahl an
     * @param art gibt als Zeichenkette an was der Artikel ist
     */
    private void artikelOhneBestand() {
        if (artikel != null) {
            System.out.println("Der Artikel existiert schon!"); 
        } else {
            System.out.println("Eingabe der ID als Ganzzahl mit 4 Ziffern:"); 
            int artikelNr = input.nextInt();
            input.nextLine();
            System.out.println("Eingabe der Art als String:"); 
            String art = input.nextLine();
            artikel = new Artikel(artikelNr, art);
            System.out.println("Der artikel wurde erstellt. \nArtikel Nummer: " + artikelNr + "\nArt des artikels: " + art + "\n");
        }
    }

    /**
     * Buchung einer Bestandserhoehung
     * 
     * zugang gibt den zugang als ganzzahl an
     */
    private void bucheZugang() {
        if (artikel == null) {
            System.out.println("Der Artikel existiert noch nicht!"); 
        } else {
            System.out.println("Gib zugang an:"); 
            int zugang = input.nextInt();
            input.nextLine();
            artikel.bucheZugang(zugang);
        }
    }

   /**
     * Buchung einer Bestandsverminderung
     * 
     * abgang gibt den abgang als ganzzahl an
     */
    private void bucheAbgang() {
        if (artikel == null) {
            System.out.println("Der Artikel existiert noch nicht!"); 
        } else {
            System.out.println("Gib abgang an:"); 
            int abgang = input.nextInt();
            input.nextLine();
            artikel.bucheAbgang(abgang);
        }
    }
    
    /**
     * Ausgabe der Artikelattribute mit aktuellem Wert als Zeichenkette
     */
    private void tostring() {
        if (artikel == null) {
            System.out.println("Der Artikel existiert noch nicht!"); 
        } else {
            System.out.println(artikel.toString());
        }
    }

    /**
     * set Art eines Artikels
     * 
     * art gibt als Zeichenkette an was der Artikel ist
     */
    private void setArt() {
        if (artikel == null) {
            System.out.println("Der Artikel existiert noch nicht!"); 
        } else {
            System.out.println("Geben sie eine Zeichenkette an, mit der sie die 'Art' überschreiben möchten:"); 
            String art = input.nextLine();
            artikel.setArt(art);
        }
    }
    
    /**
     * set Benstand eines Artikels
     * 
     * bestand gibt den wahrenbestand als ganzzahl an
     */
    private void setBestand() {
        if (artikel == null) {
            System.out.println("Der Artikel existiert noch nicht!"); 
        } else {
            System.out.println("Geben sie eine Ganzzahl an, mit der sie den Bestand überschreiben möchten:"); 
            int bestand = input.nextInt();
            input.nextLine();
            artikel.setBestand(bestand);
        }
    }
    
    public static void main(String[] args) {
        new ArtikelDialog().start();
    }
}
