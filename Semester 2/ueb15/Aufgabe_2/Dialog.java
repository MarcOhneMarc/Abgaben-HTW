import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

/**
 * Dialog fuer die Programme NumberCruncherTopLevel und NumberCruncherAnonym
 * 
 * @jonas_neu_+_marc_perwak
 */
public class Dialog {
    // Instanzvariablen
    private Scanner input;

    public NumberCruncherTopLevel numberCruncherTopLevel;
    public NumberCruncherAnonym numberCruncherAnonym;
    private boolean cruncherInitialisiert;
    private boolean isTopLevel;
    public float[] array;
    
    private static final int erstellenAnonymOderTopLevel = 1;
    private static final int ausfuehrenOperationen = 2;
    private static final int arrayAusgeben = 3;
    private static final int ende = 0;
    
    private static final String ARRAY_MIN_SIZE = "Das Array muss mindestens 2 Werte erhalten!";
    private static final String KEIN_CRUNCHER_INITIALISIERT = "Es wurde noch kein Cruncher Initialisiert!";
    private static final String INDEX_OUT_OF_BOUNCE = "Falscher Index!";

    /**
     * Konstruktor fuer Objekte der Klasse Dialog
     */
    public Dialog() {
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
        System.out.println("\nTippe '1' um den Numbercrusher Anonym oder als TopLevel Programm zu starten" +
                            "\nTippe '2' um die Operationen auszuwaehlen, die auf das array angewendet werden" +
                            "\nTippe '3' um das Array auszugeben" +
                            "\nTippe '0' um das Programm zu beenden");
    }
    
    /**
     * Einlesen der Funktion
     *
     * @return Auswahl wird im Menu als ganzzahliger Wert zurueckgegeben
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
            case erstellenAnonymOderTopLevel: erstellenAnonymOderTopLevel();
            break;
            case ausfuehrenOperationen: ausfuehrenOperationen();
            break;
            case arrayAusgeben: arrayAusgeben();
            break;
            case ende: System.out.println("Programmende!");
        }
    }
    
    /**
     * Auswahl ob ein Anonymer oder ein TopLevel NumberCruncher erstellt werden soll
     * + uebergabe des float arrays
     */
    private void erstellenAnonymOderTopLevel() {
        System.out.println("\n '1' NumberCruncherTopLevel" + 
                            "\n '2' NumberCruncherAnonym");
        int auswahl = input.nextInt();
        if (auswahl == 1) {
            array = arrayUebergeben();
            numberCruncherTopLevel = new NumberCruncherTopLevel(array);
            float[] numbers = numberCruncherTopLevel.getNumbers();
            cruncherInitialisiert = true;
            isTopLevel = true;
        } else if (auswahl == 2) {
            array = arrayUebergeben();
            numberCruncherAnonym = new NumberCruncherAnonym(array);
            numberCruncherAnonym.getNumbers();
            float[] numbers = numberCruncherAnonym.getNumbers();
            cruncherInitialisiert = true;
            isTopLevel = false;
        } else {
            throw new IllegalArgumentException(INDEX_OUT_OF_BOUNCE);
        }
        
    }
    
    /**
     * Hilfsmethode zum uebergeben des Float arrays als eigene Eingabe
     * oder mit einem Array mit Random werten
     */
    private float[] arrayUebergeben() {
        System.out.println("\n '1' Array manuell eingeben" + 
                            "\n '2' Array zufaellig generieren lassen");
        int auswahl = input.nextInt();
        if (auswahl == 1) {
            System.out.println("\nGeben sie die Laenge an welche das Array haben soll:");
            int laenge = input.nextInt();
            if (laenge < 2)
                throw new IllegalArgumentException(ARRAY_MIN_SIZE);
            array = new float[laenge];
            for (int i = 0; i < array.length; i++) {
                System.out.println(i + ". Wert");
                array[i] = input.nextFloat();
            }
        } else if (auswahl == 2) {
            System.out.println("\nGeben sie die Laenge an welche das Array haben soll:");
            int laenge = input.nextInt();
            if (laenge < 2)
                throw new IllegalArgumentException(ARRAY_MIN_SIZE);
            array = new float[laenge];
            for (int i = 0; i < array.length; i++) {
                Random rand = new Random();
                array[i] = rand.nextFloat(999);
            }
        } else {
            throw new IllegalArgumentException(INDEX_OUT_OF_BOUNCE);
        }
        return array;
    }
    
    /**
     * Auswahl, welche Operation auf das Float Array angewendet werden soll.
     */
    private void ausfuehrenOperationen() {
        if (!cruncherInitialisiert)
            throw new IllegalArgumentException(KEIN_CRUNCHER_INITIALISIERT);
        System.out.println("\nWie viele Operationen möchten sie ausfuehren:");
        int laenge = input.nextInt();
        input.nextLine();
        String[] operationen = new String[laenge];
        System.out.println("\nMoegliche Operationen:" + 
                            "\n'sum'" + 
                            "\n'swirl'" + 
                            "\n'divide'" + 
                            "\n'subtract'" + 
                            "\n'average'" );
        for (int i = 0; i < operationen.length; i++) {
            System.out.println("\nGeben sie eine der Operationen von oben an:");
            String operation = input.nextLine();
            operationen[i] = operation;
        }
        for (String operation: operationen) {
            System.out.println(operation);
        }
        if (isTopLevel) {
            numberCruncherTopLevel.crunch(operationen);
        } else {
            numberCruncherAnonym.crunch(operationen);
        }
    }
    
    /**
     * Ausgabe des Arrays, mithilfe der getNumbers Methode
     */
    private void arrayAusgeben() {
        if (!cruncherInitialisiert)
            throw new IllegalArgumentException(KEIN_CRUNCHER_INITIALISIERT);
        if (isTopLevel) {
            float[] printArray = numberCruncherTopLevel.getNumbers();
            arrayPrinter(printArray);
        } else {
            float[] printArray = numberCruncherAnonym.getNumbers();
            arrayPrinter(printArray);
        }
    }
    
    /**
     * Hilfsmethode zum ausgeben eines Arrays
     */
    private void arrayPrinter(float[] printArray) {
        for (float wert: printArray) {
            System.out.println(wert);
        }
    }
    
    public static void main(String[] args){
        new Dialog().start();
    }
}
