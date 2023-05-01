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
    private static final int create_queue = 1;
    private static final int add_last = 2;
    private static final int remove_first = 3;
    private static final int get = 4;
    private static final int empty = 5;
    private static final int full = 6;
    private static final int size = 7;
    private static final int print = 8;
    private static final int smallest = 9;
    private static final int end = 0;
    
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
        System.out.println("\n[1] create the queue.");
        System.out.println("[2] add an obj to the end of the queue.");
        System.out.println("[3] remove the first obj of the queue.");
        System.out.println("[4] get an obj of the queue.");
        System.out.println("[5] check if the queue is empty.");
        System.out.println("[6] check if the queue is full.");
        System.out.println("[7] get the size of the queue.");
        System.out.println("[8] print queue.");
        System.out.println("[9] Get the Lexicalic Smallest name in queue");
        System.out.println("[0] end program.");
    }

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
            case create_queue: queue = createQueue();
            break;
            case add_last: addLast();
            break;
            case remove_first: removeFirst();
            break;
            case get: get();
            break;
            case empty: empty();
            break;
            case full: full();
            break;
            case size: size();
            break;
            case print: print();
            break;
            case smallest: smallest();
            break;
            case end: System.out.println("Programm closed.");
        }
    }
    
    /**
    * Standart-Konstruktor oder Konstruktor zum initialisiern der Lagergroesse wird aufgerufen
    *
    * @return arraylaenge gibt an wie viele speicherplaetze im Array vergeben werden
    */
    private Queue createQueue() {
        if (queue != null) {
            throw new IllegalArgumentException(QUEUE_DOES_NOT_EXSIST);
        } else {
            System.out.print("Type in how long the Queue should be:\n");
            int length = input.nextInt();
            input.nextLine();
            return new PersonQueue(length);
        }
    }
    
    /**
     * Adds a object to the end of the queue
     */
    private void addLast() {
        if (queue == null) {
            throw new IllegalArgumentException(QUEUE_DOES_NOT_EXSIST);
        } else {
            if(queue instanceof PersonQueue) {
                System.out.println("Type in the lastname of the Person you want to add to the queue:\n");
                String lastname = input.nextLine();
                System.out.println("Type in the firstname of the Person you want to add to the queue:\n");
                String firstname = input.nextLine();
                Person person = new Person(firstname, lastname);
                queue.addLast(person);
            }
        }
    }
    
    /**
     * Deletes the first object in Queue
     */
    private void removeFirst() {
        if (queue == null) {
            throw new IllegalArgumentException(QUEUE_DOES_NOT_EXSIST);
        } else {
            if(queue instanceof PersonQueue) {
                queue.removeFirst();
            }
        }
    }

    /**
     * Get the object in queue on position 'i'
     */
    private void get() {
        if (queue == null) {
            throw new IllegalArgumentException(QUEUE_DOES_NOT_EXSIST);
        } else {
            System.out.println("Type in the place in the queue you want to get: ");
            int i = input.nextInt();
            System.out.println(queue.get(i));
        }
    }
    
    /**
     * Tests if queue is empty
     */
    private void empty(){
        if (queue == null) {
            throw new IllegalArgumentException(QUEUE_DOES_NOT_EXSIST);
        } else {
            if (queue.empty() == true) {
                System.out.println("Queue is empty");
            } else {
                System.out.println("Queue is not empty");
            }
        }
    }
    
    /**
     * Tests if queue is full
     */
    private void full(){
        if (queue == null) {
            throw new IllegalArgumentException(QUEUE_DOES_NOT_EXSIST);
        } else {
            if (queue.full() == true) {
                System.out.println("Queue is full");
            } else {
                System.out.println("Queue is not full");
            }
        }
    }

    /**
     * Return of queue size
     */
    private void size(){
        if (queue == null) {
            throw new IllegalArgumentException(QUEUE_DOES_NOT_EXSIST);
        } else {
            System.out.println("The size of the Queue is: " + queue.size());
        }
    }
    
    /**
     * Print the queue
     */
    private void print() {
        if (queue == null)
            throw new IllegalArgumentException(QUEUE_DOES_NOT_EXSIST);
        queue.print();
    }
    /**
     * Prints the name of the Lexical smallest name
     */
    private void smallest() {
        if (queue == null)
            throw new IllegalArgumentException(QUEUE_DOES_NOT_EXSIST);
        System.out.println(queue.smallest());
    }
    /**
     * external print for PersonQueue
     */
    private void printPerson() {
        for(int i = 0; i < queue.size(); i++) {
            Person person = (Person)(queue.get(i));
            if(person != null) {
                System.out.println("Firstname: "+person.getVorname() + " Lastname: " + person.getNachname());
            } else {
                System.out.println("empty");
            }
        }
    }
    /**
     * external print for StringQueue
     */
    private void printString() {
        for(int i = 0; i < queue.size(); i++) {
            String string = (String)(queue.get(i));
            if(string != null) {
                System.out.println("String: "+string);
            } else {
                System.out.println("empty");
            }
        }
    }
    
    public static void main(String[] args) {
        new QueueDialog().start();
    }
}