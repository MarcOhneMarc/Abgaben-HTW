import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class DoppeltVerketteteListeTest {

    @Test
    public void testSize() {
        DoppeltVerketteteListe<Integer> list = new DoppeltVerketteteListe<>();
        Assertions.assertEquals(0, list.size());

        list.add(1);
        list.add(2);
        list.add(3);

        Assertions.assertEquals(3, list.size());

        list.remove(2);

        Assertions.assertEquals(2, list.size());

        list.clear();

        Assertions.assertEquals(0, list.size());
    }

    @Test
    public void testIsEmpty() {
        DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<>();
        Assertions.assertTrue(list.isEmpty());

        list.add("A");

        Assertions.assertFalse(list.isEmpty());

        list.remove("A");

        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void testContains() {
        DoppeltVerketteteListe<Integer> list = new DoppeltVerketteteListe<>();
        Assertions.assertFalse(list.contains(1));

        list.add(1);
        list.add(2);
        list.add(3);

        Assertions.assertTrue(list.contains(2));
        Assertions.assertFalse(list.contains(4));
    }

    @Test
    public void testToArray() {
        DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<>();
        list.add("A");
        list.add("B");
        list.add("C");

        Object[] arraya = new Object[list.size()];
        list.toArray(arraya);
        Assertions.assertEquals(3, arraya.length);
        Assertions.assertEquals("A", arraya[0]);
        Assertions.assertEquals("B", arraya[1]);
        Assertions.assertEquals("C", arraya[2]);
    }

    @Test
    public void testAdd() {
        DoppeltVerketteteListe<Integer> list = new DoppeltVerketteteListe<>();
        Assertions.assertTrue(list.isEmpty());

        Assertions.assertTrue(list.add(1));
        Assertions.assertTrue(list.add(2));
        Assertions.assertTrue(list.add(3));

        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals(1, list.get(0).intValue());
        Assertions.assertEquals(2, list.get(1).intValue());
        Assertions.assertEquals(3, list.get(2).intValue());
    }

    @Test
    public void testRemove() {
        DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<>();
        Assertions.assertTrue(list.isEmpty());

        list.add("A");
        list.add("B");
        list.add("C");

        Assertions.assertEquals(3, list.size());

        Assertions.assertTrue(list.remove("B"));
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals("A", list.get(0));
        Assertions.assertEquals("C", list.get(1));

        Assertions.assertFalse(list.remove("D"));
        Assertions.assertEquals(2, list.size());
    }

    @Test
    public void testAddAll() {
        DoppeltVerketteteListe<Integer> list = new DoppeltVerketteteListe<>();
        Assertions.assertTrue(list.isEmpty());

        DoppeltVerketteteListe<Integer> otherList = new DoppeltVerketteteListe<>();
        otherList.add(1);
        otherList.add(2);
        otherList.add(3);

        Assertions.assertTrue(list.addAll(otherList));

        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals(1, list.get(0).intValue());
        Assertions.assertEquals(2, list.get(1).intValue());
        Assertions.assertEquals(3, list.get(2).intValue());
    }

    @Test
    public void testClear() {
        DoppeltVerketteteListe<Double> list = new DoppeltVerketteteListe<>();
        list.add(1.0);
        list.add(2.0);
        list.add(3.0);

        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(3, list.size());

        list.clear();

        Assertions.assertTrue(list.isEmpty());
        Assertions.assertEquals(0, list.size());
    }

    @Test
    public void testGet() {
        DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<>();
        list.add("A");
        list.add("B");
        list.add("C");

        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals("A", list.get(0));
        Assertions.assertEquals("B", list.get(1));
        Assertions.assertEquals("C", list.get(2));
    }

    @Test
    public void testSet() {
        DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<>();
        list.add("A");
        list.add("B");
        list.add("C");

        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals("B", list.set(1, "X"));
        Assertions.assertEquals("X", list.get(1));
        Assertions.assertEquals(3, list.size());
    }

    @Test
    public void testAddAtPosition() {
        DoppeltVerketteteListe<Integer> list = new DoppeltVerketteteListe<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Assertions.assertEquals(3, list.size());

        list.add(1, 5);

        Assertions.assertEquals(4, list.size());
        Assertions.assertEquals(1, list.get(0).intValue());
        Assertions.assertEquals(5, list.get(1).intValue());
        Assertions.assertEquals(2, list.get(2).intValue());
        Assertions.assertEquals(3, list.get(3).intValue());
    }

    @Test
    public void testRemoveAtPosition() {
        DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<>();
        list.add("A");
        list.add("B");
        list.add("C");

        Assertions.assertEquals(3, list.size());

        Assertions.assertEquals("B", list.remove(1));

        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals("A", list.get(0));
        Assertions.assertEquals("C", list.get(1));
    }

    @Test
    public void testIndexOf() {
        DoppeltVerketteteListe<Integer> list = new DoppeltVerketteteListe<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Assertions.assertEquals(1, list.indexOf(2));
        Assertions.assertEquals(-1, list.indexOf(4));
    }
}
