/**
 * Class for an PersonQueue
 */
public class PersonQueue implements Queue {
    //Constants for error messages
    private static final String MIN_QUEUE = "The queue needs to habe at least 1 object!";
    private static final String QUEUE_ALREADY_EMPTY = "The queue is already empty!";
    
    //initialize attributes
    public Person[] queue;
    public Person person;
    
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
        }
    }
    
    @Override
    public void addLast(Object o) {
        Person person = Person.class.cast(o);
        queue[0] = person;
        System.out.println("ADD PERSON " + o);
    }
    
    @Override
    public Person removeFirst() {
        if(queue[0] == null) {
            throw new IllegalArgumentException(QUEUE_ALREADY_EMPTY);
        }
        Person person = queue[0];
        queue[0] = null;
        return person;
    }
    
    @Override
    public Person get(int i) {
        System.out.println("SCH"+queue[i].getVorname()+" "+queue[i].getNachname());
        return queue[i];
    }
    
    @Override
    public boolean empty() {
        if(queue[0] == null) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean full() {
        if(queue[queue.length-1] == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int size() {
        return queue.length;
    }
}