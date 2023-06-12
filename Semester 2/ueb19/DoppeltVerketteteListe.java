import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Eine doppelt verkettete Liste implementiert das List-Interface und ermöglicht den Zugriff auf Elemente
 * in der Liste sowie das Hinzufügen, Entfernen und Ändern von Elementen.
 *
 * @param <E> der Typ der Elemente in der Liste
 */
public class DoppeltVerketteteListe<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Ein Knoten in der doppelt verketteten Liste.
     *
     * @param <E> der Typ der Elemente im Knoten
     */
    private static class Node<E> {
        E data;
        Node<E> previous;
        Node<E> next;

        /**
         * Erstellt einen neuen Knoten mit dem angegebenen Element, dem vorherigen Knoten und dem nächsten Knoten.
         *
         * @param element  das Element des Knotens
         * @param prev     der vorherige Knoten
         * @param next     der nächste Knoten
         */
        Node(E element, Node<E> prev, Node<E> next) {
            this.data = element;
            this.previous = prev;
            this.next = next;
        }
    }

    /**
     * Erstellt eine leere doppelt verkettete Liste.
     */
    public DoppeltVerketteteListe() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Gibt die Anzahl der Elemente in der Liste zurück.
     *
     * @return die Anzahl der Elemente in der Liste
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Überprüft, ob die Liste keine Elemente enthält.
     *
     * @return true, wenn die Liste keine Elemente enthält, ansonsten false
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Überprüft, ob die Liste ein bestimmtes Element enthält.
     *
     * @param o das Element, das überprüft werden soll
     * @return true, wenn das Element in der Liste enthalten ist, ansonsten false
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    /**
     * Gibt ein Array zurück, das alle Elemente in der Liste enthält.
     *
     * @param a das Array, in das die Elemente kopiert werden sollen
     * @param <T> der Typ des Arrays
     * @return ein Array mit den Elementen der Liste
     */
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);

        int index = 0;
        Object[] result = a;
        for (Node<E> node = head; node != null; node = node.next)
            result[index++] = node.data;

        if (a.length > size)
            a[size] = null;

        return a;
    }

    /**
     * Fügt ein Element am Ende der Liste hinzu.
     *
     * @param e das hinzuzufügende Element
     * @return true, wenn das Element erfolgreich hinzugefügt wurde, ansonsten false
     */
    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    /**
     * Entfernt das erste Vorkommen eines bestimmten Elements aus der Liste.
     *
     * @param o das zu entfernende Element
     * @return true, wenn das Element erfolgreich entfernt wurde, ansonsten false
     */
    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> node = head; node != null; node = node.next) {
                if (node.data == null) {
                    unlink(node);
                    return true;
                }
            }
        } else {
            for (Node<E> node = head; node != null; node = node.next) {
                if (o.equals(node.data)) {
                    unlink(node);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Fügt alle Elemente einer gegebenen Collection am Ende der Liste hinzu.
     *
     * @param c die Collection, deren Elemente hinzugefügt werden sollen
     * @return true, wenn die Liste erfolgreich geändert wurde, ansonsten false
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }

    /**
     * Entfernt alle Elemente aus der Liste.
     */
    @Override
    public void clear() {
        for (Node<E> node = head; node != null; ) {
            Node<E> next = node.next;
            node.data = null;
            node.next = null;
            node.previous = null;
            node = next;
        }
        head = tail = null;
        size = 0;
    }

    /**
     * Gibt das Element an einem bestimmten Index in der Liste zurück.
     *
     * @param index der Index des Elements
     * @return das Element an dem angegebenen Index
     * @throws IndexOutOfBoundsException wenn der Index ungültig ist
     */
    @Override
    public E get(int index) {
        checkElementIndex(index);
        return nodeAt(index).data;
    }

    /**
     * Ändert das Element an einem bestimmten Index in der Liste.
     *
     * @param index   der Index des Elements
     * @param element das neue Element
     * @return das alte Element an dem angegebenen Index
     * @throws IndexOutOfBoundsException wenn der Index ungültig ist
     */
    @Override
    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> node = nodeAt(index);
        E oldData = node.data;
        node.data = element;
        return oldData;
    }

    /**
     * Fügt ein Element an einem bestimmten Index in die Liste ein.
     *
     * @param index   der Index, an dem das Element eingefügt werden soll
     * @param element das einzufügende Element
     * @throws IndexOutOfBoundsException wenn der Index ungültig ist
     */
    @Override
    public void add(int index, E element) {
        checkPositionIndex(index);
        if (index == size)
            linkLast(element);
        else
            linkBefore(element, nodeAt(index));
    }

    /**
     * Entfernt das Element an einem bestimmten Index aus der Liste.
     *
     * @param index der Index des zu entfernenden Elements
     * @return das entfernte Element
     * @throws IndexOutOfBoundsException wenn der Index ungültig ist
     */
    @Override
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(nodeAt(index));
    }

    /**
     * Gibt den Index des ersten Vorkommens eines bestimmten Elements in der Liste zurück.
     *
     * @param o das Element, dessen Index gesucht wird
     * @return der Index des Elements, oder -1, wenn das Element nicht gefunden wurde
     */
    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> node = head; node != null; node = node.next) {
                if (node.data == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> node = head; node != null; node = node.next) {
                if (o.equals(node.data))
                    return index;
                index++;
            }
        }
        return -1;
    }
    
    /**
     * Fügt ein Element am Ende der Liste hinzu.
     *
     * @param element das hinzuzufügende Element
     */
    private void linkLast(E element) {
        Node<E> newNode = new Node<>(element, tail, null);
        if (tail == null)
            head = newNode;
        else
            tail.next = newNode;
        tail = newNode;
        size++;
    }

    /**
     * Fügt ein Element vor einem gegebenen Knoten in die Liste ein.
     *
     * @param element das einzufügende Element
     * @param succ    der Knoten, vor dem das Element eingefügt werden soll
     */
    private void linkBefore(E element, Node<E> succ) {
        Node<E> pred = succ.previous;
        Node<E> newNode = new Node<>(element, pred, succ);
        succ.previous = newNode;
        if (pred == null)
            head = newNode;
        else
            pred.next = newNode;
        size++;
    }

    /**
     * Entfernt einen Knoten aus der Liste.
     *
     * @param node der zu entfernende Knoten
     * @return das Element des entfernten Knotens
     */
    private E unlink(Node<E> node) {
        E element = node.data;
        Node<E> prev = node.previous;
        Node<E> next = node.next;

        if (prev == null)
            head = next;
        else {
            prev.next = next;
            node.previous = null;
        }

        if (next == null)
            tail = prev;
        else {
            next.previous = prev;
            node.next = null;
        }

        node.data = null;
        size--;
        return element;
    }

    /**
     * Gibt den Knoten an einem bestimmten Index in der Liste zurück.
     *
     * @param index der Index des Knotens
     * @return der Knoten an dem angegebenen Index
     * @throws IndexOutOfBoundsException wenn der Index ungültig ist
     */
    private Node<E> nodeAt(int index) {
        if (index < (size >> 1)) {
            Node<E> node = head;
            for (int i = 0; i < index; i++)
                node = node.next;
            return node;
        } else {
            Node<E> node = tail;
            for (int i = size - 1; i > index; i--)
                node = node.previous;
            return node;
        }
    }

    /**
     * Überprüft, ob der Index für den Zugriff auf Elemente in der Liste gültig ist.
     *
     * @param index der zu überprüfende Index
     * @throws IndexOutOfBoundsException wenn der Index ungültig ist
     */
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    /**
     * Überprüft, ob der Index für das Einfügen und Entfernen von Elementen in der Liste gültig ist.
     *
     * @param index der zu überprüfende Index
     * @throws IndexOutOfBoundsException wenn der Index ungültig ist
     */
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    /**
     * Überprüft, ob der Index ein gültiger Index für den Zugriff auf Elemente in der Liste ist.
     *
     * @param index der zu überprüfende Index
     * @return true, wenn der Index gültig ist, ansonsten false
     */
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    /**
     * Überprüft, ob der Index ein gültiger Index für das Einfügen und Entfernen von Elementen in der Liste ist.
     *
     * @param index der zu überprüfende Index
     * @return true, wenn der Index gültig ist, ansonsten false
     */
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}
