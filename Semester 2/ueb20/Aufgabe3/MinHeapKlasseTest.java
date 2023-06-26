import org.junit.*;
import static org.junit.Assert.*;

public class MinHeapKlasseTest {

    @Test
    public void testOfferAndPoll() {
        MinHeapKlasse<Integer> minHeap = new MinHeapKlasse<>(10);
        minHeap.offer(5);
        minHeap.offer(3);
        minHeap.offer(7);
        minHeap.offer(1);
        minHeap.offer(9);

        assertEquals(1, (int) minHeap.poll());
        assertEquals(3, (int) minHeap.poll());
        assertEquals(5, (int) minHeap.poll());
        assertEquals(7, (int) minHeap.poll());
        assertEquals(9, (int) minHeap.poll());
        assertNull(minHeap.poll());
    }

    @Test
    public void testPollNull() {
        MinHeapKlasse<Integer> minHeap = new MinHeapKlasse<>(10);
        minHeap.offer(1);
        minHeap.offer(3);
        minHeap.offer(5);
        minHeap.offer(7);

        minHeap.poll();
        minHeap.poll();
        minHeap.poll();
        minHeap.poll();
        minHeap.poll();
        minHeap.poll();
        assertNull(minHeap.poll());
    }

    @Test
    public void testReihenfolgeOffered() {
        MinHeapKlasse<Integer> minHeap = new MinHeapKlasse<>(10);
        minHeap.offer(1);
        minHeap.offer(2);
        minHeap.offer(3);
        minHeap.offer(4);
        minHeap.offer(5);

        assertEquals(1, (int) minHeap.poll());
        assertEquals(2, (int) minHeap.poll());
        assertEquals(4, (int) minHeap.poll());
        assertEquals(3, (int) minHeap.poll());
        assertEquals(5, (int) minHeap.poll());
    }
    
    @Test
    public void testFullTest() {
        MinHeapKlasse<Integer> minHeap = new MinHeapKlasse<>(1);
        minHeap.offer(1);
       assertEquals(false, (boolean) minHeap.offer(2));
        
    }
    
    @Test
    public void testPeek() {
        MinHeapKlasse<Integer> minHeap = new MinHeapKlasse<>(10);
        assertNull(minHeap.peek());

        minHeap.offer(5);
        minHeap.offer(3);
        minHeap.offer(7);

        assertEquals(3, (int) minHeap.peek());
    }
    
    @Test
    public void testOfferLetters() {
        MinHeapKlasse<String> minHeap = new MinHeapKlasse<>(10);

        minHeap.offer("a");
        minHeap.offer("b");
        minHeap.offer("e");
        minHeap.offer("c");
        minHeap.offer("d");
    
        assertEquals("a", minHeap.poll());
        assertEquals("b", minHeap.poll());
        assertEquals("c", minHeap.poll());
        assertEquals("e", minHeap.poll());
        assertEquals("d", minHeap.poll());
        assertNull(minHeap.poll());
    }
}