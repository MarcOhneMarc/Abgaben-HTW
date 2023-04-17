import java.sql.Array;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Diese Klasse dient als Dialog fuer die erstellung von Resavierungen anhand von Mitarbeitern und Raeumen.
 * 
 * @jonas_neu_+_marc_perwak
 */
public class Dialog {
    // Instanzvariablen
    private Scanner input;

    public Uhrzeit uhrzeit;
    public Mitarbeiter mitarbeiter;
    public Reservierung reservierung;
    public Raum raum;
    
    private Raum[] rauemeListe;
    private int rauemeListeLaenge = 0;
    
    private Mitarbeiter[] mitarbeiterListe;
    private int mitarbeiterListeLaenge = 0;
    
    private static final int mitarbeiterHinzufügen = 1;
    private static final int raumHinzufügen = 2;
    private static final int raumReservieren = 3;
    private static final int mitarbeiterAusgeben = 4;
    private static final int raeumeUndResarvirerungenAusgeben = 5;
    private static final int ende = 0;
    
    private static final String KEIN_RAUM_ANGELEGT = "Es wurde noch kein Raum angelegt!";
    private static final String KEIN_MITARBEITER_ANGELEGT = "Es wurde noch kein Mitarbeiter angelegt!";
    private static final String INDEX_OUT_OF_BOUNCE = "Falscher Index!";

