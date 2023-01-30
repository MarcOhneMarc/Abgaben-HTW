import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueTest {
    private static final double EPSILON = 1.0E-8;
    private Queue queue;
    private Queue queue2;
    private Person person;
    private String string;

    @BeforeEach
    public void setup() {
        this.queue = new PersonQueue(20);
        this.queue2 = new StringQueue(20);
        this.person = new Person("Alsaid","Mohmaned");
        this.queue.addLast(person);
        this.queue2.addLast("ha");
        this.person = new Person("Marc","Perwak");
        this.queue.addLast(person);
        this.queue2.addLast("ka");
        this.person = new Person("Jonas","Neu");
        this.queue.addLast(person);
        this.queue2.addLast("ba");
        this.person = new Person("Aeneas","Kremer");
        this.queue.addLast(person);
        this.queue2.addLast("aa");
    }

    @Test
    public void testCreatequeue_with_Correct_size() {
        queue = new PersonQueue(10);
        int queueSize = queue.size();
        int expectetSize = 10;
        Assertions.assertEquals(expectetSize,queueSize);

    }
    @Test
    public void testCreatequeue_with_size_Null() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            queue = new PersonQueue(0);;
        });
    }
    @Test
    public void testCreatequeue_with_size_negative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            queue = new PersonQueue(-10);;
        });
    }
    @Test
    public void testCreateSqueue_with_Correct_size() {
        queue2 = new StringQueue(10);
        int queueSize = queue2.size();
        int expectetSize = 10;
        Assertions.assertEquals(expectetSize,queueSize);

    }
    @Test
    public void testCreateSqueue_with_size_Null() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            queue2 = new StringQueue(0);;
        });
    }
    @Test
    public void testCreateSqueue_with_size_negative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            queue2 = new StringQueue(-10);;
        });
    }
    @Test
    public void testQueueAddLast_Correct() {
        Person person1 = new Person("Emalda", "Showman");
        queue.addLast(person1);
        int indexOfLast = 4;
        Person person2 = (Person)(queue.get(indexOfLast));
        Assertions.assertEquals(person1,person2);
    }
    @Test
    public void testSQueueAddLast_Correct() {
        String string1 = new String("Emalda");
        queue2.addLast(string1);
        int indexOfLast = 4;
        String string2 = (String) (queue2.get(indexOfLast));
        Assertions.assertEquals(string1,string2);
    }
    @Test
    public void testQueueRemoveFirst_Correct() {
        Person firstPersonBefore = (Person)(queue.get(0));
        queue.removeFirst();
        Person firstPersonAfter = (Person)(queue.get(0));
        Assertions.assertNotEquals(firstPersonBefore,firstPersonAfter);
    }
    @Test
    public void testSQueueRemoveFirst_Correct() {
        String firstStringBefore = (String) (queue2.get(0));
        queue2.removeFirst();
        String firstStringAfter = (String) (queue2.get(0));
        Assertions.assertNotEquals(firstStringBefore,firstStringAfter);
    }

    @Test
    public void testQueueGetPerson_Correct() {
        Person personToGet = new Person("Emalda", "Showman");
        queue.addLast(personToGet);
        Person getPerson = (Person)(queue.get(4));
        Assertions.assertEquals(personToGet,getPerson);
    }
    @Test
    public void testSQueueGetPerson_Correct() {
        String stringToGet = new String("Emalda");
        queue2.addLast(stringToGet);
        String getString = (String) (queue2.get(4));
        Assertions.assertEquals(stringToGet,getString);
    }
    @Test
    public void testqueue_notFull_Correct() {
        queue = new PersonQueue(2);
        this.person = new Person("Alsaid","Mohmaned");
        this.queue.addLast(person);
        boolean fullness = queue.full();
        boolean expectetBool = false;
        Assertions.assertEquals(expectetBool,fullness);
    }
    @Test
    public void testSqueue_notFull_Correct() {
        queue2 = new StringQueue(2);
        this.string = new String("Alsaid");
        this.queue2.addLast(string);
        boolean fullness = queue2.full();
        boolean expectetBool = false;
        Assertions.assertEquals(expectetBool,fullness);
    }
    @Test
    public void testqueue_isFull_Correct() {
        queue = new PersonQueue(1);
        this.person = new Person("Alsaid","Mohmaned");
        this.queue.addLast(person);
        boolean fullness = queue.full();
        boolean expectetBool = true;
        Assertions.assertEquals(expectetBool,fullness);
    }
    @Test
    public void testSqueue_isFull_Correct() {
        queue2 = new StringQueue(1);
        this.string = new String("Alsaid");
        this.queue2.addLast(string);
        boolean fullness = queue2.full();
        boolean expectetBool = true;
        Assertions.assertEquals(expectetBool,fullness);
    }
    @Test
    public void testqueue_notEmpty_Correct() {
        queue = new PersonQueue(2);
        this.person = new Person("Alsaid","Mohmaned");
        this.queue.addLast(person);
        boolean fullness = queue.empty();
        boolean expectetBool = false;
        Assertions.assertEquals(expectetBool,fullness);
    }
    @Test
    public void testSqueue_notEmpty_Correct() {
        queue2 = new StringQueue(2);
        this.string = new String("Alsaid");
        this.queue2.addLast(string);
        boolean fullness = queue2.empty();
        boolean expectetBool = false;
        Assertions.assertEquals(expectetBool,fullness);
    }
    @Test
    public void testqueue_isEmpty_Correct() {
        queue = new PersonQueue(2);
        boolean fullness = queue.empty();
        boolean expectetBool = true;
        Assertions.assertEquals(expectetBool,fullness);
    }
    @Test
    public void testSqueue_isEmpty_Correct() {
        queue2 = new StringQueue(2);
        boolean fullness = queue2.empty();
        boolean expectetBool = true;
        Assertions.assertEquals(expectetBool,fullness);
    }
    @Test
    public void testQueueSize_Correct() {
        int expectetSize = 20;
        int actuelSize = queue.size();
        Assertions.assertEquals(expectetSize,actuelSize);
    }
    @Test
    public void testSQueueSize_Correct() {
        int expectetSize = 20;
        int actuelSize = queue2.size();
        Assertions.assertEquals(expectetSize,actuelSize);
    }
}