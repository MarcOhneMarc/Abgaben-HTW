import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Class to test a Queue
 */
public class QueueDialog {
    //initialize attributes
    private Person person;
    private Queue queue;
    private Scanner input;

    //initialize attributes for menu choi
    private static final int create_automat = 1;
    private static final int delete_automat = 2;
    private static final int fill_automat = 3;
    private static final int del_items_automat = 4;
    private static final int drink_bottle = 5;
    private static final int print_automat = 6;

    //Constants for error messages
    private static final String QUEUE_DOES_NOT_EXSIST = "No queue has been created!";
    private static final String WRONG_INPUT = "Wrong input!";
    
    //Constructor to initialize the scanner
    public QueueDialog() {
        input = new Scanner(System.in);
    }

    /**
     * Mainloop of the program
     */
    public void start() {
        queue = null;
        int function = 0;
        do {
            try {
                menu();
                function = readFunction();
                executeFunction(function);
            } catch(IllegalArgumentException e) {
                System.out.println(e);
            } catch(InputMismatchException e) {
                System.out.println(e);
                input.nextLine();
            } catch(Exception e) {
                System.out.println(e);
                e.printStackTrace(System.out);
            }
        } while (function != end);
    }

    /**
     * Text of the Main Menu
     */
    private void menu() {
        System.out.println("\n[1] Automat erstellen" +
                "\n[2] Automat entfernen" +
                "\n[3] Automat mit Flaschen befüllen" +
                "\n[4] Flaschen aus Automat entfernen" +
                "\n[5] Flasche Trinken" +
                "\n[6] Automat Ausgeben" +
                "\n[0] Zum beenden des Programms");

    /**
     * Read in which function should be executed
     *
     * @return function the function which should be executed
     */
    private int readFunction() {
        int function = input.nextInt();
        input.nextLine();
        return function;
    }

    /**
     * Query which function should be executed
     *
     * @param function specifies the function to be executed as an integer
     */
    private void executeFunction(int function) {
        switch (function) {
            case create_queue: createAutomat();
            break;
            case delete_automat:
                break;
            case end: System.out.println("Programm closed.");
        }
    }
    
    /**
    * Standart-Konstruktor oder Konstruktor zum initialisiern der Lagergroesse wird aufgerufen
    *
    * @return arraylaenge gibt an wie viele speicherplaetze im Array vergeben werden
    */
    private Automat createAutomat() {
        if (queue != null) {
            throw new IllegalArgumentException(QUEUE_DOES_NOT_EXSIST);
        } else {
            System.out.print("Type in how long the Queue should be:\n");
            int length = input.nextInt();
            input.nextLine();
            return new PersonQueue(length);
        }
    }
    private Automat createAutomat() {
        if (queue != null) {
            throw new IllegalArgumentException(QUEUE_DOES_NOT_EXSIST);
        } else {
            System.out.print("Type in how long the Queue should be:\n");
            int length = input.nextInt();
            input.nextLine();
            return new PersonQueue(length);
        }
    }
    }

    public static void main(String[] args) {
        new QueueDialog().start();
    }
}