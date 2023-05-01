/**
 * Beschreiben Sie hier die Klasse Test.
 */
public class Test {
    public Person person;
    public Queue queue;
    
    public static void main(String[] args) {
        /*
        System.out.println("STRING QUEUE______________________");        
        String eins = "1-------1";
        String zwei = "2-------2";
        String drei = "3-------2";
        
        Queue queue = new StringQueue(10);
        
        queue.addLast(eins);
        queue.addLast(zwei);
        queue.addLast(drei);
        
        System.out.println("Queue: ");
        for(int i = 0; i < queue.size(); i++) {
            System.out.println(queue.get(i));
        }
        */            
        Person eins = new Person("Jonas", "Neu");
        Person zwei = new Person("Aeneas", "Kremer");
        Person drei = new Person("Marc", "Perwak");
        
        Queue queue = new PersonQueue(5);
        
        queue.addLast(eins);
        queue.addLast(zwei);
        queue.addLast(drei);

        queue.getAllIter();
        
        /*System.out.println("\nQueue: ");
        for(int i = 0; i < queue.size(); i++) {
            Person person = (Person)(queue.get(i));
            if(person != null) {
                System.out.println(person.getVorname() + " " + person.getNachname());
            } else {
                System.out.println("NULL");
            }
        }
        
        queue.removeFirst();
        System.out.println("\nQueue: ");
        for(int i = 0; i < queue.size(); i++) {
            Person person = (Person)(queue.get(i));
            if(person != null) {
                System.out.println(person.getVorname() + " " + person.getNachname());
            } else {
                System.out.println("empty");
            }
        } */
        
    }
}
