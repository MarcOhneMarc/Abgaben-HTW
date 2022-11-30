import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Programm zum Berechnen verschiedener Mathematischer Funktionen.
 * 
 * @Jonas Neu & Marc Perwark
 */
public class åMathFunctions_Dialog {
    //initialisierung der Attribute
    public MathFunctions mathfunctions;
    private Scanner input;
    
    private static final int berechneTeilersumme = 1;
    private static final int berechneChecksummeIsbn = 2;
    private static final int berechneNullstellen = 3;
    private static final int istSummeVonPotenzen = 4;
    private static final int berechneGgt = 5;
    private static final int berechneFakultaet = 6;
    private static final int berechneReihensumme = 7;
    private static final int ende = 0;
    
    //Konstruktor zum initialisiern des Scanners
    public MathFunctions_Dialog() {
        input = new Scanner(System.in);
    }

    /**
     * Hauptschleife des Dialogprogramms.
     */
    public void start() {
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
     * Gibt das Hauptmenue aus 
     */
    private void menu() {
        System.out.println("Press '1' zum berechnen der Teilersumme einer Zahl.");
        System.out.println("Press '2' zum berechnen der Checksumme einer 10-Stelligen ISBN-Nummer.");
        System.out.println("Press '3' zum berechnen von Nullstellen einer quadratischen Gleichung.");
        System.out.println("Press '4' zum berechnen der Summe von Potenzen.");
        System.out.println("Press '5' zum berechnen des größten gemeinsamen Teilers von zwei Zahlen.");
        System.out.println("Press '6' zum berechnen der Fakultät einer Zahl.");
        System.out.println("Press '7' zum berechnen eine Reihensumme.");
        System.out.println("Press '0' zum beenden des Programms");
    }

    /**
     * Einlesen der Funktion 
     * 
     * @return Auswahl im Menu wird als ganzzahliger Wert zurückgegeben
     */
    private int einlesenFuktion() {
        int funktion = input.nextInt();
        input.nextLine();
        return funktion;
    }
    
    /**
     * Abfrage welche Funktion ausgeführt werden soll
     * 
     * @param die auszufuehrende Funktion als ganze Zahl
     */
    private void ausfuehrenFunktion(int funktion) {
        if (funktion == berechneTeilersumme) {
            berechneTeilersumme();
        } else if (funktion == berechneChecksummeIsbn) {
            berechneChecksummeIsbn();
        } else if (funktion == berechneNullstellen) {
            berechneNullstellen();
        } else if (funktion == istSummeVonPotenzen) {
            istSummeVonPotenzen();
        } else if (funktion == berechneGgt) {
            berechneGgt();
        } else if (funktion == berechneFakultaet) {
            berechneFakultaet();
        } else if (funktion == berechneReihensumme) {
            berechneReihensumme();
        } else if (funktion == ende) {
            System.out.println("Programmende!");
        } else {
            System.out.println("Falsche Eingabe!");  
        }
    }
    
    /**
    * Aufruf der Methode zum berechnen der Teilersumme einer Zahl.
     */
    private void berechneTeilersumme() {
        System.out.println("Eingabe der Zahl:"); 
        long zahl = input.nextInt();
        input.nextLine();
        
        System.out.println(mathfunctions.berechneTeilersumme(zahl));
    }
    
    /**
    * Aufruf der Methode zum berechnen der Checksumme einer 10-Stelligen ISBN-Nummer.
     */
    private void berechneChecksummeIsbn() {
        System.out.println("Eingabe der ISBN:"); 
        long isbn = input.nextInt();
        input.nextLine();
        
        System.out.println(mathfunctions.berechneChecksummeIsbn(isbn));
    }
    
    /**
    * Aufruf der Methode zur Berechnung von Nullstellen mit der PQ Formel.
     */
    private void berechneNullstellen() {
        System.out.println("Eingabe der von P:"); 
        double p = input.nextDouble();

        
        System.out.println("Eingabe der von Q:"); 
        double q = input.nextDouble();


        System.out.println(mathfunctions.berechneNullstellen(p, q));
    }

    /**
     * Dient der pruefung, ob man die uebergebene Zahl als a hoch 4, b hoch 3 und c hoch 2 darstellen kann
     */
    private void istSummeVonPotenzen() {
        System.out.println("Eingabe der Zahl:"); 
        long zahl = input.nextLong();
        input.nextLine();
            
        System.out.println(mathfunctions.istSummeVonPotenzen(zahl));
    }
    
    /**
     *
     * Methode berechneGgt dient der berechnung des groessten gemeinsamen teilers zweier Natuerlicher ganzzahliger Zahlen
     */
    private void berechneGgt() {
        System.out.println("Eingabe der von Zahl1:"); 
        int zahl1 = input.nextInt();
        input.nextLine();
        
        System.out.println("Eingabe der von Zahl2:"); 
        int zahl2 = input.nextInt();
        input.nextLine();
        
        System.out.println(mathfunctions.berechneGgt(zahl1, zahl2));
    }

    /**
     * Methode zur berechnung der Fakultaet einer Zahl
     */
    private void berechneFakultaet() {
        System.out.println("Eingabe der Zahl:"); 
        int zahl = input.nextInt();
        input.nextLine();
        
        System.out.println(mathfunctions.berechneFakultaet(zahl));
    }

    /**
     * Methode zur berechnung einer Reihensumme
     */
    private void berechneReihensumme() {
        System.out.println("Eingabe der Anzahl:"); 
        int anzahl = input.nextInt();
        input.nextLine();
        
        System.out.println("Eingabe von x:"); 
        double x = input.nextDouble();
        input.nextLine();
        
        System.out.println(mathfunctions.berechneReihensumme(anzahl, x));
    }

    public static void main(String[] args) {
        new MathFunctions_Dialog().start();
    }
}