

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueTest {
    private static final double EPSILON = 1.0E-8;
    private Queue queue;
    private Person person;
    private PersonQueue personQueue;


    @BeforeEach
    public void setup() {
        this.personQueue = new PersonQueue(20);
        this.person = new Person("Alsaid","Mohmaned");
        this.personQueue.addLast(person);
        this.person = new Person("Marc","Perwak");
        this.personQueue.addLast(person);
        this.person = new Person("Jonas","Neu");
        this.personQueue.addLast(person);
        this.person = new Person("Aeneas","Kremer");
        this.personQueue.addLast(person);
    }

    @Test
    public void testCreatePersonQueue_with_Correct_size() {
        personQueue = new PersonQueue(10);
        int queueSize = personQueue.size();
        int expectetSize = 10;
        Assertions.assertEquals(expectetSize,queueSize);

    }
    @Test
    public void testCreatePersonQueue_with_size_Null() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            personQueue = new PersonQueue(0);;
        });
    }
    @Test
    public void testCreatePersonQueue_with_size_negative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            personQueue = new PersonQueue(-10);;
        });
    }
    @Test
    public void testQueueAddLast_Correct() {
        Person person1 = new Person("Emalda", "Showman");
        personQueue.addLast(person1);
        int indexOfLast = personQueue.peopleInQueue -1;
        Person person2 = personQueue.get(indexOfLast);
        Assertions.assertEquals(person1,person2);
    }
    @Test
    public void testQueueRemoveFirst_Correct() {
        Person firstPersonBefore = personQueue.get(0);
        personQueue.removeFirst();
        Person firstPersonAfter = personQueue.get(0);
        Assertions.assertNotEquals(firstPersonBefore,firstPersonAfter);
    }

    @Test
    public void testQueueGetPerson_Correct() {
        Person personToGet = new Person("Emalda", "Showman");
        personQueue.addLast(personToGet);
        Person getPerson = personQueue.get(4);
        Assertions.assertEquals(personToGet,getPerson);
    }

    @Test
    public void testPersonQueue_notFull_Correct() {
        personQueue = new PersonQueue(2);
        this.person = new Person("Alsaid","Mohmaned");
        this.personQueue.addLast(person);
        boolean fullness = personQueue.full();
        boolean expectetBool = false;
        Assertions.assertEquals(expectetBool,fullness);
    }
    @Test
    public void testPersonQueue_isFull_Correct() {
        personQueue = new PersonQueue(1);
        this.person = new Person("Alsaid","Mohmaned");
        this.personQueue.addLast(person);
        boolean fullness = personQueue.full();
        boolean expectetBool = true;
        Assertions.assertEquals(expectetBool,fullness);
    }
    @Test
    public void testPersonQueue_notEmpty_Correct() {
        personQueue = new PersonQueue(2);
        this.person = new Person("Alsaid","Mohmaned");
        this.personQueue.addLast(person);
        boolean fullness = personQueue.empty();
        boolean expectetBool = false;
        Assertions.assertEquals(expectetBool,fullness);
    }
    @Test
    public void testPersonQueue_isEmpty_Correct() {
        personQueue = new PersonQueue(2);
        boolean fullness = personQueue.empty();
        boolean expectetBool = true;
        Assertions.assertEquals(expectetBool,fullness);
    }
    @Test
    public void testQueueSize_Correct() {
        int expectetSize = 20;
        int actuelSize = personQueue.size();
        Assertions.assertEquals(expectetSize,actuelSize);
    }
}
