import java.sql.Array;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Beschreiben Sie hier die Klasse Dialog.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Dialog
{
    // Instanzvariablen
    private Scanner input;

    public Uhrzeit uhrzeit;
    public Mitarbeiter mitarbeiter;
    public Reservierung reservierung;
    public Raum raum;
    private Raum[] raumAr;
    private int raumArLaenge = 0;
    private Mitarbeiter[] mitAr;
    private int mitArLaenge = 0;
    private static final int mitarbeiter_anlegen = 1;
    private static final int raum_anlegen = 2;
    private static final int reservierung_Erstellen = 3;
    private static final int alle_mitarbeiter = 4;
    private static final int alle_raume = 5;
    private static final int zeige_resarvirerungen = 6;
    private static final int ende = 0;

    /**
     * Konstruktor fuer Objekte der Klasse Dialog
     */
    public Dialog()
    {
        raumAr = new Raum[10];
        mitAr = new Mitarbeiter[10];
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
        System.out.println("\nGib '1' ein zum anlegen eines Mitarbeiters " +
                            "\nGib '2' ein zum Hinzufuegen eines Raumes" +
                            "\nGib '3' ein zum Resarvieren eines Raumes" +
                            "\nGib '4' ein zum Anzeigen aller Mitarbeiter" +
                            "\nGib '5' ein zum Anzeigen aller Raume");
    }
    
    /**
     * Einlesen der Funktion
     *
     * @return Auswahl wird im Menu als ganzzahliger Wert zur�ckgegeben
     */
    private int einlesenFuktion() {
        int funktion = input.nextInt();
        input.nextLine();
        return funktion;
    }
    
    /**
     * Abfrage welche Funktion ausgef�hrt werden soll
     *
     * @param funktion gibt die auszufuehrende Funktion als ganze Zahl an
     */
    private void ausfuehrenFunktion(int funktion) {
        switch (funktion) {
            case reservierung_Erstellen: reservierungErstellen();
            break;
            case mitarbeiter_anlegen: mitarbeiter_anlegen();
            break;
            case raum_anlegen: raum_anlegen();
            break;
            case alle_mitarbeiter: alleMitarbeiter();
            break;
            case alle_raume: alleRaume();
            break;
            case zeige_resarvirerungen: zeigeResarvirerungen();
            break;
            case ende: System.out.println("Programmende!");
        }
    }

    private void mitarbeiter_anlegen() {
        System.out.println("Geben sie bitte den Vornamen des Mitarbeites an");
        String vorname = this.input.nextLine();
        System.out.println("Geben sie bitte den Nachnamen des Mitarbeites an");
        String nachname = this.input.nextLine();
        System.out.println("Geben sie bitte die Email Adresse des Mitarbeites an");
        String email = this.input.nextLine();

        if (vorname == null || vorname.strip().isEmpty())
            throw new IllegalArgumentException("Der Vorname darf nicht leer sein");
        if (nachname == null || nachname.strip().isEmpty())
            throw new IllegalArgumentException("Der Nachname darf nicht leer sein");
        if (email == null || email.strip().isEmpty())
            throw new IllegalArgumentException("Die Email darf nicht leer sein");

        this.mitarbeiter = new Mitarbeiter(vorname, nachname,email);
        mitAr[mitArLaenge] = mitarbeiter;
        mitArLaenge++;

        System.out.println(mitAr.toString());
        System.out.println(mitAr[mitArLaenge -1].toString());
    }
    private void raum_anlegen() {
        System.out.println("Geben sie bitte das gebeude an");
        int geb = this.input.nextInt();
        System.out.println("Geben sie bitte deie Etage an");
        int etage = this.input.nextInt();
        System.out.println("Geben sie bitte den Raum an");
        int raumNr = this.input.nextInt();

        if (geb <= 0)
            throw new IllegalArgumentException("Das geb darf nicht leer sein");
        if (etage <= 0)
            throw new IllegalArgumentException("Die Etage darf nicht leer sein");
        if (raumNr <= 0)
            throw new IllegalArgumentException("Der Raum darf nicht leer sein");

        this.raum = new Raum(geb, etage, raumNr);
        raumAr[raumArLaenge] = raum;
        raumArLaenge++;

        System.out.println(raumAr.toString());
        System.out.println(raumAr[raumArLaenge -1].toString());

        System.out.println(raum);
    }
    private void reservierungErstellen() {
        System.out.println("Wählen sie einen Mitarbeiter aus");
        for (int i = 0; i < mitArLaenge; i++){
            System.out.println(i + " " + mitAr[i]);
        }
        int mitarbeiterIndex = input.nextInt();
        System.out.println("Wählen sie einen Raum aus");
        for (int i = 0; i < raumArLaenge; i++){
            System.out.println(i + " " + raumAr[i]);
        }
        int raumIndex = input.nextInt();

        System.out.println("Geben sie bitte die Anfangs Stunde ein");
        int uhrAnfStd = input.nextInt();
        System.out.println("Geben sie bitte die Anfangs Minuten ein");
        int uhrAnfMin = input.nextInt();
        System.out.println("Geben sie bitte die End Stunde ein");
        int uhrEndStd = input.nextInt();
        System.out.println("Geben sie bitte die End Minuten ein");
        int uhrEndMin = input.nextInt();
        System.out.println("Geben sie bitte die Bemerkung an");
        String bemerkung = this.input.nextLine();
        input.nextLine();

        mitAr[mitarbeiterIndex].reserviere(raumAr[raumIndex], new Uhrzeit(uhrAnfStd, uhrAnfMin), new Uhrzeit(uhrEndStd, uhrEndMin), bemerkung);
        System.out.println(raum);
    }
    private void alleMitarbeiter(){
        for (int i = 0; i < mitArLaenge; i++){
            System.out.println(i + " " + mitAr[i]);
        }
    }
    private void alleRaume(){
        for (int i = 0; i < raumArLaenge; i++){
            System.out.println(i + " " + raumAr[i]);
        }
    }
    private void zeigeResarvirerungen(){
        System.out.println("Zu welchen raum wollen sie die Resarvierungen sehen");
        for (int i = 0; i < raumArLaenge; i++){
            System.out.println(i + " " + raumAr[i]);
        }
        int raumIndex = input.nextInt();
        input.nextLine();
        System.out.println(raumAr[raumIndex]);
    }

    public static void main(String[] args){
        new Dialog().start();
    }

}
