/**
 * Class for an StringQueue
 */
public class StringQueue implements Queue {
    //Constants for error messages
    private static final String MIN_QUEUE = "The queue needs to habe at least 1 object!";
    
    //initialize attributes
    public String[] queue;
    
    /**
     * Constructor to initialize a queue with strings in it
     *
     * @param queueSize size of the queue
     */
    public StringQueue(int queueSize) {
        if (queueSize <= 0) {
            throw new IllegalArgumentException(MIN_QUEUE);
        } else {
           queue = new String[queueSize];
        }
    }
    
    @Override
    public void addLast(Object o) {
        System.out.println("ADD String " + o);
    }
    
    @Override
    public String removeFirst() {
        return queue[0];
    }
    
    @Override
    public String get(int i) {
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