    /**
     * Konstruktor fuer Objekte der Klasse Dialog
     */
    public Dialog() {
        rauemeListe = new Raum[10];
        mitarbeiterListe = new Mitarbeiter[10];
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
     * Text des Hauptmenues
     */
    private void menu() {
        System.out.println("\nGib '1' ein um einen Mitarbeiter zu dem Programm hinzuzufuegen" +
                            "\nGib '2' ein um einen Raum zu dem Programm hinzuzufuegen" +
                            "\nGib '3' ein um einen Raum zu reservieren" +
                            "\nGib '4' ein um alle Mitarbeiter anzuzeigen" +
                            "\nGib '5' ein um alle Raeume mit Reservierungen anzuzeigen"+
                            "\nGib '0' ein um das Programm zu beenden");
    }
    
    /**
     * Einlesen der Funktion
     *
     * @return Auswahl wird im Menu als ganzzahliger Wert zurï¿½ckgegeben
     */
    private int einlesenFuktion() {
        int funktion = input.nextInt();
        input.nextLine();
        return funktion;
    }
    
    /**
     * Abfrage welche Funktion ausgefuehrt werden soll
     *
     * @param funktion gibt die auszufuehrende Funktion als ganze Zahl an
     */
    private void ausfuehrenFunktion(int funktion) {
        switch (funktion) {
            case raumReservieren: raumReservieren();
            break;
            case mitarbeiterHinzufügen: mitarbeiterHinzufügen();
            break;
            case raumHinzufügen: raumHinzufügen();
            break;
            case mitarbeiterAusgeben: mitarbeiterAusgeben();
            break;
            case raeumeUndResarvirerungenAusgeben: raeumeUndResarvirerungenAusgeben();
            break;
            case ende: System.out.println("Programmende!");
        }
    }

    /**
     * Hinzufuegen eines Mitarbeites zum Programm
     */
    private void mitarbeiterHinzufügen() {
        System.out.println("Vorname des Mitarbeiters:");
        String vorname = input.nextLine();
        System.out.println("Nachname des Mitarbeiters:");
        String nachname = input.nextLine();
        System.out.println("E-Mail des Mitarbeiters:");
        String email = input.nextLine();

        this.mitarbeiter = new Mitarbeiter(vorname, nachname, email);
        mitarbeiterListe[mitarbeiterListeLaenge] = mitarbeiter;
        
        System.out.println("Der Mitarbeiter " + mitarbeiterListe[mitarbeiterListeLaenge].toString() + " wurde erstellt!");
        
        mitarbeiterListeLaenge++;
    }
    
    /**
     * Hinzufuegen eines Raumes zum Programm
     */
    private void raumHinzufügen() {
        System.out.println("Nummer des Gebaeudes:");
        int geb = input.nextInt();
        System.out.println("Nummer der Etage:");
        int etage = input.nextInt();
        System.out.println("Nummer des Raumes:");
        int raumNr = input.nextInt();

        this.raum = new Raum(geb, etage, raumNr);
        rauemeListe[rauemeListeLaenge] = raum;

        System.out.println("Der Raum " + rauemeListe[rauemeListeLaenge].toString() + " wurde erstellt!");

        
        rauemeListeLaenge++;
    }
    
    /**
     * Reservieren eines Raumes
     */
    private void raumReservieren() {
        if(mitarbeiterListeLaenge <= 0)
            throw new IllegalArgumentException(KEIN_MITARBEITER_ANGELEGT);

        if(rauemeListeLaenge <= 0)
            throw new IllegalArgumentException(KEIN_RAUM_ANGELEGT);
        
        System.out.println("Auswahl des Mitarbeiter der reserviert [0-X]:");
        for (int i = 0; i < mitarbeiterListeLaenge; i++) {
            System.out.println(i + " " + mitarbeiterListe[i]);
        }
        int mitarbeiterIndex = input.nextInt();
        if (mitarbeiterIndex >= mitarbeiterListeLaenge)
            throw new IllegalArgumentException(INDEX_OUT_OF_BOUNCE);
        
        System.out.println("Auswahl des Raumes der reserviert werden soll [0-X]:");
        for (int i = 0; i < rauemeListeLaenge; i++) {
            System.out.println(i + " " + rauemeListe[i]);
        }
        int raumIndex = input.nextInt();
        if (raumIndex >= rauemeListeLaenge)
            throw new IllegalArgumentException(INDEX_OUT_OF_BOUNCE);

        
        System.out.println("Eingebe der Uhrzeit, ab der Reserviert werden soll:");
        System.out.println("Stundenzeiger (0 - 23 Uhr):");
        int uhrAnfStd = input.nextInt();
        System.out.println("Minutenzeiger (0 - 59 Minuten):");
        int uhrAnfMin = input.nextInt();
        System.out.println("Eingebe der Uhrzeit, ab der die Reservierung beendet werden soll:");
        System.out.println("Stundenzeiger (0 - 23 Uhr):");
        int uhrEndStd = input.nextInt();
        System.out.println("Minutenzeiger (0 - 59 Minuten):");
        int uhrEndMin = input.nextInt();
        input.nextLine();
        System.out.println("Fuegen sie eine Bemerkung hinzu:");
        String bemerkung = input.nextLine();

        mitarbeiterListe[mitarbeiterIndex].reserviere(rauemeListe[raumIndex], new Uhrzeit(uhrAnfStd, uhrAnfMin), new Uhrzeit(uhrEndStd, uhrEndMin), bemerkung);
        System.out.println(raum);
    }
    
    /**
     * Ausgeben aller Mitarbeiter
     */
    private void mitarbeiterAusgeben() {
        if(mitarbeiterListeLaenge <= 0)
            throw new IllegalArgumentException(KEIN_MITARBEITER_ANGELEGT);
        for (int i = 0; i < mitarbeiterListeLaenge; i++) {
            System.out.println(mitarbeiterListe[i]);
        }
    }
    
    /**
     * Ausgeben aller Raeume und Reservierungen
     */
    private void raeumeUndResarvirerungenAusgeben() {
        if(rauemeListeLaenge <= 0)
            throw new IllegalArgumentException(KEIN_RAUM_ANGELEGT);
        for (int i = 0; i < rauemeListeLaenge; i++) {
            System.out.println(rauemeListe[i]);
        }
    }
    
    public static void main(String[] args){
        new Dialog().start();
    }
}
