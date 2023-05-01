import java.util.NoSuchElementException;

/**
 * Class for an PersonQueue
 */
public class PersonQueue implements Queue {
    //Constants for error messages
    private static final String MIN_QUEUE = "The queue needs to habe at least 1 object!";
    private static final String QUEUE_ALREADY_EMPTY = "The queue is already empty!";
    private static final String QUEUE_FULL = "The queue is full!";
    private static final String INDEX_NOT_IN_ARR = "This index is not in the Queue!";
    private static final String OBJECT_ALREADY_IN_QUEUE = "This object is already in the Queue!";
    
    //initialize attributes
    public Person[] queue;
    public Person person;
    public int peopleInQueue;
    
    /**
     * Constructor to initialize a queue with persons in it
     *
     * @param queueSize size of the queue
     */
    public PersonQueue(int queueSize) {
        if (queueSize <= 0) {
            throw new IllegalArgumentException(MIN_QUEUE);
        } else {
           queue = new Person[queueSize];
           peopleInQueue = 0;
        }
    }
    
    /**
     * Method to add a person to the queue
     */
    @Override
    public void addLast(Object o) {
        if(full() == true) {
            throw new IllegalArgumentException(QUEUE_FULL);
        }
        Person person = Person.class.cast(o);
        for (int i = 0; i < peopleInQueue; i++) {
          Person compare = queue[i];
          if (person == compare) {
            throw new IllegalArgumentException(OBJECT_ALREADY_IN_QUEUE);
          }
        }  
        queue[peopleInQueue] = person;
        peopleInQueue++;
    }
    
    /**
     * Method to remove the first person out of the queue
     */
    @Override
    public Person removeFirst() {
        if(empty() == true) {
            throw new IllegalArgumentException(QUEUE_ALREADY_EMPTY);
        }
        
        //Letze Person wird noch nicht entfernt
        Person person = queue[0];
        for (int i = 0; i < peopleInQueue -1; i++) {
          queue[i] = queue[i + 1];
        }
        queue[peopleInQueue-1] = null;
        peopleInQueue--;
        return person;
    }
    
    /**
     * Method to get a person in the queue
     */
    @Override
    public Person get(int i) {
        if(i > size()) {
            throw new IllegalArgumentException(INDEX_NOT_IN_ARR);
        }
        return queue[i];
    }
    
    /**
     * Method to check if the queue is empty
     */
    @Override
    public boolean empty() {
        if(queue[0] == null) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Method to check if the queue is full
     */
    @Override
    public boolean full() {
        if(queue[queue.length-1] == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Method to get the size of the queue
     */
    @Override
    public int size() {
        return queue.length;
    }

    /**
     * A Method to Print all Objects in Queue with the Iterator
     */
    public void print(){
     PersonIterator iter = new Iterator(); // Initialise the Iterator
     Person person; // Initialise the Person object variable
     //Iterate throw the queue and Prints the first and the last name
     while (iter.hasNext()){
         person = iter.next();
         System.out.println(person.getVorname() + " " + person.getNachname());
     }
    }

    /**
     * A Method to return the Lexical smallest name in queue with the Iterator
     * @return a sting value with the Lexical smallest name in queue
     */
    public String smallest(){
        PersonIterator iter = new Iterator(); // Initialise the Iterator
        String personName; // Initialise the Person firstname variable
        String smallestName = iter.getFirst().getVorname(); // Initialise the Person firstname variable with the first Person in queue
        //Iterate throw the queue and Compare with the compare to method the current fist name and the currently smallest name
        while (iter.hasNext()){
            personName = iter.next().getVorname();
            if (personName.compareTo(smallestName) < 0) {
                smallestName = personName;
            }
        }
        return smallestName;
    }

    /**
     * Iterator Class to iterate Objekts with the type Person
     */
    public class Iterator implements PersonIterator{
        private int index = 0; // Initialising the Index variable

        /**
         *  This method Check if an next object exist in queue
         * @return a bool that shows if an next person is in queue
         */
        @Override
        public boolean hasNext() {
            return index < peopleInQueue;
        }

        /**
         * A method for returning the next "person" in queue and iterate the index
         * @return the next "Person" in queue
         */
        @Override
        public Person next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
                return get(index++);
        }

        /**
         * a method to return the First Person in queue
         * @return the first person in queue
         */
        public Person getFirst(){
            return get(0);
        }
    }
}