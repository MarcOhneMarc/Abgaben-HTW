/**
 * Beschreiben Sie hier die Klasse Test.
 */
public class Test {
    public Person person;
    public Queue queue;
    
    public static void main(String[] args) {
        Person person1 = new Person("Neu", "Jonas");
        Person person2 = new Person("Huen", "John");
        
        Queue queue = new PersonQueue(3);
        
        queue.addLast(person1);
        
        System.out.println("Queue (1ADDED): ");
        System.out.println(queue.get(0));
        System.out.println(queue.get(1));
        System.out.println(queue.get(2));
        
        queue.removeFirst();
        System.out.println("Queue (REMOVED FIRST): ");
        System.out.println(queue.get(0));
        System.out.println(queue.get(1));
        System.out.println(queue.get(2));
    }
}
